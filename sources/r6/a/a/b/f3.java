package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import hu.akarnokd.rxjava2.util.CompositeSubscription;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class f3<T> extends Solo<T> {
    public final Solo<? extends T>[] b;

    public static final class a<T> extends DeferredScalarSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -5477345444871880990L;
        public final CompositeSubscription a = new CompositeSubscription();
        public final AtomicBoolean b = new AtomicBoolean();

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.a.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b.compareAndSet(false, true)) {
                this.a.cancel();
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.b.compareAndSet(false, true)) {
                this.a.cancel();
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.b.compareAndSet(false, true)) {
                this.a.cancel();
                complete(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (this.a.add(subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public f3(Solo<? extends T>[] soloArr) {
        this.b = soloArr;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a(subscriber);
        subscriber.onSubscribe(aVar);
        Solo<? extends T>[] soloArr = this.b;
        for (Solo<? extends T> solo : soloArr) {
            if (solo == null) {
                aVar.onError(new NullPointerException("One of the sources is null"));
                return;
            } else {
                solo.subscribe(aVar);
            }
        }
    }
}
