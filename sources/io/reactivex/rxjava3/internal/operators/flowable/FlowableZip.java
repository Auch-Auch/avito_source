package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableZip<T, R> extends Flowable<R> {
    public final Publisher<? extends T>[] b;
    public final Iterable<? extends Publisher<? extends T>> c;
    public final Function<? super Object[], ? extends R> d;
    public final int e;
    public final boolean f;

    public static final class a<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        public final Subscriber<? super R> a;
        public final b<T, R>[] b;
        public final Function<? super Object[], ? extends R> c;
        public final AtomicLong d;
        public final AtomicThrowable e;
        public final boolean f;
        public volatile boolean g;
        public final Object[] h;

        public a(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.a = subscriber;
            this.c = function;
            this.f = z;
            b<T, R>[] bVarArr = new b[i];
            for (int i3 = 0; i3 < i; i3++) {
                bVarArr[i3] = new b<>(this, i2);
            }
            this.h = new Object[i];
            this.b = bVarArr;
            this.d = new AtomicLong();
            this.e = new AtomicThrowable();
        }

        public void a() {
            b<T, R>[] bVarArr = this.b;
            for (b<T, R> bVar : bVarArr) {
                Objects.requireNonNull(bVar);
                SubscriptionHelper.cancel(bVar);
            }
        }

        public void b() {
            int i;
            T t;
            T t2;
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.a;
                b<T, R>[] bVarArr = this.b;
                int length = bVarArr.length;
                Object[] objArr = this.h;
                int i2 = 1;
                do {
                    long j = this.d.get();
                    long j2 = 0;
                    while (true) {
                        i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (this.g) {
                            return;
                        } else {
                            if (this.f || this.e.get() == null) {
                                boolean z = false;
                                for (int i3 = 0; i3 < length; i3++) {
                                    b<T, R> bVar = bVarArr[i3];
                                    if (objArr[i3] == null) {
                                        boolean z2 = bVar.f;
                                        SimpleQueue<T> simpleQueue = bVar.d;
                                        if (simpleQueue != null) {
                                            try {
                                                t2 = simpleQueue.poll();
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                this.e.tryAddThrowableOrReport(th);
                                                if (!this.f) {
                                                    a();
                                                    this.e.tryTerminateConsumer(subscriber);
                                                    return;
                                                }
                                                t2 = null;
                                                z2 = true;
                                            }
                                        } else {
                                            t2 = null;
                                        }
                                        boolean z3 = t2 == null;
                                        if (z2 && z3) {
                                            a();
                                            this.e.tryTerminateConsumer(subscriber);
                                            return;
                                        } else if (!z3) {
                                            objArr[i3] = t2;
                                        } else {
                                            z = true;
                                        }
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                try {
                                    Object obj = (Object) this.c.apply(objArr.clone());
                                    Objects.requireNonNull(obj, "The zipper returned a null value");
                                    subscriber.onNext(obj);
                                    j2++;
                                    Arrays.fill(objArr, (Object) null);
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    a();
                                    this.e.tryAddThrowableOrReport(th2);
                                    this.e.tryTerminateConsumer(subscriber);
                                    return;
                                }
                            } else {
                                a();
                                this.e.tryTerminateConsumer(subscriber);
                                return;
                            }
                        }
                    }
                    if (i == 0) {
                        if (this.g) {
                            return;
                        }
                        if (this.f || this.e.get() == null) {
                            for (int i4 = 0; i4 < length; i4++) {
                                b<T, R> bVar2 = bVarArr[i4];
                                if (objArr[i4] == null) {
                                    boolean z4 = bVar2.f;
                                    SimpleQueue<T> simpleQueue2 = bVar2.d;
                                    if (simpleQueue2 != null) {
                                        try {
                                            t = simpleQueue2.poll();
                                        } catch (Throwable th3) {
                                            Exceptions.throwIfFatal(th3);
                                            this.e.tryAddThrowableOrReport(th3);
                                            if (!this.f) {
                                                a();
                                                this.e.tryTerminateConsumer(subscriber);
                                                return;
                                            }
                                            t = null;
                                            z4 = true;
                                        }
                                    } else {
                                        t = null;
                                    }
                                    boolean z5 = t == null;
                                    if (z4 && z5) {
                                        a();
                                        this.e.tryTerminateConsumer(subscriber);
                                        return;
                                    } else if (!z5) {
                                        objArr[i4] = t;
                                    }
                                }
                            }
                        } else {
                            a();
                            this.e.tryTerminateConsumer(subscriber);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        for (b<T, R> bVar3 : bVarArr) {
                            bVar3.request(j2);
                        }
                        if (j != Long.MAX_VALUE) {
                            this.d.addAndGet(-j2);
                        }
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.g) {
                this.g = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                b();
            }
        }
    }

    public static final class b<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        public final a<T, R> a;
        public final int b;
        public final int c;
        public SimpleQueue<T> d;
        public long e;
        public volatile boolean f;
        public int g;

        public b(a<T, R> aVar, int i) {
            this.a = aVar;
            this.b = i;
            this.c = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            this.a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a<T, R> aVar = this.a;
            if (aVar.e.tryAddThrowableOrReport(th)) {
                this.f = true;
                aVar.b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g != 2) {
                this.d.offer(t);
            }
            this.a.b();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.d = queueSubscription;
                        this.f = true;
                        this.a.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.d = queueSubscription;
                        subscription.request((long) this.b);
                        return;
                    }
                }
                this.d = new SpscArrayQueue(this.b);
                subscription.request((long) this.b);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (this.g != 1) {
                long j2 = this.e + j;
                if (j2 >= ((long) this.c)) {
                    this.e = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.e = j2;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.b = publisherArr;
        this.c = iterable;
        this.d = function;
        this.e = i;
        this.f = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher<? extends T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            i = 0;
            for (Publisher<? extends T> publisher : this.c) {
                if (i == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[((i >> 2) + i)];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, i);
                    publisherArr = publisherArr2;
                }
                publisherArr[i] = publisher;
                i++;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        a aVar = new a(subscriber, this.d, i, this.e, this.f);
        subscriber.onSubscribe(aVar);
        b<T, R>[] bVarArr = aVar.b;
        for (int i2 = 0; i2 < i && !aVar.g; i2++) {
            if (aVar.f || aVar.e.get() == null) {
                publisherArr[i2].subscribe(bVarArr[i2]);
            } else {
                return;
            }
        }
    }
}
