package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableDebounceTimed<T> extends s6.a.e.d.c.a.a<T, T> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;

    public static final class a<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        public final T a;
        public final long b;
        public final b<T> c;
        public final AtomicBoolean d = new AtomicBoolean();

        public a(T t, long j, b<T> bVar) {
            this.a = t;
            this.b = j;
            this.c = bVar;
        }

        public void a() {
            if (this.d.compareAndSet(false, true)) {
                b<T> bVar = this.c;
                long j = this.b;
                T t = this.a;
                if (j != bVar.g) {
                    return;
                }
                if (bVar.get() != 0) {
                    bVar.a.onNext(t);
                    BackpressureHelper.produced(bVar, 1);
                    DisposableHelper.dispose(this);
                    return;
                }
                bVar.cancel();
                bVar.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    public static final class b<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler.Worker d;
        public Subscription e;
        public Disposable f;
        public volatile long g;
        public boolean h;

        public b(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.h) {
                this.h = true;
                Disposable disposable = this.f;
                if (disposable != null) {
                    disposable.dispose();
                }
                a aVar = (a) disposable;
                if (aVar != null) {
                    aVar.a();
                }
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.h = true;
            Disposable disposable = this.f;
            if (disposable != null) {
                disposable.dispose();
            }
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.h) {
                long j = this.g + 1;
                this.g = j;
                Disposable disposable = this.f;
                if (disposable != null) {
                    disposable.dispose();
                }
                a aVar = new a(t, j, this);
                this.f = aVar;
                DisposableHelper.replace(aVar, this.d.schedule(aVar, this.b, this.c));
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }
    }

    public FlowableDebounceTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new b(new SerializedSubscriber(subscriber), this.b, this.c, this.d.createWorker()));
    }
}
