package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class g4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Function<? super Throwable, ? extends Solo<T>> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -7631998337002592538L;
        public final Function<? super Throwable, ? extends Solo<T>> a;
        public final a<T>.C0554a b = new C0554a();
        public Subscription c;

        /* renamed from: r6.a.a.b.g4$a$a  reason: collision with other inner class name */
        public final class C0554a extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = 5161815655607865861L;

            public C0554a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a.this.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                a.this.value = t;
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Solo<T>> function) {
            super(subscriber);
            this.a = function;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
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
                ((Solo) ObjectHelper.requireNonNull(this.a.apply(th), "The errorHandler returned a null Solo")).subscribe(this.b);
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

    public g4(Solo<T> solo, Function<? super Throwable, ? extends Solo<T>> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
