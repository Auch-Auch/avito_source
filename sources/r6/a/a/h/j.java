package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.Pow2;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class j<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Publisher<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;
    public final int d;
    public final int e;
    public final boolean f;

    public static abstract class a<T, R> extends AtomicInteger implements Subscriber<T>, Subscription, c<T, R> {
        private static final long serialVersionUID = -208456984819517117L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final int c;
        public final int d;
        public final AtomicLong e = new AtomicLong();
        public final AtomicReferenceArray<b<T, R>> f;
        public final AtomicIntegerArray g;
        public final AtomicThrowable h = new AtomicThrowable();
        public final boolean i;
        public final AtomicLong j;
        public volatile boolean k;
        public volatile boolean l;
        public Subscription m;
        public long n;
        public long o;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
            this.d = i3;
            this.i = z;
            this.j = new AtomicLong();
            int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
            this.f = new AtomicReferenceArray<>(roundToPowerOfTwo);
            this.g = new AtomicIntegerArray(roundToPowerOfTwo + 32 + 16);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (!this.l) {
                this.l = true;
                this.m.cancel();
                e();
                f();
            }
        }

        public final void d() {
            AtomicReferenceArray<b<T, R>> atomicReferenceArray;
            AtomicLong atomicLong;
            int i2;
            long j2;
            AtomicReferenceArray<b<T, R>> atomicReferenceArray2;
            long j3 = this.n;
            AtomicReferenceArray<b<T, R>> atomicReferenceArray3 = this.f;
            int length = atomicReferenceArray3.length();
            Subscriber<? super R> subscriber = this.a;
            AtomicLong atomicLong2 = this.j;
            int i3 = 1;
            while (true) {
                long j4 = this.e.get();
                long j5 = atomicLong2.get() - this.o;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    if (i4 >= length) {
                        atomicReferenceArray = atomicReferenceArray3;
                        atomicLong = atomicLong2;
                        i2 = i3;
                        break;
                    }
                    atomicLong = atomicLong2;
                    i2 = i3;
                    if (((long) i5) >= j5) {
                        atomicReferenceArray = atomicReferenceArray3;
                        break;
                    } else if (!this.l) {
                        if (!this.k || ((Throwable) this.h.get()) == null) {
                            b<T, R> bVar = atomicReferenceArray3.get(i4);
                            if (bVar != null) {
                                i5++;
                                boolean z = bVar.g;
                                atomicReferenceArray2 = atomicReferenceArray3;
                                SimpleQueue<R> simpleQueue = bVar.h;
                                j2 = j5;
                                if (!z || (simpleQueue != null && !simpleQueue.isEmpty())) {
                                    if (simpleQueue != null) {
                                        if (j3 != j4) {
                                            try {
                                                R poll = simpleQueue.poll();
                                                if (poll != null) {
                                                    subscriber.onNext(poll);
                                                    j3++;
                                                    bVar.a();
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                this.h.addThrowable(th);
                                                this.m.cancel();
                                                e();
                                                subscriber.onError(this.h.terminate());
                                                f();
                                                return;
                                            }
                                        }
                                    }
                                    i6++;
                                } else {
                                    i(bVar);
                                    this.o++;
                                    i6++;
                                    this.m.request(1);
                                }
                            } else {
                                atomicReferenceArray2 = atomicReferenceArray3;
                                j2 = j5;
                            }
                            i4++;
                            atomicLong2 = atomicLong;
                            i3 = i2;
                            atomicReferenceArray3 = atomicReferenceArray2;
                            j5 = j2;
                        } else {
                            subscriber.onError(this.h.terminate());
                            f();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j3 != j4) {
                    long j6 = this.o;
                    long j7 = atomicLong.get();
                    if (this.k && j7 == j6) {
                        subscriber.onComplete();
                        f();
                        return;
                    } else if (((long) i6) != j5) {
                        i3 = i2;
                        atomicLong2 = atomicLong;
                        atomicReferenceArray3 = atomicReferenceArray;
                    }
                } else if (!this.l) {
                    if (this.k) {
                        if (((Throwable) this.h.get()) != null) {
                            subscriber.onError(this.h.terminate());
                            f();
                            return;
                        } else if (this.o == atomicLong.get()) {
                            subscriber.onComplete();
                            f();
                            return;
                        }
                    }
                } else {
                    return;
                }
                int i7 = get();
                if (i7 == i2) {
                    this.n = j3;
                    i7 = addAndGet(-i2);
                    if (i7 == 0) {
                        return;
                    }
                }
                i3 = i7;
                atomicLong2 = atomicLong;
                atomicReferenceArray3 = atomicReferenceArray;
            }
        }

        public final void e() {
            AtomicReferenceArray<b<T, R>> atomicReferenceArray = this.f;
            int length = atomicReferenceArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                b<T, R> bVar = atomicReferenceArray.get(i2);
                if (bVar != null) {
                    atomicReferenceArray.lazySet(i2, null);
                    SubscriptionHelper.cancel(bVar);
                }
            }
        }

        public abstract void f();

        public final void h() {
            AtomicReferenceArray<b<T, R>> atomicReferenceArray;
            int i2;
            Subscriber<? super R> subscriber;
            long j2;
            long j3;
            AtomicReferenceArray<b<T, R>> atomicReferenceArray2;
            Subscriber<? super R> subscriber2;
            long j4 = this.n;
            AtomicReferenceArray<b<T, R>> atomicReferenceArray3 = this.f;
            int length = atomicReferenceArray3.length();
            Subscriber<? super R> subscriber3 = this.a;
            AtomicLong atomicLong = this.j;
            int i3 = 1;
            while (true) {
                long j5 = this.e.get();
                while (true) {
                    if (j4 == j5) {
                        atomicReferenceArray = atomicReferenceArray3;
                        i2 = length;
                        subscriber = subscriber3;
                        break;
                    } else if (!this.l) {
                        boolean z = this.k;
                        if (!z || ((Throwable) this.h.get()) == null) {
                            long j6 = atomicLong.get();
                            long j7 = this.o;
                            long j8 = j4;
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= length) {
                                    atomicReferenceArray = atomicReferenceArray3;
                                    i2 = length;
                                    subscriber = subscriber3;
                                    break;
                                }
                                i2 = length;
                                Subscriber<? super R> subscriber4 = subscriber3;
                                if (((long) i4) + j7 >= j6) {
                                    atomicReferenceArray = atomicReferenceArray3;
                                    subscriber = subscriber4;
                                    break;
                                }
                                b<T, R> bVar = atomicReferenceArray3.get(i6);
                                if (bVar != null) {
                                    i4++;
                                    boolean z2 = bVar.g;
                                    atomicReferenceArray2 = atomicReferenceArray3;
                                    SimpleQueue<R> simpleQueue = bVar.h;
                                    j3 = j6;
                                    if (!z2 || (simpleQueue != null && !simpleQueue.isEmpty())) {
                                        if (simpleQueue != null) {
                                            while (true) {
                                                if (j8 == j5) {
                                                    break;
                                                } else if (!this.l) {
                                                    if (!z || ((Throwable) this.h.get()) == null) {
                                                        subscriber2 = subscriber4;
                                                        try {
                                                            R poll = simpleQueue.poll();
                                                            boolean z3 = poll == null;
                                                            if (z2 && z3) {
                                                                i(bVar);
                                                                j2 = j7;
                                                                this.o++;
                                                                i5++;
                                                                this.m.request(1);
                                                                break;
                                                            }
                                                            j2 = j7;
                                                            if (z3) {
                                                                break;
                                                            }
                                                            subscriber2.onNext(poll);
                                                            j8++;
                                                            bVar.a();
                                                            subscriber4 = subscriber2;
                                                            j7 = j2;
                                                        } catch (Throwable th) {
                                                            Exceptions.throwIfFatal(th);
                                                            this.h.addThrowable(th);
                                                            this.m.cancel();
                                                            e();
                                                            subscriber2.onError(this.h.terminate());
                                                            f();
                                                            return;
                                                        }
                                                    } else {
                                                        subscriber4.onError(this.h.terminate());
                                                        f();
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                            i6++;
                                            subscriber3 = subscriber2;
                                            length = i2;
                                            atomicReferenceArray3 = atomicReferenceArray2;
                                            j6 = j3;
                                            j7 = j2;
                                        } else {
                                            j2 = j7;
                                            subscriber2 = subscriber4;
                                        }
                                        i5++;
                                        i6++;
                                        subscriber3 = subscriber2;
                                        length = i2;
                                        atomicReferenceArray3 = atomicReferenceArray2;
                                        j6 = j3;
                                        j7 = j2;
                                    } else {
                                        i(bVar);
                                        this.o++;
                                        i5++;
                                        this.m.request(1);
                                    }
                                } else {
                                    atomicReferenceArray2 = atomicReferenceArray3;
                                    j3 = j6;
                                }
                                j2 = j7;
                                subscriber2 = subscriber4;
                                i6++;
                                subscriber3 = subscriber2;
                                length = i2;
                                atomicReferenceArray3 = atomicReferenceArray2;
                                j6 = j3;
                                j7 = j2;
                            }
                            long j9 = atomicLong.get();
                            long j10 = this.o;
                            if (z && j9 == j10) {
                                subscriber.onComplete();
                                f();
                                return;
                            } else if (((long) i5) + j10 == j9) {
                                j4 = j8;
                                break;
                            } else {
                                subscriber3 = subscriber;
                                j4 = j8;
                                length = i2;
                                atomicReferenceArray3 = atomicReferenceArray;
                            }
                        } else {
                            subscriber3.onError(this.h.terminate());
                            f();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j4 == j5) {
                    if (!this.l) {
                        if (this.k) {
                            if (((Throwable) this.h.get()) != null) {
                                subscriber.onError(this.h.terminate());
                                f();
                                return;
                            } else if (atomicLong.get() == this.o) {
                                subscriber.onComplete();
                                f();
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                int i7 = get();
                if (i7 == i3) {
                    this.n = j4;
                    i7 = addAndGet(-i3);
                    if (i7 == 0) {
                        return;
                    }
                }
                i3 = i7;
                subscriber3 = subscriber;
                length = i2;
                atomicReferenceArray3 = atomicReferenceArray;
            }
        }

        public final void i(b<T, R> bVar) {
            AtomicIntegerArray atomicIntegerArray = this.g;
            AtomicReferenceArray<b<T, R>> atomicReferenceArray = this.f;
            int length = atomicReferenceArray.length();
            int i2 = bVar.d;
            int i3 = length + 16;
            int i4 = atomicIntegerArray.get(i3);
            atomicReferenceArray.lazySet(i2 - 1, null);
            atomicIntegerArray.lazySet(i4, i2);
            atomicIntegerArray.lazySet(i3, (i4 + 1) & (length - 1));
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.k = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.h.addThrowable(th)) {
                this.k = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null value");
                if (!this.l) {
                    AtomicIntegerArray atomicIntegerArray = this.g;
                    AtomicReferenceArray<b<T, R>> atomicReferenceArray = this.f;
                    int length = atomicReferenceArray.length();
                    int i2 = length + 32;
                    int i3 = atomicIntegerArray.get(i2);
                    int i4 = atomicIntegerArray.get(i3);
                    if (i4 == 0) {
                        i4 = i3 + 1;
                    }
                    b<T, R> bVar = new b<>(this, this.d, i4);
                    int i5 = i4 - 1;
                    atomicReferenceArray.lazySet(i5, bVar);
                    atomicIntegerArray.lazySet(i2, (i3 + 1) & (length - 1));
                    AtomicLong atomicLong = this.j;
                    atomicLong.lazySet(atomicLong.get() + 1);
                    if (this.l) {
                        atomicReferenceArray.lazySet(i5, null);
                    } else {
                        publisher.subscribe(bVar);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.m.cancel();
                e();
                if (this.h.addThrowable(th)) {
                    this.k = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.m, subscription)) {
                this.m = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.c);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                drain();
            }
        }
    }

    public static final class b<T, R> extends AtomicReference<Subscription> implements Subscriber<R> {
        private static final long serialVersionUID = -4991009168975207961L;
        public final c<T, R> a;
        public final int b;
        public final int c;
        public final int d;
        public int e;
        public int f;
        public volatile boolean g;
        public volatile SimpleQueue<R> h;

        public b(c<T, R> cVar, int i, int i2) {
            this.a = cVar;
            this.b = i;
            this.c = i - (i >> 2);
            this.d = i2;
        }

        public void a() {
            if (this.f != 1) {
                int i = this.e + 1;
                if (i == this.c) {
                    this.e = 0;
                    ((Subscription) get()).request((long) i);
                    return;
                }
                this.e = i;
            }
        }

        public SimpleQueue<R> b() {
            SimpleQueue<R> simpleQueue = this.h;
            if (simpleQueue != null) {
                return simpleQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.b);
            this.h = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.c(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.b(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            if (this.f == 0) {
                this.a.a(this, r);
            } else {
                this.a.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.h = queueSubscription;
                        this.g = true;
                        this.a.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.h = queueSubscription;
                        subscription.request((long) this.b);
                        return;
                    }
                }
                subscription.request((long) this.b);
            }
        }
    }

    public interface c<T, R> {
        void a(b<T, R> bVar, R r);

        void b(b<T, R> bVar, Throwable th);

        void c(b<T, R> bVar);

        void drain();
    }

    public static final class d<T, R> extends a<T, R> {
        private static final long serialVersionUID = -5109342841608286301L;

        public d(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z) {
            super(subscriber, function, i, i2, z);
        }

        @Override // r6.a.a.h.j.c
        public void a(b<T, R> bVar, R r) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                bVar.b().offer(r);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j = this.e.get();
                long j2 = this.n;
                if (j2 != j) {
                    this.a.onNext(r);
                    this.n = j2 + 1;
                    bVar.a();
                } else {
                    bVar.b().offer(r);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            if (this.i) {
                h();
            } else {
                d();
            }
        }

        @Override // r6.a.a.h.j.c
        public void b(b<T, R> bVar, Throwable th) {
            i(bVar);
            if (this.h.addThrowable(th)) {
                bVar.g = true;
                this.k = true;
                this.m.cancel();
                e();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // r6.a.a.h.j.c
        public void c(b<T, R> bVar) {
            bVar.g = true;
            drain();
        }

        @Override // r6.a.a.h.j.c
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.i) {
                h();
            } else {
                d();
            }
        }

        @Override // r6.a.a.h.j.a
        public void f() {
        }
    }

    public j(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z) {
        this.b = publisher;
        this.c = function;
        this.d = i;
        this.e = i2;
        this.f = z;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new j(flowable, this.c, this.d, this.e, this.f);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new d(subscriber, this.c, this.d, this.e, this.f));
    }
}
