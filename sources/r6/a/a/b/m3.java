package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class m3<T> extends Solo<T> {
    public final Solo<T> b;
    public final Publisher<?> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 2365899367123544974L;
        public final Solo<T> a;
        public final a<T>.C0563a b = new C0563a();

        /* renamed from: r6.a.a.b.m3$a$a  reason: collision with other inner class name */
        public final class C0563a extends AtomicReference<Subscription> implements Subscriber<Object> {
            private static final long serialVersionUID = -4157815870217815859L;
            public boolean a;

            public C0563a() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!this.a) {
                    this.a = true;
                    a aVar = a.this;
                    aVar.a.subscribe(aVar);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a.this.d(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                if (!this.a) {
                    this.a = true;
                    ((Subscription) get()).cancel();
                    a aVar = a.this;
                    aVar.a.subscribe(aVar);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Solo<T> solo) {
            super(subscriber);
            this.a = solo;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
        }

        public void d(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            T t = this.value;
            if (t == null) {
                this.actual.onComplete();
            } else {
                complete(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.replace(this.b, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public m3(Solo<T> solo, Publisher<?> publisher) {
        this.b = solo;
        this.c = publisher;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.b);
        subscriber.onSubscribe(aVar);
        this.c.subscribe(aVar.b);
    }
}
