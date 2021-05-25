package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableConcatMap<T, R> extends s6.a.e.d.c.a.a<T, R> {
    public final Function<? super T, ? extends Publisher<? extends R>> b;
    public final int c;
    public final ErrorMode d;

    public static abstract class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, e<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;
        public final d<R> a = new d<>(this);
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final int c;
        public final int d;
        public Subscription e;
        public int f;
        public SimpleQueue<T> g;
        public volatile boolean h;
        public volatile boolean i;
        public final AtomicThrowable j = new AtomicThrowable();
        public volatile boolean k;
        public int l;

        public a(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
            this.b = function;
            this.c = i2;
            this.d = i2 - (i2 >> 2);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public final void b() {
            this.k = false;
            d();
        }

        public abstract void d();

        public abstract void e();

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.h = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.l == 2 || this.g.offer(t)) {
                d();
                return;
            }
            this.e.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.l = requestFusion;
                        this.g = queueSubscription;
                        this.h = true;
                        e();
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.l = requestFusion;
                        this.g = queueSubscription;
                        e();
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                e();
                subscription.request((long) this.c);
            }
        }
    }

    public static final class b<T, R> extends a<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        public final Subscriber<? super R> m;
        public final boolean n;

        public b(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            super(function, i);
            this.m = subscriber;
            this.n = z;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void a(Throwable th) {
            if (this.j.tryAddThrowableOrReport(th)) {
                if (!this.n) {
                    this.e.cancel();
                    this.h = true;
                }
                this.k = false;
                d();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void c(R r) {
            this.m.onNext(r);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.i) {
                this.i = true;
                this.a.cancel();
                this.e.cancel();
                this.j.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.a
        public void d() {
            Object obj;
            if (getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.k) {
                        boolean z = this.h;
                        if (!z || this.n || ((Throwable) this.j.get()) == null) {
                            try {
                                T poll = this.g.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.j.tryTerminateConsumer(this.m);
                                    return;
                                } else if (!z2) {
                                    try {
                                        Object apply = this.b.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                        Publisher publisher = (Publisher) apply;
                                        if (this.l != 1) {
                                            int i = this.f + 1;
                                            if (i == this.d) {
                                                this.f = 0;
                                                this.e.request((long) i);
                                            } else {
                                                this.f = i;
                                            }
                                        }
                                        if (publisher instanceof Supplier) {
                                            try {
                                                obj = ((Supplier) publisher).get();
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                this.j.tryAddThrowableOrReport(th);
                                                if (!this.n) {
                                                    this.e.cancel();
                                                    this.j.tryTerminateConsumer(this.m);
                                                    return;
                                                }
                                                obj = null;
                                            }
                                            if (obj == null) {
                                                continue;
                                            } else if (this.a.isUnbounded()) {
                                                this.m.onNext(obj);
                                            } else {
                                                this.k = true;
                                                this.a.setSubscription(new f(obj, this.a));
                                            }
                                        } else {
                                            this.k = true;
                                            publisher.subscribe(this.a);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.e.cancel();
                                        this.j.tryAddThrowableOrReport(th2);
                                        this.j.tryTerminateConsumer(this.m);
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.e.cancel();
                                this.j.tryAddThrowableOrReport(th3);
                                this.j.tryTerminateConsumer(this.m);
                                return;
                            }
                        } else {
                            this.j.tryTerminateConsumer(this.m);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.a
        public void e() {
            this.m.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.j.tryAddThrowableOrReport(th)) {
                this.h = true;
                d();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.a.request(j);
        }
    }

    public static final class c<T, R> extends a<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        public final Subscriber<? super R> m;
        public final AtomicInteger n = new AtomicInteger();

        public c(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            super(function, i);
            this.m = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void a(Throwable th) {
            this.e.cancel();
            HalfSerializer.onError(this.m, th, this, this.j);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.e
        public void c(R r) {
            HalfSerializer.onNext(this.m, r, this, this.j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.i) {
                this.i = true;
                this.a.cancel();
                this.e.cancel();
                this.j.tryTerminateAndReport();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.a
        public void d() {
            if (this.n.getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.k) {
                        boolean z = this.h;
                        try {
                            T poll = this.g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.m.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                                    Publisher publisher = (Publisher) apply;
                                    if (this.l != 1) {
                                        int i = this.f + 1;
                                        if (i == this.d) {
                                            this.f = 0;
                                            this.e.request((long) i);
                                        } else {
                                            this.f = i;
                                        }
                                    }
                                    if (publisher instanceof Supplier) {
                                        try {
                                            Object obj = ((Supplier) publisher).get();
                                            if (obj == null) {
                                                continue;
                                            } else if (!this.a.isUnbounded()) {
                                                this.k = true;
                                                this.a.setSubscription(new f(obj, this.a));
                                            } else if (!HalfSerializer.onNext(this.m, obj, this, this.j)) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.e.cancel();
                                            this.j.tryAddThrowableOrReport(th);
                                            this.j.tryTerminateConsumer(this.m);
                                            return;
                                        }
                                    } else {
                                        this.k = true;
                                        publisher.subscribe(this.a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.e.cancel();
                                    this.j.tryAddThrowableOrReport(th2);
                                    this.j.tryTerminateConsumer(this.m);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.e.cancel();
                            this.j.tryAddThrowableOrReport(th3);
                            this.j.tryTerminateConsumer(this.m);
                            return;
                        }
                    }
                    if (this.n.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap.a
        public void e() {
            this.m.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.cancel();
            HalfSerializer.onError(this.m, th, this, this.j);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.a.request(j);
        }
    }

    public static final class d<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;
        public final e<R> h;
        public long i;

        public d(e<R> eVar) {
            super(false);
            this.h = eVar;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j = this.i;
            if (j != 0) {
                this.i = 0;
                produced(j);
            }
            this.h.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j = this.i;
            if (j != 0) {
                this.i = 0;
                produced(j);
            }
            this.h.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.i++;
            this.h.c(r);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public interface e<T> {
        void a(Throwable th);

        void b();

        void c(T t);
    }

    public static final class f<T> extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = -7606889335172043256L;
        public final Subscriber<? super T> a;
        public final T b;

        public f(T t, Subscriber<? super T> subscriber) {
            this.b = t;
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (j > 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.a;
                subscriber.onNext(this.b);
                subscriber.onComplete();
            }
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        super(flowable);
        this.b = function;
        this.c = i;
        this.d = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        int ordinal = errorMode.ordinal();
        if (ordinal == 1) {
            return new b(subscriber, function, i, false);
        }
        if (ordinal != 2) {
            return new c(subscriber, function, i);
        }
        return new b(subscriber, function, i, true);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.b)) {
            this.source.subscribe(subscribe(subscriber, this.b, this.c, this.d));
        }
    }
}
