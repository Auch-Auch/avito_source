package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableRefCount<T> extends Flowable<T> {
    public final ConnectableFlowable<T> b;
    public final int c;
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public a g;

    public static final class a extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        public final FlowableRefCount<?> a;
        public Disposable b;
        public long c;
        public boolean d;
        public boolean e;

        public a(FlowableRefCount<?> flowableRefCount) {
            this.a = flowableRefCount;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) throws Throwable {
            DisposableHelper.replace(this, disposable);
            synchronized (this.a) {
                if (this.e) {
                    this.a.b.reset();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g(this);
        }
    }

    public static final class b<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        public final Subscriber<? super T> a;
        public final FlowableRefCount<T> b;
        public final a c;
        public Subscription d;

        public b(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, a aVar) {
            this.a = subscriber;
            this.b = flowableRefCount;
            this.c = aVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
            if (compareAndSet(false, true)) {
                FlowableRefCount<T> flowableRefCount = this.b;
                a aVar = this.c;
                synchronized (flowableRefCount) {
                    a aVar2 = flowableRefCount.g;
                    if (aVar2 != null) {
                        if (aVar2 == aVar) {
                            long j = aVar.c - 1;
                            aVar.c = j;
                            if (j == 0) {
                                if (aVar.d) {
                                    if (flowableRefCount.d == 0) {
                                        flowableRefCount.g(aVar);
                                        return;
                                    }
                                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                                    aVar.b = sequentialDisposable;
                                    sequentialDisposable.replace(flowableRefCount.f.scheduleDirect(aVar, flowableRefCount.d, flowableRefCount.e));
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.f(this.c);
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.b.f(this.c);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.d.request(j);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0, TimeUnit.NANOSECONDS, null);
    }

    public void f(a aVar) {
        synchronized (this) {
            if (this.g == aVar) {
                Disposable disposable = aVar.b;
                if (disposable != null) {
                    disposable.dispose();
                    aVar.b = null;
                }
                long j = aVar.c - 1;
                aVar.c = j;
                if (j == 0) {
                    this.g = null;
                    this.b.reset();
                }
            }
        }
    }

    public void g(a aVar) {
        synchronized (this) {
            if (aVar.c == 0 && aVar == this.g) {
                this.g = null;
                Disposable disposable = (Disposable) aVar.get();
                DisposableHelper.dispose(aVar);
                if (disposable == null) {
                    aVar.e = true;
                } else {
                    this.b.reset();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar;
        boolean z;
        Disposable disposable;
        synchronized (this) {
            aVar = this.g;
            if (aVar == null) {
                aVar = new a(this);
                this.g = aVar;
            }
            long j = aVar.c;
            if (j == 0 && (disposable = aVar.b) != null) {
                disposable.dispose();
            }
            long j2 = j + 1;
            aVar.c = j2;
            z = true;
            if (aVar.d || j2 != ((long) this.c)) {
                z = false;
            } else {
                aVar.d = true;
            }
        }
        this.b.subscribe((FlowableSubscriber) new b(subscriber, this, aVar));
        if (z) {
            this.b.connect(aVar);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = connectableFlowable;
        this.c = i;
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
    }
}
