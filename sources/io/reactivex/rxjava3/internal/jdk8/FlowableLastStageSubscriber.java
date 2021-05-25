package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import s6.a.e.d.a.a;
public final class FlowableLastStageSubscriber<T> extends a<T> {
    public final boolean c;
    public final T d;

    public FlowableLastStageSubscriber(boolean z, T t) {
        this.c = z;
        this.d = t;
    }

    @Override // s6.a.e.d.a.a
    public void afterSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!isDone()) {
            T t = this.b;
            clear();
            if (t != null) {
                complete(t);
            } else if (this.c) {
                complete(this.d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.b = t;
    }
}
