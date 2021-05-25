package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class i0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;
    public final boolean f;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 7744982114753543953L;
        public final long a;
        public final TimeUnit b;
        public final Scheduler.Worker c;
        public final SequentialDisposable d = new SequentialDisposable();
        public final AtomicLong e = new AtomicLong();
        public final AtomicReference<T> f = new AtomicReference<>();
        public Subscription g;

        public a(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber);
            this.a = j;
            this.b = timeUnit;
            this.c = worker;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (this.e.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.g.cancel();
                this.c.dispose();
                this.f.lazySet(null);
            }
        }

        public void d() {
            T t = this.f.get();
            this.f.lazySet(null);
            if (t != null) {
                complete(t);
            } else {
                this.downstream.onComplete();
            }
            this.c.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.e.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.e.getAndSet(Long.MIN_VALUE);
            this.downstream.onError(th);
            this.c.dispose();
            this.f.lazySet(null);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long incrementAndGet = this.e.incrementAndGet();
            if (incrementAndGet >= 0) {
                this.f.lazySet(t);
                Disposable disposable = (Disposable) this.d.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.d.replace(this.c.schedule(new h0(this, incrementAndGet), this.a, this.b));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.downstream.onSubscribe(this);
                this.d.replace(this.c.schedule(new h0(this, 0), this.a, this.b));
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class b<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 7744982114753543953L;
        public final long a;
        public final TimeUnit b;
        public final Scheduler c;
        public final SequentialDisposable d = new SequentialDisposable();
        public final AtomicBoolean e = new AtomicBoolean();
        public final AtomicReference<T> f = new AtomicReference<>();
        public Subscription g;

        public b(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber);
            this.a = j;
            this.b = timeUnit;
            this.c = scheduler;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (this.e.compareAndSet(false, true)) {
                this.g.cancel();
                this.d.dispose();
                this.f.lazySet(null);
            }
        }

        public void d() {
            T t = this.f.get();
            this.f.lazySet(null);
            if (t != null) {
                complete(t);
            } else {
                this.downstream.onComplete();
            }
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.e.compareAndSet(false, true)) {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e.compareAndSet(false, true)) {
                this.downstream.onError(th);
                this.d.dispose();
                this.f.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f.lazySet(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.downstream.onSubscribe(this);
                this.d.replace(this.c.scheduleDirect(new j0(this), this.a, this.b));
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public i0(Publisher<T> publisher, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.b = publisher;
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = z;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new i0(flowable, this.c, this.d, this.e, this.f);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f) {
            this.b.subscribe(new b(serializedSubscriber, this.c, this.d, this.e));
        } else {
            this.b.subscribe(new a(serializedSubscriber, this.c, this.d, this.e.createWorker()));
        }
    }
}
