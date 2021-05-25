package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class d3<T, R> extends Perhaps<R> {
    public final Perhaps<? extends T>[] b;
    public final Function<? super Object[], ? extends R> c;

    public static final class a<T, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = 278835184144033561L;
        public final Function<? super Object[], ? extends R> a;
        public final AtomicInteger b;
        public final C0553a<T, R>[] c;
        public final Object[] d;

        /* renamed from: r6.a.a.b.d3$a$a  reason: collision with other inner class name */
        public static final class C0553a<T, R> extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = 2125487621013035317L;
            public final a<T, R> a;
            public final int b;

            public C0553a(int i, a<T, R> aVar) {
                this.b = i;
                this.a = aVar;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.a.h(this.b);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                this.a.i(this.b, th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                this.a.j(this.b, t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i) {
            super(subscriber);
            this.a = function;
            this.b = new AtomicInteger(i);
            this.c = new C0553a[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.c[i2] = new C0553a<>(i2, this);
            }
            this.d = new Object[i];
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            d(-1);
        }

        public void d(int i) {
            C0553a<T, R>[] aVarArr = this.c;
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                if (i2 != i) {
                    SubscriptionHelper.cancel(aVarArr[i2]);
                }
            }
        }

        public void h(int i) {
            if (this.d[i] == null && this.b.getAndSet(0) > 0) {
                d(i);
                Arrays.fill(this.d, this);
                this.actual.onComplete();
            }
        }

        public void i(int i, Throwable th) {
            if (this.b.getAndSet(0) > 0) {
                d(i);
                Arrays.fill(this.d, this);
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: r6.a.a.b.d3$a<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: ? super java.lang.Object[] */
        public void j(int i, T t) {
            this.d[i] = t;
            if (this.b.decrementAndGet() == 0) {
                try {
                    Object apply = this.a.apply(this.d);
                    Arrays.fill(this.d, this);
                    complete(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        public void l(Perhaps<? extends T>[] perhapsArr, int i) {
            C0553a<T, R>[] aVarArr = this.c;
            AtomicInteger atomicInteger = this.b;
            for (int i2 = 0; i2 < i && atomicInteger.get() > 0; i2++) {
                perhapsArr[i2].subscribe(aVarArr[i2]);
            }
        }
    }

    public d3(Perhaps<? extends T>[] perhapsArr, Function<? super Object[], ? extends R> function) {
        this.b = perhapsArr;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Perhaps<? extends T>[] perhapsArr = this.b;
        int length = perhapsArr.length;
        a aVar = new a(subscriber, this.c, length);
        subscriber.onSubscribe(aVar);
        aVar.l(perhapsArr, length);
    }
}
