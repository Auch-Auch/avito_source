package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableConcatMapScheduler<T, R> extends s6.a.e.d.c.a.a<T, R> {
    public final Function<? super T, ? extends Publisher<? extends R>> b;
    public final int c;
    public final ErrorMode d;
    public final Scheduler e;

    public static abstract class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, FlowableConcatMap.e<R>, Subscription, Runnable {
        private static final long serialVersionUID = -3511336836796789179L;
        public final FlowableConcatMap.d<R> a = new FlowableConcatMap.d<>(this);
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final int c;
        public final int d;
        public final Scheduler.Worker e;
        public Subscription f;
        public int g;
        public SimpleQueue<T> h;
        public volatile boolean i;
        public volatile boolean j;
        public final AtomicThrowable k = new AtomicThrowable();
        public volatile boolean l;
        public int m;

        public a(Function<? super T, ? extends Publisher<? extends R>> function, int i2, Scheduler.Worker worker) {
            this.b = function;
            this.c = i2;
            this.d = i2 - (i2 >> 2);
            this.e = worker;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public final void b() {
            this.l = false;
            d();
        }

        public abstract void d();

        public abstract void e();

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.i = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.m == 2 || this.h.offer(t)) {
                d();
                return;
            }
            this.f.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.h = queueSubscription;
                        this.i = true;
                        e();
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.h = queueSubscription;
                        e();
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.h = new SpscArrayQueue(this.c);
                e();
                subscription.request((long) this.c);
            }
        }
    }

    public static final class b<T, R> extends a<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        public final Subscriber<? super R> n;
        public final boolean o;

        public b(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z, Scheduler.Worker worker) {
            super(function, i, worker);
            this.n = subscriber;
            this.o = z;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void a(Throwable th) {
            if (this.k.tryAddThrowableOrReport(th)) {
                if (!this.o) {
                    this.f.cancel();
                    this.i = true;
                }
                this.l = false;
                d();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void c(R r) {
            this.n.onNext(r);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.j) {
                this.j = true;
                this.a.cancel();
                this.f.cancel();
                this.e.dispose();
                this.k.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.a
        public void d() {
            if (getAndIncrement() == 0) {
                this.e.schedule(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.a
        public void e() {
            this.n.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.k.tryAddThrowableOrReport(th)) {
                this.i = true;
                d();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.a.request(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            while (!this.j) {
                if (!this.l) {
                    boolean z = this.i;
                    if (!z || this.o || ((Throwable) this.k.get()) == null) {
                        try {
                            T poll = this.h.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.k.tryTerminateConsumer(this.n);
                                this.e.dispose();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.m != 1) {
                                        int i = this.g + 1;
                                        if (i == this.d) {
                                            this.g = 0;
                                            this.f.request((long) i);
                                        } else {
                                            this.g = i;
                                        }
                                    }
                                    if (publisher instanceof Supplier) {
                                        try {
                                            obj = ((Supplier) publisher).get();
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.k.tryAddThrowableOrReport(th);
                                            if (!this.o) {
                                                this.f.cancel();
                                                this.k.tryTerminateConsumer(this.n);
                                                this.e.dispose();
                                                return;
                                            }
                                            obj = null;
                                        }
                                        if (obj != null && !this.j) {
                                            if (this.a.isUnbounded()) {
                                                this.n.onNext(obj);
                                            } else {
                                                this.l = true;
                                                this.a.setSubscription(new FlowableConcatMap.f(obj, this.a));
                                            }
                                        }
                                    } else {
                                        this.l = true;
                                        publisher.subscribe(this.a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.f.cancel();
                                    this.k.tryAddThrowableOrReport(th2);
                                    this.k.tryTerminateConsumer(this.n);
                                    this.e.dispose();
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f.cancel();
                            this.k.tryAddThrowableOrReport(th3);
                            this.k.tryTerminateConsumer(this.n);
                            this.e.dispose();
                            return;
                        }
                    } else {
                        this.k.tryTerminateConsumer(this.n);
                        this.e.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public static final class c<T, R> extends a<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        public final Subscriber<? super R> n;
        public final AtomicInteger o = new AtomicInteger();

        public c(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, Scheduler.Worker worker) {
            super(function, i, worker);
            this.n = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void a(Throwable th) {
            if (this.k.tryAddThrowableOrReport(th)) {
                this.f.cancel();
                if (getAndIncrement() == 0) {
                    this.k.tryTerminateConsumer(this.n);
                    this.e.dispose();
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void c(R r) {
            if (f()) {
                this.n.onNext(r);
                if (!compareAndSet(1, 0)) {
                    this.k.tryTerminateConsumer(this.n);
                    this.e.dispose();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.j) {
                this.j = true;
                this.a.cancel();
                this.f.cancel();
                this.e.dispose();
                this.k.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.a
        public void d() {
            if (this.o.getAndIncrement() == 0) {
                this.e.schedule(this);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler.a
        public void e() {
            this.n.onSubscribe(this);
        }

        public boolean f() {
            return get() == 0 && compareAndSet(0, 1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.k.tryAddThrowableOrReport(th)) {
                this.a.cancel();
                if (getAndIncrement() == 0) {
                    this.k.tryTerminateConsumer(this.n);
                    this.e.dispose();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.a.request(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.j) {
                if (!this.l) {
                    boolean z = this.i;
                    try {
                        T poll = this.h.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.n.onComplete();
                            this.e.dispose();
                            return;
                        } else if (!z2) {
                            try {
                                Object apply = this.b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                Publisher publisher = (Publisher) apply;
                                if (this.m != 1) {
                                    int i = this.g + 1;
                                    if (i == this.d) {
                                        this.g = 0;
                                        this.f.request((long) i);
                                    } else {
                                        this.g = i;
                                    }
                                }
                                if (publisher instanceof Supplier) {
                                    try {
                                        Object obj = ((Supplier) publisher).get();
                                        if (obj != null && !this.j) {
                                            if (!this.a.isUnbounded()) {
                                                this.l = true;
                                                this.a.setSubscription(new FlowableConcatMap.f(obj, this.a));
                                            } else if (f()) {
                                                this.n.onNext(obj);
                                                if (!compareAndSet(1, 0)) {
                                                    this.k.tryTerminateConsumer(this.n);
                                                    this.e.dispose();
                                                    return;
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.f.cancel();
                                        this.k.tryAddThrowableOrReport(th);
                                        this.k.tryTerminateConsumer(this.n);
                                        this.e.dispose();
                                        return;
                                    }
                                } else {
                                    this.l = true;
                                    publisher.subscribe(this.a);
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f.cancel();
                                this.k.tryAddThrowableOrReport(th2);
                                this.k.tryTerminateConsumer(this.n);
                                this.e.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f.cancel();
                        this.k.tryAddThrowableOrReport(th3);
                        this.k.tryTerminateConsumer(this.n);
                        this.e.dispose();
                        return;
                    }
                }
                if (this.o.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public FlowableConcatMapScheduler(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode, Scheduler scheduler) {
        super(flowable);
        this.b = function;
        this.c = i;
        this.d = errorMode;
        this.e = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int ordinal = this.d.ordinal();
        if (ordinal == 1) {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c, false, this.e.createWorker()));
        } else if (ordinal != 2) {
            this.source.subscribe((FlowableSubscriber) new c(subscriber, this.b, this.c, this.e.createWorker()));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c, true, this.e.createWorker()));
        }
    }
}
