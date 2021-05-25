package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableFlatMap<T, U> extends s6.a.e.d.c.a.a<T, U> {
    public final Function<? super T, ? extends Publisher<? extends U>> b;
    public final boolean c;
    public final int d;
    public final int e;

    public static final class a<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        public final long a;
        public final b<T, U> b;
        public final int c;
        public final int d;
        public volatile boolean e;
        public volatile SimpleQueue<U> f;
        public long g;
        public int h;

        public a(b<T, U> bVar, int i, long j) {
            this.a = j;
            this.b = bVar;
            this.d = i;
            this.c = i >> 2;
        }

        public void a(long j) {
            if (this.h != 1) {
                long j2 = this.g + j;
                if (j2 >= ((long) this.c)) {
                    this.g = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.g = j2;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e = true;
            this.b.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            b<T, U> bVar = this.b;
            if (bVar.h.tryAddThrowableOrReport(th)) {
                this.e = true;
                if (!bVar.c) {
                    bVar.l.cancel();
                    a<?, ?>[] andSet = bVar.j.getAndSet(b.s);
                    for (a<?, ?> aVar : andSet) {
                        Objects.requireNonNull(aVar);
                        SubscriptionHelper.cancel(aVar);
                    }
                }
                bVar.b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            if (this.h != 2) {
                b<T, U> bVar = this.b;
                if (bVar.get() != 0 || !bVar.compareAndSet(0, 1)) {
                    SimpleQueue simpleQueue = this.f;
                    if (simpleQueue == null) {
                        simpleQueue = new SpscArrayQueue(bVar.e);
                        this.f = simpleQueue;
                    }
                    if (!simpleQueue.offer(u)) {
                        bVar.onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    } else if (bVar.getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    long j = bVar.k.get();
                    SimpleQueue simpleQueue2 = this.f;
                    if (j == 0 || (simpleQueue2 != null && !simpleQueue2.isEmpty())) {
                        if (simpleQueue2 == null) {
                            simpleQueue2 = new SpscArrayQueue(bVar.e);
                            this.f = simpleQueue2;
                        }
                        if (!simpleQueue2.offer(u)) {
                            bVar.onError(new MissingBackpressureException("Inner queue full?!"));
                        }
                    } else {
                        bVar.a.onNext(u);
                        if (j != Long.MAX_VALUE) {
                            bVar.k.decrementAndGet();
                        }
                        a(1);
                    }
                    if (bVar.decrementAndGet() == 0) {
                        return;
                    }
                }
                bVar.c();
                return;
            }
            this.b.b();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.h = requestFusion;
                        this.f = queueSubscription;
                        this.e = true;
                        this.b.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.h = requestFusion;
                        this.f = queueSubscription;
                    }
                }
                subscription.request((long) this.d);
            }
        }
    }

    public static final class b<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final a<?, ?>[] r = new a[0];
        public static final a<?, ?>[] s = new a[0];
        private static final long serialVersionUID = -2117620485640801370L;
        public final Subscriber<? super U> a;
        public final Function<? super T, ? extends Publisher<? extends U>> b;
        public final boolean c;
        public final int d;
        public final int e;
        public volatile SimplePlainQueue<U> f;
        public volatile boolean g;
        public final AtomicThrowable h = new AtomicThrowable();
        public volatile boolean i;
        public final AtomicReference<a<?, ?>[]> j;
        public final AtomicLong k;
        public Subscription l;
        public long m;
        public long n;
        public int o;
        public int p;
        public final int q;

        public b(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i2, int i3) {
            AtomicReference<a<?, ?>[]> atomicReference = new AtomicReference<>();
            this.j = atomicReference;
            this.k = new AtomicLong();
            this.a = subscriber;
            this.b = function;
            this.c = z;
            this.d = i2;
            this.e = i3;
            this.q = Math.max(1, i2 >> 1);
            atomicReference.lazySet(r);
        }

        public boolean a() {
            if (this.i) {
                SimplePlainQueue<U> simplePlainQueue = this.f;
                if (simplePlainQueue != null) {
                    simplePlainQueue.clear();
                }
                return true;
            } else if (this.c || this.h.get() == null) {
                return false;
            } else {
                SimplePlainQueue<U> simplePlainQueue2 = this.f;
                if (simplePlainQueue2 != null) {
                    simplePlainQueue2.clear();
                }
                this.h.tryTerminateConsumer(this.a);
                return true;
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        public void c() {
            long j2;
            boolean z;
            long j3;
            long j4;
            a<T, U>[] aVarArr;
            int i2;
            long j5;
            Subscriber<? super U> subscriber = this.a;
            int i3 = 1;
            while (!a()) {
                SimplePlainQueue<U> simplePlainQueue = this.f;
                long j6 = this.k.get();
                boolean z2 = j6 == Long.MAX_VALUE;
                long j7 = 0;
                if (simplePlainQueue != null) {
                    long j8 = 0;
                    j2 = 0;
                    while (j6 != 0) {
                        U poll = simplePlainQueue.poll();
                        if (!a()) {
                            if (poll == null) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                            j8++;
                            j6--;
                        } else {
                            return;
                        }
                    }
                    if (j8 != 0) {
                        if (z2) {
                            j6 = Long.MAX_VALUE;
                        } else {
                            j6 = this.k.addAndGet(-j8);
                        }
                    }
                } else {
                    j2 = 0;
                }
                boolean z3 = this.g;
                SimplePlainQueue<U> simplePlainQueue2 = this.f;
                a<?, ?>[] aVarArr2 = this.j.get();
                int length = aVarArr2.length;
                if (!z3 || ((simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) || length != 0)) {
                    if (length != 0) {
                        long j9 = this.n;
                        int i4 = this.o;
                        if (length <= i4 || aVarArr2[i4].a != j9) {
                            if (length <= i4) {
                                i4 = 0;
                            }
                            for (int i5 = 0; i5 < length && aVarArr2[i4].a != j9; i5++) {
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                            }
                            this.o = i4;
                            this.n = aVarArr2[i4].a;
                        }
                        int i6 = i4;
                        boolean z4 = false;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= length) {
                                aVarArr = aVarArr2;
                                z = z4;
                                break;
                            } else if (!a()) {
                                a<T, U> aVar = aVarArr2[i6];
                                U u = null;
                                while (true) {
                                    SimpleQueue<U> simpleQueue = aVar.f;
                                    if (simpleQueue == null) {
                                        aVarArr = aVarArr2;
                                        i2 = length;
                                        break;
                                    }
                                    aVarArr = aVarArr2;
                                    i2 = length;
                                    long j10 = j7;
                                    while (j6 != j7) {
                                        if (!a()) {
                                            try {
                                                u = simpleQueue.poll();
                                                if (u == null) {
                                                    break;
                                                }
                                                subscriber.onNext(u);
                                                j6--;
                                                j10++;
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                SubscriptionHelper.cancel(aVar);
                                                this.h.tryAddThrowableOrReport(th);
                                                if (!this.c) {
                                                    this.l.cancel();
                                                }
                                                if (!a()) {
                                                    e(aVar);
                                                    i7++;
                                                    length = i2;
                                                    z4 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j10 != j7) {
                                        j6 = !z2 ? this.k.addAndGet(-j10) : Long.MAX_VALUE;
                                        aVar.a(j10);
                                        j5 = 0;
                                    } else {
                                        j5 = j7;
                                    }
                                    if (j6 == j5 || u == null) {
                                        break;
                                    }
                                    aVarArr2 = aVarArr;
                                    length = i2;
                                    j7 = 0;
                                }
                                boolean z5 = aVar.e;
                                SimpleQueue<U> simpleQueue2 = aVar.f;
                                if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    e(aVar);
                                    if (!a()) {
                                        j2++;
                                        z4 = true;
                                    } else {
                                        return;
                                    }
                                }
                                if (j6 == 0) {
                                    z = z4;
                                    break;
                                }
                                i6++;
                                length = i2;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                                i7++;
                                aVarArr2 = aVarArr;
                                j7 = 0;
                            } else {
                                return;
                            }
                        }
                        this.o = i6;
                        this.n = aVarArr[i6].a;
                        j4 = j2;
                        j3 = 0;
                    } else {
                        j3 = 0;
                        j4 = j2;
                        z = false;
                    }
                    if (j4 != j3 && !this.i) {
                        this.l.request(j4);
                    }
                    if (z) {
                        i3 = i3;
                    } else {
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    }
                } else {
                    this.h.tryTerminateConsumer(this.a);
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (!this.i) {
                this.i = true;
                this.l.cancel();
                AtomicReference<a<?, ?>[]> atomicReference = this.j;
                a<?, ?>[] aVarArr = s;
                a<?, ?>[] andSet = atomicReference.getAndSet(aVarArr);
                if (andSet != aVarArr) {
                    for (a<?, ?> aVar : andSet) {
                        Objects.requireNonNull(aVar);
                        SubscriptionHelper.cancel(aVar);
                    }
                    this.h.tryTerminateAndReport();
                }
                if (getAndIncrement() == 0 && (simplePlainQueue = this.f) != null) {
                    simplePlainQueue.clear();
                }
            }
        }

        public SimpleQueue<U> d() {
            SimplePlainQueue<U> simplePlainQueue = this.f;
            if (simplePlainQueue == null) {
                if (this.d == Integer.MAX_VALUE) {
                    simplePlainQueue = new SpscLinkedArrayQueue<>(this.e);
                } else {
                    simplePlainQueue = new SpscArrayQueue<>(this.d);
                }
                this.f = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        public void e(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.j.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (aVarArr[i2] == aVar) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            aVarArr2 = r;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                            System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.j.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.g) {
                this.g = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else if (this.h.tryAddThrowableOrReport(th)) {
                this.g = true;
                if (!this.c) {
                    a<?, ?>[] andSet = this.j.getAndSet(s);
                    for (a<?, ?> aVar : andSet) {
                        Objects.requireNonNull(aVar);
                        SubscriptionHelper.cancel(aVar);
                    }
                }
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.g) {
                try {
                    Object apply = this.b.apply(t);
                    Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    boolean z = false;
                    if (publisher instanceof Supplier) {
                        try {
                            U u = (U) ((Supplier) publisher).get();
                            if (u != null) {
                                if (get() == 0 && compareAndSet(0, 1)) {
                                    long j2 = this.k.get();
                                    SimpleQueue<U> simpleQueue = this.f;
                                    if (j2 == 0 || (simpleQueue != null && !simpleQueue.isEmpty())) {
                                        if (simpleQueue == null) {
                                            simpleQueue = d();
                                        }
                                        if (!simpleQueue.offer(u)) {
                                            onError(new MissingBackpressureException("Scalar queue full?!"));
                                        }
                                    } else {
                                        this.a.onNext(u);
                                        if (j2 != Long.MAX_VALUE) {
                                            this.k.decrementAndGet();
                                        }
                                        if (this.d != Integer.MAX_VALUE && !this.i) {
                                            int i2 = this.p + 1;
                                            this.p = i2;
                                            int i3 = this.q;
                                            if (i2 == i3) {
                                                this.p = 0;
                                                this.l.request((long) i3);
                                            }
                                        }
                                    }
                                    if (decrementAndGet() == 0) {
                                        return;
                                    }
                                } else if (!d().offer(u)) {
                                    onError(new MissingBackpressureException("Scalar queue full?!"));
                                    return;
                                } else if (getAndIncrement() != 0) {
                                    return;
                                }
                                c();
                            } else if (this.d != Integer.MAX_VALUE && !this.i) {
                                int i4 = this.p + 1;
                                this.p = i4;
                                int i5 = this.q;
                                if (i4 == i5) {
                                    this.p = 0;
                                    this.l.request((long) i5);
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.h.tryAddThrowableOrReport(th);
                            b();
                        }
                    } else {
                        int i6 = this.e;
                        long j3 = this.m;
                        this.m = 1 + j3;
                        a<?, ?> aVar = new a<>(this, i6, j3);
                        while (true) {
                            a<?, ?>[] aVarArr = this.j.get();
                            if (aVarArr != s) {
                                int length = aVarArr.length;
                                a<?, ?>[] aVarArr2 = new a[(length + 1)];
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                aVarArr2[length] = aVar;
                                if (this.j.compareAndSet(aVarArr, aVarArr2)) {
                                    z = true;
                                    break;
                                }
                            } else {
                                SubscriptionHelper.cancel(aVar);
                                break;
                            }
                        }
                        if (z) {
                            publisher.subscribe(aVar);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.l.cancel();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.a.onSubscribe(this);
                if (!this.i) {
                    int i2 = this.d;
                    if (i2 == Integer.MAX_VALUE) {
                        subscription.request(Long.MAX_VALUE);
                    } else {
                        subscription.request((long) i2);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.k, j2);
                b();
            }
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.b = function;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new b(subscriber, function, z, i, i2);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.b)) {
            this.source.subscribe((FlowableSubscriber) subscribe(subscriber, this.b, this.c, this.d, this.e));
        }
    }
}
