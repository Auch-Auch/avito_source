package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;
import s6.a.e.d.a.a;
public final class FlowableSingleStageSubscriber<T> extends a<T> {
    public final boolean c;
    public final T d;

    public FlowableSingleStageSubscriber(boolean z, T t) {
        this.c = z;
        this.d = t;
    }

    @Override // s6.a.e.d.a.a
    public void afterSubscribe(Subscription subscription) {
        subscription.request(2);
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
        if (this.b != null) {
            this.b = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.b = t;
    }
}
