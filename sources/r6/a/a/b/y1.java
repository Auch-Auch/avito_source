package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class y1<T, R> extends Perhaps<R> {
    public final Perhaps<T> b;
    public final Function<? super T, ? extends Perhaps<? extends R>> c;
    public final Function<? super Throwable, ? extends Perhaps<? extends R>> d;
    public final Callable<? extends Perhaps<? extends R>> e;

    public static final class a<T, R> extends DeferredScalarSubscription<R> implements Subscriber<T> {
        private static final long serialVersionUID = 1417117475410404413L;
        public final Function<? super T, ? extends Perhaps<? extends R>> a;
        public final Function<? super Throwable, ? extends Perhaps<? extends R>> b;
        public final Callable<? extends Perhaps<? extends R>> c;
        public final a<T, R>.C0583a d = new C0583a();
        public Subscription e;
        public boolean f;

        /* renamed from: r6.a.a.b.y1$a$a  reason: collision with other inner class name */
        public final class C0583a extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = -7349825169192389387L;

            public C0583a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.a(th);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: R */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.reactivestreams.Subscriber
            public void onNext(R r) {
                a.this.value = r;
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Perhaps<? extends R>> function, Function<? super Throwable, ? extends Perhaps<? extends R>> function2, Callable<? extends Perhaps<? extends R>> callable) {
            super(subscriber);
            this.a = function;
            this.b = function2;
            this.c = callable;
        }

        public void a(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.e.cancel();
            SubscriptionHelper.cancel(this.d);
        }

        public void d() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f) {
                try {
                    ((Perhaps) ObjectHelper.requireNonNull(this.c.call(), "The onCompleteMapper returned a null Perhaps")).subscribe(this.d);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                ((Perhaps) ObjectHelper.requireNonNull(this.b.apply(th), "The onErrorMapper returned a null Perhaps")).subscribe(this.d);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f = true;
            try {
                ((Perhaps) ObjectHelper.requireNonNull(this.a.apply(t), "The onSuccessMapper returned a null Perhaps")).subscribe(this.d);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public y1(Perhaps<T> perhaps, Function<? super T, ? extends Perhaps<? extends R>> function, Function<? super Throwable, ? extends Perhaps<? extends R>> function2, Callable<? extends Perhaps<? extends R>> callable) {
        this.b = perhaps;
        this.c = function;
        this.d = function2;
        this.e = callable;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
