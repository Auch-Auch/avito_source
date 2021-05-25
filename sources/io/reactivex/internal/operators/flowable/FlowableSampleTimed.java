package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSampleTimed<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final boolean e;

    public static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger h = new AtomicInteger(1);

        public a(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.c
        public void a() {
            b();
            if (this.h.decrementAndGet() == 0) {
                this.a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h.incrementAndGet() == 2) {
                b();
                if (this.h.decrementAndGet() == 0) {
                    this.a.onComplete();
                }
            }
        }
    }

    public static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public b(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.c
        public void a() {
            this.a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }
    }

    public static abstract class c<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;
        public final AtomicLong e = new AtomicLong();
        public final SequentialDisposable f = new SequentialDisposable();
        public Subscription g;

        public c(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        public abstract void a();

        public void b() {
            Object andSet = getAndSet(null);
            if (andSet == null) {
                return;
            }
            if (this.e.get() != 0) {
                this.a.onNext(andSet);
                BackpressureHelper.produced(this.e, 1);
                return;
            }
            cancel();
            this.a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.f);
            this.g.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.dispose(this.f);
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.f);
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.f;
                Scheduler scheduler = this.d;
                long j = this.b;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.c));
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.e, j);
            }
        }
    }

    public FlowableSampleTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.e) {
            this.source.subscribe((FlowableSubscriber) new a(serializedSubscriber, this.b, this.c, this.d));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(serializedSubscriber, this.b, this.c, this.d));
        }
    }
}
