package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class FlowableTakePublisher<T> extends Flowable<T> {
    public final Publisher<T> b;
    public final long c;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.b = publisher;
        this.c = j;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new FlowableTake.a(subscriber, this.c));
    }
}
