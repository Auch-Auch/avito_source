package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Perhaps;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class e2<T> extends Perhaps<T> {
    public final Publisher<T> b;

    public static final class a<T> extends DeferredScalarSubscriber<T, T> {
        private static final long serialVersionUID = 1473656799413159020L;
        public boolean a;

        public a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.a) {
                return;
            }
            if (this.hasValue) {
                this.a = true;
                complete(this.value);
                return;
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.a) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.value = null;
            this.a = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.a) {
                return;
            }
            if (this.hasValue) {
                this.s.cancel();
                onError(new IndexOutOfBoundsException());
                return;
            }
            this.hasValue = true;
            this.value = t;
        }
    }

    public e2(Publisher<T> publisher) {
        this.b = publisher;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Perhaps
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
