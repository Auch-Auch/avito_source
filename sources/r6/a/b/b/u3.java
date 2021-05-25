package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class u3<T, R> extends Solo<R> {
    public final Solo<T> b;
    public final Function<? super T, ? extends Solo<? extends R>> c;
    public final Function<? super Throwable, ? extends Solo<? extends R>> d;

    public static final class a<T, R> extends DeferredScalarSubscription<R> implements Subscriber<T> {
        private static final long serialVersionUID = -7631998337002592538L;
        public final Function<? super T, ? extends Solo<? extends R>> a;
        public final Function<? super Throwable, ? extends Solo<? extends R>> b;
        public final a<T, R>.C0627a c = new C0627a();
        public Subscription d;

        /* renamed from: r6.a.b.b.u3$a$a  reason: collision with other inner class name */
        public final class C0627a extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = 5161815655607865861L;

            public C0627a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                aVar.complete(aVar.value);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.downstream.onError(th);
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

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Solo<? extends R>> function, Function<? super Throwable, ? extends Solo<? extends R>> function2) {
            super(subscriber);
            this.a = function;
            this.b = function2;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.d.cancel();
            SubscriptionHelper.cancel(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                Solo solo = (Solo) this.b.apply(th);
                Objects.requireNonNull(solo, "The onErrorMapper returned a null Solo");
                solo.subscribe(this.c);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Solo solo = (Solo) this.a.apply(t);
                Objects.requireNonNull(solo, "The onSuccessMapper returned a null Solo");
                solo.subscribe(this.c);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public u3(Solo<T> solo, Function<? super T, ? extends Solo<? extends R>> function, Function<? super Throwable, ? extends Solo<? extends R>> function2) {
        this.b = solo;
        this.c = function;
        this.d = function2;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
