package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class y1<T, R> extends Perhaps<R> {
    public final Perhaps<T> b;
    public final Function<? super T, ? extends Perhaps<? extends R>> c;
    public final Function<? super Throwable, ? extends Perhaps<? extends R>> d;
    public final Supplier<? extends Perhaps<? extends R>> e;

    public static final class a<T, R> extends DeferredScalarSubscription<R> implements Subscriber<T> {
        private static final long serialVersionUID = 1417117475410404413L;
        public final Function<? super T, ? extends Perhaps<? extends R>> a;
        public final Function<? super Throwable, ? extends Perhaps<? extends R>> b;
        public final Supplier<? extends Perhaps<? extends R>> c;
        public final a<T, R>.C0634a d = new C0634a();
        public Subscription e;
        public boolean f;

        /* renamed from: r6.a.b.b.y1$a$a  reason: collision with other inner class name */
        public final class C0634a extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = -7349825169192389387L;

            public C0634a() {
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

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Perhaps<? extends R>> function, Function<? super Throwable, ? extends Perhaps<? extends R>> function2, Supplier<? extends Perhaps<? extends R>> supplier) {
            super(subscriber);
            this.a = function;
            this.b = function2;
            this.c = supplier;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.e.cancel();
            SubscriptionHelper.cancel(this.d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f) {
                try {
                    Perhaps perhaps = (Perhaps) this.c.get();
                    Objects.requireNonNull(perhaps, "The onCompleteMapper returned a null Perhaps");
                    perhaps.subscribe(this.d);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                Perhaps perhaps = (Perhaps) this.b.apply(th);
                Objects.requireNonNull(perhaps, "The onErrorMapper returned a null Perhaps");
                perhaps.subscribe(this.d);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f = true;
            try {
                Perhaps perhaps = (Perhaps) this.a.apply(t);
                Objects.requireNonNull(perhaps, "The onSuccessMapper returned a null Perhaps");
                perhaps.subscribe(this.d);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public y1(Perhaps<T> perhaps, Function<? super T, ? extends Perhaps<? extends R>> function, Function<? super Throwable, ? extends Perhaps<? extends R>> function2, Supplier<? extends Perhaps<? extends R>> supplier) {
        this.b = perhaps;
        this.c = function;
        this.d = function2;
        this.e = supplier;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
