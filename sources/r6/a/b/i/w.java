package r6.a.b.i;

import hu.akarnokd.rxjava3.operators.PartialCollectEmitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.Pow2;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class w<T, I, A, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Flowable<T> b;
    public final Consumer<? super PartialCollectEmitter<T, I, A, R>> c;
    public final Consumer<? super T> d;
    public final int e;

    public static final class a<T, I, A, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, PartialCollectEmitter<T, I, A, R> {
        private static final long serialVersionUID = -2029240720070492688L;
        public final Subscriber<? super R> a;
        public final Consumer<? super PartialCollectEmitter<T, I, A, R>> b;
        public final Consumer<? super T> c;
        public final int d;
        public final int e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicReferenceArray<T> g;
        public final AtomicLong h;
        public final AtomicLong i;
        public long j;
        public Subscription k;
        public volatile boolean l;
        public volatile boolean m;
        public I n;
        public A o;
        public long p;
        public int q;
        public boolean r;

        public a(Subscriber<? super R> subscriber, Consumer<? super PartialCollectEmitter<T, I, A, R>> consumer, Consumer<? super T> consumer2, int i2) {
            this.a = subscriber;
            this.b = consumer;
            this.c = consumer2;
            this.d = i2;
            this.g = new AtomicReferenceArray<>(Pow2.roundToPowerOfTwo(i2));
            this.h = new AtomicLong();
            this.i = new AtomicLong();
            this.e = i2 - (i2 >> 2);
        }

        public void a() {
            long j2 = this.j;
            long j3 = this.h.get();
            AtomicReferenceArray<T> atomicReferenceArray = this.g;
            int length = atomicReferenceArray.length() - 1;
            while (j3 != j2) {
                int i2 = ((int) j2) & length;
                try {
                    this.c.accept(atomicReferenceArray.get(i2));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                atomicReferenceArray.lazySet(i2, null);
                j2++;
            }
            this.j = j2;
            this.n = null;
            this.o = null;
        }

        public void b() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    if (!this.l) {
                        while (true) {
                            if (this.m && this.f.get() != null) {
                                this.f.tryTerminateConsumer(this.a);
                                a();
                                this.l = true;
                                break;
                            } else if (this.r) {
                                this.f.tryTerminateConsumer(this.a);
                                a();
                                this.l = true;
                                break;
                            } else {
                                long j2 = this.p;
                                long j3 = this.j;
                                try {
                                    this.b.accept(this);
                                    if (!this.r && j2 == this.p && j3 == this.j) {
                                        break;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.k.cancel();
                                    this.f.tryAddThrowableOrReport(th);
                                    this.r = true;
                                }
                            }
                        }
                    } else {
                        a();
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.l = true;
            this.k.cancel();
            this.f.tryTerminateAndReport();
            b();
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public void cleanupItem(T t) {
            try {
                this.c.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public void complete() {
            this.r = true;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public long demand() {
            return this.i.get() - this.p;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public void dropItems(int i2) {
            long j2 = this.j;
            long j3 = this.h.get();
            AtomicReferenceArray<T> atomicReferenceArray = this.g;
            int length = atomicReferenceArray.length() - 1;
            int i3 = 0;
            while (j3 != j2 && i2 != i3) {
                int i4 = ((int) j2) & length;
                try {
                    this.c.accept(atomicReferenceArray.get(i4));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                atomicReferenceArray.lazySet(i4, null);
                j2++;
                i3++;
            }
            this.j = j2;
            int i5 = this.q + i3;
            if (i5 >= this.e) {
                this.q = 0;
                this.k.request((long) i5);
                return;
            }
            this.q = i5;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public A getAccumulator() {
            return this.o;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public I getIndex() {
            return this.n;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public T getItem(int i2) {
            long j2 = this.j;
            AtomicReferenceArray<T> atomicReferenceArray = this.g;
            return atomicReferenceArray.get(((int) (j2 + ((long) i2))) & (atomicReferenceArray.length() - 1));
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public boolean isCancelled() {
            return this.l;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public boolean isComplete() {
            return this.m;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public void next(R r2) {
            long j2 = this.p;
            if (j2 != this.i.get()) {
                this.p = j2 + 1;
                this.a.onNext(r2);
                return;
            }
            this.r = true;
            throw new MissingBackpressureException();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.m = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f.tryAddThrowableOrReport(th)) {
                this.m = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            AtomicReferenceArray<T> atomicReferenceArray = this.g;
            long j2 = this.h.get();
            atomicReferenceArray.lazySet((atomicReferenceArray.length() - 1) & ((int) j2), t);
            this.h.lazySet(j2 + 1);
            b();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.k, subscription)) {
                this.k = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.d);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.i, j2);
            b();
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public void setAccumulator(A a3) {
            this.o = a3;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public void setIndex(I i2) {
            this.n = i2;
        }

        @Override // hu.akarnokd.rxjava3.operators.PartialCollectEmitter
        public int size() {
            return (int) (this.h.get() - this.j);
        }
    }

    public w(Flowable<T> flowable, Consumer<? super PartialCollectEmitter<T, I, A, R>> consumer, Consumer<? super T> consumer2, int i) {
        this.b = flowable;
        this.c = consumer;
        this.d = consumer2;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new w(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.d, this.e));
    }
}
