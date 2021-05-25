package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableTakeLastTimed<T> extends s6.a.e.d.c.a.a<T, T> {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final Scheduler e;
    public final int f;
    public final boolean g;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        public final Subscriber<? super T> a;
        public final long b;
        public final long c;
        public final TimeUnit d;
        public final Scheduler e;
        public final SpscLinkedArrayQueue<Object> f;
        public final boolean g;
        public Subscription h;
        public final AtomicLong i = new AtomicLong();
        public volatile boolean j;
        public volatile boolean k;
        public Throwable l;

        public a(Subscriber<? super T> subscriber, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            this.a = subscriber;
            this.b = j2;
            this.c = j3;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = new SpscLinkedArrayQueue<>(i2);
            this.g = z;
        }

        public boolean a(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.j) {
                this.f.clear();
                return true;
            } else if (!z2) {
                Throwable th = this.l;
                if (th != null) {
                    this.f.clear();
                    subscriber.onError(th);
                    return true;
                } else if (!z) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.l;
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
                boolean z = this.g;
                int i2 = 1;
                do {
                    if (this.k) {
                        if (!a(spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                            long j2 = this.i.get();
                            long j3 = 0;
                            while (true) {
                                if (!a(spscLinkedArrayQueue.peek() == null, subscriber, z)) {
                                    if (j2 != j3) {
                                        spscLinkedArrayQueue.poll();
                                        subscriber.onNext(spscLinkedArrayQueue.poll());
                                        j3++;
                                    } else if (j3 != 0) {
                                        BackpressureHelper.produced(this.i, j3);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void c(long j2, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            long j3 = this.c;
            long j4 = this.b;
            boolean z = j4 == Long.MAX_VALUE;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() < j2 - j3 || (!z && ((long) (spscLinkedArrayQueue.size() >> 1)) > j4)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.j) {
                this.j = true;
                this.h.cancel();
                if (getAndIncrement() == 0) {
                    this.f.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            c(this.e.now(this.d), this.f);
            this.k = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g) {
                c(this.e.now(this.d), this.f);
            }
            this.l = th;
            this.k = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
            long now = this.e.now(this.d);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t);
            c(now, spscLinkedArrayQueue);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
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
                BackpressureHelper.add(this.i, j2);
                b();
            }
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = i;
        this.g = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d, this.e, this.f, this.g));
    }
}
