package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableThrottleLatest<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;
    public final TimeUnit c;
    public final Scheduler d;
    public final boolean e;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public final Subscriber<? super T> a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler.Worker d;
        public final boolean e;
        public final AtomicReference<T> f = new AtomicReference<>();
        public final AtomicLong g = new AtomicLong();
        public Subscription h;
        public volatile boolean i;
        public Throwable j;
        public volatile boolean k;
        public volatile boolean l;
        public long m;
        public boolean n;

        public a(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = subscriber;
            this.b = j2;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.f;
                AtomicLong atomicLong = this.g;
                Subscriber<? super T> subscriber = this.a;
                int i2 = 1;
                while (!this.k) {
                    boolean z = this.i;
                    if (!z || this.j == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            if (z2 || !this.e) {
                                atomicReference.lazySet(null);
                                subscriber.onComplete();
                            } else {
                                T andSet = atomicReference.getAndSet(null);
                                long j2 = this.m;
                                if (j2 != atomicLong.get()) {
                                    this.m = j2 + 1;
                                    subscriber.onNext(andSet);
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                                }
                            }
                            this.d.dispose();
                            return;
                        }
                        if (z2) {
                            if (this.l) {
                                this.n = false;
                                this.l = false;
                            }
                        } else if (!this.n || this.l) {
                            T andSet2 = atomicReference.getAndSet(null);
                            long j3 = this.m;
                            if (j3 != atomicLong.get()) {
                                subscriber.onNext(andSet2);
                                this.m = j3 + 1;
                                this.l = false;
                                this.n = true;
                                this.d.schedule(this, this.b, this.c);
                            } else {
                                this.h.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                                this.d.dispose();
                                return;
                            }
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet(null);
                        subscriber.onError(this.j);
                        this.d.dispose();
                        return;
                    }
                }
                atomicReference.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.k = true;
            this.h.cancel();
            this.d.dispose();
            if (getAndIncrement() == 0) {
                this.f.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.j = th;
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f.set(t);
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.g, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.l = true;
            a();
        }
    }

    public FlowableThrottleLatest(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d.createWorker(), this.e));
    }
}
