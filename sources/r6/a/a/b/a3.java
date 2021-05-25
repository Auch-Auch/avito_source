package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a3<T> extends Observable<T> {
    public final Perhaps<T> a;

    public static final class a<T> extends DeferredScalarDisposable<T> implements Subscriber<T> {
        private static final long serialVersionUID = -1626180231890768109L;
        public Subscription a;

        public a(Observer<? super T> observer) {
            super(observer);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
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
            if (SubscriptionHelper.validate(this.a, subscription)) {
                this.a = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public a3(Perhaps<T> perhaps) {
        this.a = perhaps;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer));
    }
}
