package r6.a.b.c;

import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class e<T> implements FlowableSubscriber<T>, io.reactivex.rxjava3.core.FlowableSubscriber<T>, Subscription {
    public final Subscriber<? super T> a;
    public Subscription b;

    public e(Subscriber<? super T> subscriber) {
        this.a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.b.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.a.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.b = subscription;
        this.a.onSubscribe(this);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.b.request(j);
    }
}
