package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class r4<T> extends Observable<T> {
    public final Solo<T> a;

    public static final class a<T> extends DeferredScalarDisposable<T> implements Subscriber<T> {
        private static final long serialVersionUID = 3162354714056564295L;
        public Subscription a;

        public a(Observer<? super T> observer) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            this.a.cancel();
            super.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(this.value);
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

    public r4(Solo<T> solo) {
        this.a = solo;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new a(observer));
    }
}
