package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class w1<T, R> extends Perhaps<R> {
    public final Perhaps<T> b;
    public final Function<? super T, ? extends Perhaps<? extends R>> c;

    public static final class a<T, R> extends DeferredScalarSubscription<R> implements Subscriber<T> {
        private static final long serialVersionUID = 1417117475410404413L;
        public final Function<? super T, ? extends Perhaps<? extends R>> a;
        public final a<T, R>.C0631a b = new C0631a();
        public Subscription c;
        public boolean d;

        /* renamed from: r6.a.b.b.w1$a$a  reason: collision with other inner class name */
        public final class C0631a extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = -7349825169192389387L;

            public C0631a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                T t = aVar.value;
                if (t != null) {
                    aVar.complete(t);
                } else {
                    aVar.downstream.onComplete();
                }
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

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Perhaps<? extends R>> function) {
            super(subscriber);
            this.a = function;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.d) {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.d = true;
            try {
                Perhaps perhaps = (Perhaps) this.a.apply(t);
                Objects.requireNonNull(perhaps, "The mapper returned a null Perhaps");
                perhaps.subscribe(this.b);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public w1(Perhaps<T> perhaps, Function<? super T, ? extends Perhaps<? extends R>> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
