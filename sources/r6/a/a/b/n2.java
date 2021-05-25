package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class n2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Function<? super Throwable, ? extends Perhaps<? extends T>> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -9119999967998769573L;
        public final Function<? super Throwable, ? extends Perhaps<? extends T>> a;
        public final a<T>.C0565a b = new C0565a();
        public Subscription c;

        /* renamed from: r6.a.a.b.n2$a$a  reason: collision with other inner class name */
        public final class C0565a extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = -6651374802328276829L;

            public C0565a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    a.this.d();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    a.this.h(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                ((Subscription) get()).cancel();
                lazySet(SubscriptionHelper.CANCELLED);
                a.this.complete(t);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Perhaps<? extends T>> function) {
            super(subscriber);
            this.a = function;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        public void d() {
            this.actual.onComplete();
        }

        public void h(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                ((Perhaps) ObjectHelper.requireNonNull(this.a.apply(th), "The fallbackSupplier returned a null Perhaps")).subscribe(this.b);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public n2(Perhaps<T> perhaps, Function<? super Throwable, ? extends Perhaps<? extends T>> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
