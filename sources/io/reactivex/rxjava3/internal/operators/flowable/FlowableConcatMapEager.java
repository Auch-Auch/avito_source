package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableConcatMapEager<T, R> extends s6.a.e.d.c.a.a<T, R> {
    public final Function<? super T, ? extends Publisher<? extends R>> b;
    public final int c;
    public final int d;
    public final ErrorMode e;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final int c;
        public final int d;
        public final ErrorMode e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicLong g = new AtomicLong();
        public final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> h;
        public Subscription i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile InnerQueuedSubscriber<R> l;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
            this.d = i3;
            this.e = errorMode;
            this.h = new SpscLinkedArrayQueue<>(Math.min(i3, i2));
        }

        public void a() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.l;
            this.l = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> poll = this.h.poll();
                if (poll != null) {
                    poll.cancel();
                } else {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.j) {
                this.j = true;
                this.i.cancel();
                this.f.tryTerminateAndReport();
                if (getAndIncrement() == 0) {
                    do {
                        a();
                    } while (decrementAndGet() != 0);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i2;
            long j2;
            boolean z;
            SimpleQueue<R> queue;
            int i3;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.l;
                Subscriber<? super R> subscriber = this.a;
                ErrorMode errorMode = this.e;
                int i4 = 1;
                while (true) {
                    long j3 = this.g.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (errorMode == ErrorMode.END || ((Throwable) this.f.get()) == null) {
                        boolean z2 = this.k;
                        innerQueuedSubscriber = this.h.poll();
                        if (z2 && innerQueuedSubscriber == null) {
                            this.f.tryTerminateConsumer(this.a);
                            return;
                        } else if (innerQueuedSubscriber != null) {
                            this.l = innerQueuedSubscriber;
                        }
                    } else {
                        a();
                        this.f.tryTerminateConsumer(this.a);
                        return;
                    }
                    if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                        i2 = i4;
                        j2 = 0;
                        z = false;
                    } else {
                        i2 = i4;
                        j2 = 0;
                        while (true) {
                            i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                            if (i3 == 0) {
                                break;
                            } else if (this.j) {
                                a();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f.get()) == null) {
                                boolean isDone = innerQueuedSubscriber.isDone();
                                try {
                                    R poll = queue.poll();
                                    boolean z3 = poll == null;
                                    if (isDone && z3) {
                                        this.l = null;
                                        this.i.request(1);
                                        innerQueuedSubscriber = null;
                                        z = true;
                                        break;
                                    } else if (z3) {
                                        break;
                                    } else {
                                        subscriber.onNext(poll);
                                        j2++;
                                        innerQueuedSubscriber.request(1);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.l = null;
                                    innerQueuedSubscriber.cancel();
                                    a();
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
                                this.l = null;
                                innerQueuedSubscriber.cancel();
                                a();
                                this.f.tryTerminateConsumer(this.a);
                                return;
                            }
                        }
                        z = false;
                        if (i3 == 0) {
                            if (this.j) {
                                a();
                                return;
                            } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f.get()) == null) {
                                boolean isDone2 = innerQueuedSubscriber.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    this.l = null;
                                    this.i.request(1);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                }
                            } else {
                                this.l = null;
                                innerQueuedSubscriber.cancel();
                                a();
                                this.f.tryTerminateConsumer(this.a);
                                return;
                            }
                        }
                    }
                    if (!(j2 == 0 || j3 == Long.MAX_VALUE)) {
                        this.g.addAndGet(-j2);
                    }
                    if (z) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                        i4 = i2;
                    } else {
                        i4 = addAndGet(-i2);
                        if (i4 != 0) {
                            innerQueuedSubscriber2 = innerQueuedSubscriber;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.f.tryAddThrowableOrReport(th)) {
                innerQueuedSubscriber.setDone();
                if (this.e != ErrorMode.END) {
                    this.i.cancel();
                }
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.k = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f.tryAddThrowableOrReport(th)) {
                this.k = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.d);
                if (!this.j) {
                    this.h.offer(innerQueuedSubscriber);
                    publisher.subscribe(innerQueuedSubscriber);
                    if (this.j) {
                        innerQueuedSubscriber.cancel();
                        if (getAndIncrement() == 0) {
                            do {
                                a();
                            } while (decrementAndGet() != 0);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.i.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                int i2 = this.c;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.g, j2);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        super(flowable);
        this.b = function;
        this.c = i;
        this.d = i2;
        this.e = errorMode;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.b, this.c, this.d, this.e));
    }
}
