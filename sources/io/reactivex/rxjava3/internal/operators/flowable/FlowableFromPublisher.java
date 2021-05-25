package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class FlowableFromPublisher<T> extends Flowable<T> {
    public final Publisher<? extends T> b;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.b = publisher;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(subscriber);
    }
}
