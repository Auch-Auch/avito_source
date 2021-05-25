package r6.a.b.b;

import hu.akarnokd.rxjava3.basetypes.Solo;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class j4<T> extends Solo<T> {
    public final Solo<T> b;
    public final long c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -1726278593241855499L;
        public final AtomicInteger a = new AtomicInteger();
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final Solo<T> c;
        public long d;
        public volatile boolean e;

        public a(Subscriber<? super T> subscriber, long j, Solo<T> solo) {
            super(subscriber);
            this.d = j;
            this.c = solo;
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        public void d() {
            if (this.a.getAndIncrement() == 0) {
                while (SubscriptionHelper.CANCELLED != this.b.get()) {
                    if (!this.e) {
                        this.e = true;
                        this.c.subscribe(this);
                    }
                    if (this.a.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            T t = this.value;
            if (t != null) {
                this.value = null;
                complete(t);
                return;
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j = this.d;
            if (j != Long.MAX_VALUE) {
                long j2 = j - 1;
                if (j2 == 0) {
                    this.downstream.onError(th);
                    return;
                }
                this.d = j2;
            }
            this.e = false;
            d();
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

    public j4(Solo<T> solo, long j) {
        this.b = solo;
        this.c = j;
    }

    @Override // hu.akarnokd.rxjava3.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.c, this.b);
        subscriber.onSubscribe(aVar);
        aVar.d();
    }
}
