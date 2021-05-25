package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class s3<T, R> extends Solo<R> {
    public final Solo<T> b;
    public final Function<? super T, ? extends Solo<? extends R>> c;

    public static final class a<T, R> extends DeferredScalarSubscription<R> implements Subscriber<T> {
        private static final long serialVersionUID = -7631998337002592538L;
        public final Function<? super T, ? extends Solo<? extends R>> a;
        public final a<T, R>.C0573a b = new C0573a();
        public Subscription c;

        /* renamed from: r6.a.a.b.s3$a$a  reason: collision with other inner class name */
        public final class C0573a extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = 5161815655607865861L;

            public C0573a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                aVar.complete(aVar.value);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.actual.onError(th);
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

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Solo<? extends R>> function) {
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
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                ((Solo) ObjectHelper.requireNonNull(this.a.apply(t), "The mapper returned a null Solo")).subscribe(this.b);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
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

    public s3(Solo<T> solo, Function<? super T, ? extends Solo<? extends R>> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
