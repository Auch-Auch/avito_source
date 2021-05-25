package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
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
public final class t3<T, R> extends Flowable<R> {
    public final Solo<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;

    public static final class a<T, R> extends AtomicReference<Subscription> implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -3958458353930920644L;
        public final Subscriber<? super R> a;
        public final a<T, R>.C0625a b;
        public final Function<? super T, ? extends Publisher<? extends R>> c;
        public Subscription d;

        /* renamed from: r6.a.b.b.t3$a$a  reason: collision with other inner class name */
        public final class C0625a extends AtomicLong implements Subscriber<R> {
            private static final long serialVersionUID = 2003600104149898338L;
            public final Subscriber<? super R> a;

            public C0625a(Subscriber<? super R> subscriber) {
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
                a aVar = a.this;
                SubscriptionHelper.deferredSetOnce(aVar, aVar.b, subscription);
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.a = subscriber;
            this.c = function;
            this.b = new C0625a(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) this.c.apply(t);
                Objects.requireNonNull(publisher, "The mapper returned a null Publisher");
                publisher.subscribe(this.b);
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
            SubscriptionHelper.deferredRequest(this, this.b, j);
        }
    }

    public t3(Solo<T> solo, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.b = solo;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
