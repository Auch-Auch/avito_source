package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import r6.a.a.h.n;
public final class h<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends Publisher<Boolean>> c;
    public final int d;

    public static final class a<T> extends AtomicReferenceArray<T> implements FlowableSubscriber<T>, Subscription, n.a<Boolean> {
        public static final n.b.a q = new n.b.a(null);
        private static final long serialVersionUID = -1557840206706079339L;
        public final Subscriber<? super T> a;
        public final Function<? super T, ? extends Publisher<Boolean>> b;
        public final int c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicLong e = new AtomicLong();
        public final AtomicInteger f = new AtomicInteger();
        public final AtomicReference<n.b.a<Boolean>> g = new AtomicReference<>();
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

        @Override // r6.a.a.h.n.a
        public void a(Throwable th) {
            this.d.addThrowable(th);
            this.p = 2;
            e();
            f();
        }

        @Override // r6.a.a.h.n.a
        public void b() {
            this.p = 2;
            e();
            f();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // r6.a.a.h.n.a
        public void c(Boolean bool) {
            this.n = bool;
            this.p = 2;
            e();
            f();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            n.b.a<Boolean> andSet;
            if (!this.m) {
                this.m = true;
                this.h.cancel();
                n.b.a<Boolean> aVar = this.g.get();
                n.b.a<Boolean> aVar2 = q;
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
            n.b.a<Boolean> aVar = this.g.get();
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
                                        publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(obj), "The asyncPredicate returned a null value");
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.d.addThrowable(th);
                                        publisher = null;
                                    }
                                    if (publisher != null) {
                                        if (!(publisher instanceof Callable)) {
                                            n.b.a<Boolean> aVar = new n.b.a<>(this);
                                            if (this.g.compareAndSet(null, aVar)) {
                                                this.p = 1;
                                                publisher.subscribe(aVar);
                                                break;
                                            }
                                        } else {
                                            try {
                                                bool = (Boolean) ((Callable) publisher).call();
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                this.d.addThrowable(th2);
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
            this.d.addThrowable(th);
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
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

    public h(Flowable<T> flowable, Function<? super T, ? extends Publisher<Boolean>> function, int i) {
        this.b = flowable;
        this.c = function;
        this.d = i;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new h(flowable, this.c, this.d);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.d));
    }
}
