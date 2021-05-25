package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class FlowableFromPublisher<T> extends Flowable<T> {
    public final Publisher<? extends T> b;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(subscriber);
    }
}
