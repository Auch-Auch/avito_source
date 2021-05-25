package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class x1<T, R> extends Flowable<R> {
    public final Perhaps<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;

    public static final class a<T, R> extends AtomicLong implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 1417117475410404413L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final a<T, R>.C0633a c;
        public Subscription d;
        public boolean e;

        /* renamed from: r6.a.b.b.x1$a$a  reason: collision with other inner class name */
        public final class C0633a extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = -7407027791505806997L;
            public final Subscriber<? super R> a;

            public C0633a(Subscriber<? super R> subscriber) {
                this.a = subscriber;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.deferredSetOnce(this, a.this, subscription);
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.a = subscriber;
            this.b = function;
            this.c = new C0633a(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
            SubscriptionHelper.cancel(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.e) {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e = true;
            try {
                Publisher publisher = (Publisher) this.b.apply(t);
                Objects.requireNonNull(publisher, "The mapper returned a null Publisher");
                publisher.subscribe(this.c);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.c, this, j);
        }
    }

    public x1(Perhaps<T> perhaps, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.b = perhaps;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
