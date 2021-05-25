package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class q2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final long c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -1726278593241855499L;
        public final AtomicInteger a = new AtomicInteger();
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final Perhaps<T> c;
        public long d;
        public volatile boolean e;

        public a(Subscriber<? super T> subscriber, long j, Perhaps<T> perhaps) {
            super(subscriber);
            this.d = j;
            this.c = perhaps;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            SubscriptionHelper.cancel(this.b);
        }

        public void d() {
            if (this.a.getAndIncrement() == 0) {
                while (!SubscriptionHelper.isCancelled(this.b.get())) {
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
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j = this.d;
            if (j != Long.MAX_VALUE) {
                long j2 = j - 1;
                if (j2 == 0) {
                    this.actual.onError(th);
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

    public q2(Perhaps<T> perhaps, long j) {
        this.b = perhaps;
        this.c = j;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.c, this.b);
        subscriber.onSubscribe(aVar);
        aVar.d();
    }
}
