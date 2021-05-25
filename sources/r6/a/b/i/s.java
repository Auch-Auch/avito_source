package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.Pow2;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class s<T, U, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends Publisher<? extends U>> c;
    public final BiFunction<? super T, ? super U, ? extends R> d;
    public final int e;

    public interface a<U> {
        void a(Throwable th);

        void b();

        void c(U u);
    }

    public static final class b<T, U, R> extends AtomicReferenceArray<T> implements FlowableSubscriber<T>, Subscription, a<U> {
        public static final a r = new a(null);
        private static final long serialVersionUID = -1557840206706079339L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Publisher<? extends U>> b;
        public final BiFunction<? super T, ? super U, ? extends R> c;
        public final int d;
        public final AtomicThrowable e = new AtomicThrowable();
        public final AtomicLong f = new AtomicLong();
        public final AtomicInteger g = new AtomicInteger();
        public final AtomicReference<a<U>> h = new AtomicReference<>();
        public Subscription i;
        public long j;
        public long k;
        public int l;
        public volatile boolean m;
        public volatile boolean n;
        public U o;
        public long p;
        public volatile int q;

        public static final class a<U> extends AtomicReference<Subscription> implements Subscriber<U> {
            private static final long serialVersionUID = 6335578148970008248L;
            public final a<U> a;
            public boolean b;

            public a(a<U> aVar) {
                this.a = aVar;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!this.b) {
                    this.b = true;
                    this.a.b();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (!this.b) {
                    this.b = true;
                    this.a.a(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U u) {
                if (!this.b) {
                    ((Subscription) get()).cancel();
                    this.b = true;
                    this.a.c(u);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public b(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
            super(Pow2.roundToPowerOfTwo(i2));
            this.a = subscriber;
            this.b = function;
            this.c = biFunction;
            this.d = i2;
        }

        @Override // r6.a.b.i.s.a
        public void a(Throwable th) {
            this.e.tryAddThrowableOrReport(th);
            this.q = 2;
            e();
            f();
        }

        @Override // r6.a.b.i.s.a
        public void b() {
            this.q = 2;
            e();
            f();
        }

        @Override // r6.a.b.i.s.a
        public void c(U u) {
            this.o = u;
            this.q = 2;
            e();
            f();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            a<U> andSet;
            if (!this.n) {
                this.n = true;
                this.i.cancel();
                this.e.tryTerminateAndReport();
                a<U> aVar = this.h.get();
                a<U> aVar2 = r;
                if (!(aVar == aVar2 || (andSet = this.h.getAndSet(aVar2)) == null || andSet == aVar2)) {
                    SubscriptionHelper.cancel(andSet);
                }
                if (this.g.getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void d() {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                lazySet(i2, null);
            }
            this.o = null;
        }

        public void e() {
            a<U> aVar = this.h.get();
            if (aVar != r) {
                this.h.compareAndSet(aVar, null);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
            // Method dump skipped, instructions count: 339
            */
            throw new UnsupportedOperationException("Method not decompiled: r6.a.b.i.s.b.f():void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.m = true;
            f();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.e.tryAddThrowableOrReport(th);
            this.m = true;
            f();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j2 = this.j;
            lazySet((length() - 1) & ((int) j2), t);
            this.j = j2 + 1;
            f();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.d);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.f, j2);
                f();
            }
        }
    }

    public s(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        this.b = flowable;
        this.c = function;
        this.d = biFunction;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new s(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new b(subscriber, this.c, this.d, this.e));
    }
}
