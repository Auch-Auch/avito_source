package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import s6.a.e.d.a.a;
public final class FlowableFirstStageSubscriber<T> extends a<T> {
    public final boolean c;
    public final T d;

    public FlowableFirstStageSubscriber(boolean z, T t) {
        this.c = z;
        this.d = t;
    }

    @Override // s6.a.e.d.a.a
    public void afterSubscribe(Subscription subscription) {
        subscription.request(1);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!isDone()) {
            clear();
            if (this.c) {
                complete(this.d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        complete(t);
    }
}
