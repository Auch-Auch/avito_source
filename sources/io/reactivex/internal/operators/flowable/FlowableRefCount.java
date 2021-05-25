package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
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
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) throws Exception {
            Disposable disposable2 = disposable;
            DisposableHelper.replace(this, disposable2);
            synchronized (this.a) {
                if (this.e) {
                    ((ResettableConnectable) this.a.b).resetIf(disposable2);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.h(this);
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
                                        flowableRefCount.h(aVar);
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
                this.b.g(this.c);
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.b.g(this.c);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
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
        ConnectableFlowable<T> connectableFlowable = this.b;
        if (connectableFlowable instanceof Disposable) {
            ((Disposable) connectableFlowable).dispose();
        } else if (connectableFlowable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableFlowable).resetIf((Disposable) aVar.get());
        }
    }

    public void g(a aVar) {
        synchronized (this) {
            if (this.b instanceof FlowablePublishClassic) {
                a aVar2 = this.g;
                if (aVar2 != null && aVar2 == aVar) {
                    this.g = null;
                    Disposable disposable = aVar.b;
                    if (disposable != null) {
                        disposable.dispose();
                        aVar.b = null;
                    }
                }
                long j = aVar.c - 1;
                aVar.c = j;
                if (j == 0) {
                    f(aVar);
                }
            } else {
                a aVar3 = this.g;
                if (aVar3 != null && aVar3 == aVar) {
                    Disposable disposable2 = aVar.b;
                    if (disposable2 != null) {
                        disposable2.dispose();
                        aVar.b = null;
                    }
                    long j2 = aVar.c - 1;
                    aVar.c = j2;
                    if (j2 == 0) {
                        this.g = null;
                        f(aVar);
                    }
                }
            }
        }
    }

    public void h(a aVar) {
        synchronized (this) {
            if (aVar.c == 0 && aVar == this.g) {
                this.g = null;
                Disposable disposable = (Disposable) aVar.get();
                DisposableHelper.dispose(aVar);
                ConnectableFlowable<T> connectableFlowable = this.b;
                if (connectableFlowable instanceof Disposable) {
                    ((Disposable) connectableFlowable).dispose();
                } else if (connectableFlowable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        aVar.e = true;
                    } else {
                        ((ResettableConnectable) connectableFlowable).resetIf(disposable);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
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
