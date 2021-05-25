package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Perhaps;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class p1<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Publisher<?> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<Object> {
        private static final long serialVersionUID = -9119999967998769573L;
        public final Perhaps<T> a;
        public final a<T>.C0622a b = new C0622a();
        public Subscription c;

        /* renamed from: r6.a.b.b.p1$a$a  reason: collision with other inner class name */
        public final class C0622a extends AtomicReference<Subscription> implements Subscriber<T> {
            private static final long serialVersionUID = -6651374802328276829L;

            public C0622a() {
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

        public a(Subscriber<? super T> subscriber, Perhaps<T> perhaps) {
            super(subscriber);
            this.a = perhaps;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.c.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = this.c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.c = subscriptionHelper;
                this.a.subscribe(this.b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = this.c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.c = subscriptionHelper;
                this.a.subscribe(this.b);
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

    public p1(Perhaps<T> perhaps, Publisher<?> publisher) {
        this.b = perhaps;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.c.subscribe(new a(subscriber, this.b));
    }
}
