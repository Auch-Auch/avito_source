package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableScanSeed<T, R> extends s6.a.e.d.c.a.a<T, R> {
    public final BiFunction<R, ? super T, R> b;
    public final Supplier<R> c;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        public final Subscriber<? super R> a;
        public final BiFunction<R, ? super T, R> b;
        public final SimplePlainQueue<R> c;
        public final AtomicLong d = new AtomicLong();
        public final int e;
        public final int f;
        public volatile boolean g;
        public volatile boolean h;
        public Throwable i;
        public Subscription j;
        public R k;
        public int l;

        public a(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i2) {
            this.a = subscriber;
            this.b = biFunction;
            this.k = r;
            this.e = i2;
            this.f = i2 - (i2 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i2);
            this.c = spscArrayQueue;
            spscArrayQueue.offer(r);
        }

        public void a() {
            int i2;
            Throwable th;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.a;
                SimplePlainQueue<R> simplePlainQueue = this.c;
                int i3 = this.f;
                int i4 = this.l;
                int i5 = 1;
                do {
                    long j2 = this.d.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.g) {
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z = this.h;
                            if (!z || (th = this.i) == null) {
                                R poll = simplePlainQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    subscriber.onComplete();
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    subscriber.onNext(poll);
                                    j3++;
                                    i4++;
                                    if (i4 == i3) {
                                        this.j.request((long) i3);
                                        i4 = 0;
                                    }
                                }
                            } else {
                                simplePlainQueue.clear();
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    if (i2 == 0 && this.h) {
                        Throwable th2 = this.i;
                        if (th2 != null) {
                            simplePlainQueue.clear();
                            subscriber.onError(th2);
                            return;
                        } else if (simplePlainQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.produced(this.d, j3);
                    }
                    this.l = i4;
                    i5 = addAndGet(-i5);
                } while (i5 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.g = true;
            this.j.cancel();
            if (getAndIncrement() == 0) {
                this.c.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.h) {
                this.h = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.i = th;
            this.h = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.h) {
                try {
                    R apply = this.b.apply(this.k, t);
                    Objects.requireNonNull(apply, "The accumulator returned a null value");
                    this.k = apply;
                    this.c.offer(apply);
                    a();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.j.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) (this.e - 1));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.d, j2);
                a();
            }
        }
    }

    public FlowableScanSeed(Flowable<T> flowable, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        this.b = biFunction;
        this.c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            R r = this.c.get();
            Objects.requireNonNull(r, "The seed supplied is null");
            this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, r, Flowable.bufferSize()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
