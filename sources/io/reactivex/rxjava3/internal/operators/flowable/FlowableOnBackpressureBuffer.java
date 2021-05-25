package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableOnBackpressureBuffer<T> extends s6.a.e.d.c.a.a<T, T> {
    public final int b;
    public final boolean c;
    public final boolean d;
    public final Action e;

    public static final class a<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        public final Subscriber<? super T> a;
        public final SimplePlainQueue<T> b;
        public final boolean c;
        public final Action d;
        public Subscription e;
        public volatile boolean f;
        public volatile boolean g;
        public Throwable h;
        public final AtomicLong i = new AtomicLong();
        public boolean j;

        public a(Subscriber<? super T> subscriber, int i2, boolean z, boolean z2, Action action) {
            SimplePlainQueue<T> simplePlainQueue;
            this.a = subscriber;
            this.d = action;
            this.c = z2;
            if (z) {
                simplePlainQueue = new SpscLinkedArrayQueue<>(i2);
            } else {
                simplePlainQueue = new SpscArrayQueue<>(i2);
            }
            this.b = simplePlainQueue;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.f) {
                this.f = true;
                this.e.cancel();
                if (!this.j && getAndIncrement() == 0) {
                    this.b.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.b.clear();
        }

        public boolean d(boolean z, boolean z2, Subscriber<? super T> subscriber) {
            if (this.f) {
                this.b.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.c) {
                    Throwable th = this.h;
                    if (th != null) {
                        this.b.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.h;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void drain() {
            int i2;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.b;
                Subscriber<? super T> subscriber = this.a;
                int i3 = 1;
                while (!d(this.g, simplePlainQueue.isEmpty(), subscriber)) {
                    long j2 = this.i.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.g;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (!d(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !d(this.g, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                            this.i.addAndGet(-j3);
                        }
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.g = true;
            if (this.j) {
                this.a.onComplete();
            } else {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.h = th;
            this.g = true;
            if (this.j) {
                this.a.onError(th);
            } else {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.b.offer(t)) {
                this.e.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.d.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.j) {
                this.a.onNext(null);
            } else {
                drain();
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

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return this.b.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (!this.j && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.i, j2);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.j = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i, boolean z, boolean z2, Action action) {
        super(flowable);
        this.b = i;
        this.c = z;
        this.d = z2;
        this.e = action;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d, this.e));
    }
}
