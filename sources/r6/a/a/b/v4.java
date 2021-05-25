package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class v4<T, R> extends Solo<R> {
    public final Solo<? extends T>[] b;
    public final Function<? super Object[], ? extends R> c;

    public static final class a<T, R> extends DeferredScalarSubscription<R> {
        private static final long serialVersionUID = -4130106888008958190L;
        public final Function<? super Object[], ? extends R> a;
        public final Object[] b;
        public final C0579a<T, R>[] c;
        public final AtomicInteger d;

        /* renamed from: r6.a.a.b.v4$a$a  reason: collision with other inner class name */
        public static final class C0579a<T, R> extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = -4715238780191248967L;
            public final int a;
            public final a<T, R> b;

            public C0579a(int i, a<T, R> aVar) {
                this.a = i;
                this.b = aVar;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                this.b.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                this.b.d(this.a, t);
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
            this.b = new Object[i];
            C0579a<T, R>[] aVarArr = new C0579a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = new C0579a<>(i2, this);
            }
            this.c = aVarArr;
            this.d = new AtomicInteger(i);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            if (this.d.getAndSet(0) > 0) {
                Arrays.fill(this.b, (Object) null);
                C0579a<T, R>[] aVarArr = this.c;
                for (C0579a<T, R> aVar : aVarArr) {
                    Objects.requireNonNull(aVar);
                    SubscriptionHelper.cancel(aVar);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: r6.a.a.b.v4$a<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: ? super java.lang.Object[] */
        public void d(int i, T t) {
            this.b[i] = t;
            if (this.d.decrementAndGet() == 0) {
                try {
                    Object requireNonNull = ObjectHelper.requireNonNull(this.a.apply(this.b), "The zipper returned a null value");
                    Arrays.fill(this.b, (Object) null);
                    complete(requireNonNull);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    Arrays.fill(this.b, (Object) null);
                    this.actual.onError(th);
                }
            }
        }

        public void h(Solo<? extends T>[] soloArr, int i) {
            AtomicInteger atomicInteger = this.d;
            C0579a<T, R>[] aVarArr = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (atomicInteger.get() > 0) {
                    Solo<? extends T> solo = soloArr[i2];
                    if (solo == null) {
                        onError(new NullPointerException("One of the source Solo is null"));
                        return;
                    }
                    solo.subscribe(aVarArr[i2]);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.d.getAndSet(0) > 0) {
                Arrays.fill(this.b, (Object) null);
                C0579a<T, R>[] aVarArr = this.c;
                for (C0579a<T, R> aVar : aVarArr) {
                    Objects.requireNonNull(aVar);
                    SubscriptionHelper.cancel(aVar);
                }
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    public v4(Solo<? extends T>[] soloArr, Function<? super Object[], ? extends R> function) {
        this.b = soloArr;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Solo<? extends T>[] soloArr = this.b;
        int length = soloArr.length;
        a aVar = new a(subscriber, this.c, length);
        subscriber.onSubscribe(aVar);
        aVar.h(soloArr, length);
    }
}
