package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableFlatMapStream<T, R> extends Flowable<R> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends Stream<? extends R>> c;
    public final int d;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5127032662980523968L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Stream<? extends R>> b;
        public final int c;
        public final AtomicLong d = new AtomicLong();
        public SimpleQueue<T> e;
        public Subscription f;
        public Iterator<? extends R> g;
        public AutoCloseable h;
        public volatile boolean i;
        public volatile boolean j;
        public final AtomicThrowable k = new AtomicThrowable();
        public long l;
        public int m;
        public int n;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i2) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
        }

        public void a() {
            Throwable th;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.a;
                SimpleQueue<T> simpleQueue = this.e;
                AtomicThrowable atomicThrowable = this.k;
                Iterator<? extends R> it = this.g;
                long j2 = this.d.get();
                long j3 = this.l;
                int i2 = this.c;
                int i3 = i2 - (i2 >> 2);
                int i4 = 0;
                boolean z = true;
                boolean z2 = this.n != 1;
                long j4 = j3;
                int i5 = 1;
                long j5 = j2;
                Iterator<? extends R> it2 = it;
                while (true) {
                    if (this.i) {
                        simpleQueue.clear();
                        try {
                            this.g = null;
                            AutoCloseable autoCloseable = this.h;
                            this.h = null;
                            if (autoCloseable != null) {
                                autoCloseable.close();
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            RxJavaPlugins.onError(th2);
                        }
                    } else {
                        boolean z3 = this.j;
                        if (atomicThrowable.get() != null) {
                            subscriber.onError((Throwable) atomicThrowable.get());
                            this.i = z;
                        } else {
                            if (it2 == null) {
                                try {
                                    T poll = simpleQueue.poll();
                                    boolean z4 = poll == null;
                                    if (z3 && z4) {
                                        subscriber.onComplete();
                                        this.i = z;
                                    } else if (!z4) {
                                        if (z2) {
                                            int i6 = this.m;
                                            int i7 = z ? 1 : 0;
                                            int i8 = z ? 1 : 0;
                                            int i9 = z ? 1 : 0;
                                            int i10 = i6 + i7;
                                            this.m = i10;
                                            if (i10 == i3) {
                                                this.m = i4;
                                                this.f.request((long) i3);
                                            }
                                        }
                                        try {
                                            Object apply = this.b.apply(poll);
                                            Objects.requireNonNull(apply, "The mapper returned a null Stream");
                                            Stream stream = (Stream) apply;
                                            it2 = stream.iterator();
                                            if (it2.hasNext()) {
                                                this.g = it2;
                                                this.h = stream;
                                            } else {
                                                it2 = null;
                                            }
                                        } catch (Throwable th3) {
                                            Exceptions.throwIfFatal(th3);
                                            b(subscriber, th3);
                                        }
                                    }
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    b(subscriber, th4);
                                }
                            }
                            if (!(it2 == null || j4 == j5)) {
                                try {
                                    Object obj = (Object) it2.next();
                                    Objects.requireNonNull(obj, "The Stream.Iterator returned a null value");
                                    if (!this.i) {
                                        subscriber.onNext(obj);
                                        j4++;
                                        if (!this.i) {
                                            try {
                                                if (!it2.hasNext()) {
                                                    try {
                                                        this.g = null;
                                                        AutoCloseable autoCloseable2 = this.h;
                                                        this.h = null;
                                                        if (autoCloseable2 != null) {
                                                            autoCloseable2.close();
                                                        }
                                                        it2 = null;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        it2 = null;
                                                        Exceptions.throwIfFatal(th);
                                                        b(subscriber, th);
                                                        i4 = 0;
                                                        z = true;
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                Exceptions.throwIfFatal(th);
                                                b(subscriber, th);
                                                i4 = 0;
                                                z = true;
                                            }
                                        }
                                    }
                                } catch (Throwable th7) {
                                    Exceptions.throwIfFatal(th7);
                                    b(subscriber, th7);
                                }
                            }
                        }
                        i4 = 0;
                        z = true;
                    }
                    this.l = j4;
                    i5 = addAndGet(-i5);
                    if (i5 != 0) {
                        j5 = this.d.get();
                        i4 = 0;
                        z = true;
                    } else {
                        return;
                    }
                }
            }
        }

        public void b(Subscriber<?> subscriber, Throwable th) {
            if (this.k.compareAndSet(null, th)) {
                this.f.cancel();
                this.i = true;
                subscriber.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.i = true;
            this.f.cancel();
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.k.compareAndSet(null, th)) {
                this.j = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.n == 2 || this.e.offer(t)) {
                a();
                return;
            }
            this.f.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(@NonNull Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.n = requestFusion;
                        this.e = queueSubscription;
                        this.j = true;
                        this.a.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.n = requestFusion;
                        this.e = queueSubscription;
                        this.a.onSubscribe(this);
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.e = new SpscArrayQueue(this.c);
                this.a.onSubscribe(this);
                subscription.request((long) this.c);
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

    public FlowableFlatMapStream(Flowable<T> flowable, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        this.b = flowable;
        this.c = function;
        this.d = i;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function, int i) {
        return new a(subscriber, function, i);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.b;
        if (flowable instanceof Supplier) {
            Stream stream = null;
            try {
                Object obj = ((Supplier) flowable).get();
                if (obj != null) {
                    Object apply = this.c.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = (Stream) apply;
                }
                if (stream != null) {
                    FlowableFromStream.subscribeStream(subscriber, stream);
                } else {
                    EmptySubscription.complete(subscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } else {
            flowable.subscribe(subscribe(subscriber, this.c, this.d));
        }
    }
}
