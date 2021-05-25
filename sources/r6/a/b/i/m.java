package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.Pow2;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.b.i.s;
public final class m<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends Publisher<Boolean>> c;
    public final int d;

    public static final class a<T> extends AtomicReferenceArray<T> implements FlowableSubscriber<T>, Subscription, s.a<Boolean> {
        public static final s.b.a q = new s.b.a(null);
        private static final long serialVersionUID = -1557840206706079339L;
        public final Subscriber<? super T> a;
        public final Function<? super T, ? extends Publisher<Boolean>> b;
        public final int c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicLong e = new AtomicLong();
        public final AtomicInteger f = new AtomicInteger();
        public final AtomicReference<s.b.a<Boolean>> g = new AtomicReference<>();
        public Subscription h;
        public long i;
        public long j;
        public int k;
        public volatile boolean l;
        public volatile boolean m;
        public Boolean n;
        public long o;
        public volatile int p;

        public a(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<Boolean>> function, int i2) {
            super(Pow2.roundToPowerOfTwo(i2));
            this.a = subscriber;
            this.b = function;
            this.c = i2;
        }

        @Override // r6.a.b.i.s.a
        public void a(Throwable th) {
            this.d.tryAddThrowableOrReport(th);
            this.p = 2;
            e();
            f();
        }

        @Override // r6.a.b.i.s.a
        public void b() {
            this.p = 2;
            e();
            f();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // r6.a.b.i.s.a
        public void c(Boolean bool) {
            this.n = bool;
            this.p = 2;
            e();
            f();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            s.b.a<Boolean> andSet;
            if (!this.m) {
                this.m = true;
                this.h.cancel();
                this.d.tryTerminateAndReport();
                s.b.a<Boolean> aVar = this.g.get();
                s.b.a<Boolean> aVar2 = q;
                if (!(aVar == aVar2 || (andSet = this.g.getAndSet(aVar2)) == null || andSet == aVar2)) {
                    SubscriptionHelper.cancel(andSet);
                }
                if (this.f.getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void d() {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                lazySet(i2, null);
            }
            this.n = null;
        }

        public void e() {
            s.b.a<Boolean> aVar = this.g.get();
            if (aVar != q) {
                this.g.compareAndSet(aVar, null);
            }
        }

        public void f() {
            int i2;
            Publisher publisher;
            long j2;
            int i3;
            Boolean bool;
            if (this.f.getAndIncrement() == 0) {
                int i4 = this.c;
                int i5 = i4 - (i4 >> 2);
                long j3 = this.o;
                long j4 = this.j;
                int i6 = this.k;
                int length = length() - 1;
                Subscriber<? super T> subscriber = this.a;
                int i7 = 1;
                while (true) {
                    long j5 = this.e.get();
                    long j6 = j4;
                    long j7 = j3;
                    int i8 = i6;
                    while (true) {
                        i2 = (j7 > j5 ? 1 : (j7 == j5 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.m) {
                            d();
                            return;
                        } else {
                            boolean z = this.l;
                            int i9 = ((int) j6) & length;
                            Object obj = (Object) get(i9);
                            boolean z2 = obj == 0;
                            if (!z || !z2) {
                                if (z2) {
                                    break;
                                }
                                int i10 = this.p;
                                if (i10 != 0) {
                                    if (i10 != 2) {
                                        break;
                                    }
                                    Boolean bool2 = this.n;
                                    this.n = null;
                                    if (bool2 != null && bool2.booleanValue()) {
                                        j7++;
                                        subscriber.onNext(obj);
                                    }
                                    lazySet(i9, null);
                                    j6++;
                                    i8++;
                                    if (i8 == i5) {
                                        this.h.request((long) i5);
                                        i8 = 0;
                                    }
                                    this.p = 0;
                                } else {
                                    try {
                                        Publisher publisher2 = (Publisher) this.b.apply(obj);
                                        Objects.requireNonNull(publisher2, "The asyncPredicate returned a null value");
                                        publisher = publisher2;
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.d.tryAddThrowableOrReport(th);
                                        publisher = null;
                                    }
                                    if (publisher != null) {
                                        if (!(publisher instanceof Supplier)) {
                                            s.b.a<Boolean> aVar = new s.b.a<>(this);
                                            if (this.g.compareAndSet(null, aVar)) {
                                                this.p = 1;
                                                publisher.subscribe(aVar);
                                                break;
                                            }
                                        } else {
                                            try {
                                                bool = (Boolean) ((Supplier) publisher).get();
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                this.d.tryAddThrowableOrReport(th2);
                                                bool = null;
                                            }
                                            if (bool != null && bool.booleanValue()) {
                                                subscriber.onNext(obj);
                                                j7++;
                                            }
                                        }
                                    }
                                    lazySet(i9, null);
                                    long j8 = j6 + 1;
                                    int i11 = i8 + 1;
                                    if (i11 == i5) {
                                        j2 = j8;
                                        this.h.request((long) i5);
                                        i3 = 0;
                                    } else {
                                        j2 = j8;
                                        i3 = i11;
                                    }
                                    i8 = i3;
                                    j6 = j2;
                                }
                                j5 = j5;
                            } else {
                                Throwable terminate = this.d.terminate();
                                if (terminate == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(terminate);
                                    return;
                                }
                            }
                        }
                    }
                    boolean z3 = false;
                    if (i2 == 0) {
                        if (this.m) {
                            d();
                            return;
                        }
                        boolean z4 = this.l;
                        if (get(((int) j6) & length) == null) {
                            z3 = true;
                        }
                        if (z4 && z3) {
                            Throwable terminate2 = this.d.terminate();
                            if (terminate2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(terminate2);
                                return;
                            }
                        }
                    }
                    int i12 = this.f.get();
                    if (i7 == i12) {
                        this.k = i8;
                        this.j = j6;
                        this.o = j7;
                        i12 = this.f.addAndGet(-i7);
                        if (i12 == 0) {
                            return;
                        }
                    }
                    i7 = i12;
                    i6 = i8;
                    j3 = j7;
                    j4 = j6;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.l = true;
            f();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d.tryAddThrowableOrReport(th);
            this.l = true;
            f();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j2 = this.i;
            lazySet((length() - 1) & ((int) j2), t);
            this.i = j2 + 1;
            f();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.c);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                f();
            }
        }
    }

    public m(Flowable<T> flowable, Function<? super T, ? extends Publisher<Boolean>> function, int i) {
        this.b = flowable;
        this.c = function;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new m(flowable, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.d));
    }
}
