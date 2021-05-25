package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class s2<T> extends Perhaps<T> {
    public final Perhaps<T> b;
    public final Predicate<? super Throwable> c;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -1726278593241855499L;
        public final AtomicInteger a = new AtomicInteger();
        public final AtomicReference<Subscription> b = new AtomicReference<>();
        public final Perhaps<T> c;
        public final Predicate<? super Throwable> d;
        public volatile boolean e;

        public a(Subscriber<? super T> subscriber, Predicate<? super Throwable> predicate, Perhaps<T> perhaps) {
            super(subscriber);
            this.d = predicate;
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
            try {
                if (this.d.test(th)) {
                    this.e = false;
                    d();
                    return;
                }
                this.actual.onError(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
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

    public s2(Perhaps<T> perhaps, Predicate<? super Throwable> predicate) {
        this.b = perhaps;
        this.c = predicate;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber, this.c, this.b);
        subscriber.onSubscribe(aVar);
        aVar.d();
    }
}
