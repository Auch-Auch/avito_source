package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Nono;
import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class h3<T> extends Solo<T> {
    public final Solo<T> b;
    public final Nono c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 2538648456345135486L;
        public final a<T>.C0606a a = new C0606a();
        public final Nono b;
        public Subscription c;

        /* renamed from: r6.a.b.b.h3$a$a  reason: collision with other inner class name */
        public final class C0606a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = 1987312061510219761L;

            public C0606a() {
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

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, Nono nono) {
            super(subscriber);
            this.b = nono;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.a);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b.subscribe(this.a);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.value = null;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
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

    public h3(Solo<T> solo, Nono nono) {
        this.b = solo;
        this.c = nono;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
