package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class FlowableFlatMapSinglePublisher<T, R> extends Flowable<R> {
    public final Publisher<T> b;
    public final Function<? super T, ? extends SingleSource<? extends R>> c;
    public final boolean d;
    public final int e;

    public FlowableFlatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        this.b = publisher;
        this.c = function;
        this.d = z;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new FlowableFlatMapSingle.a(subscriber, this.c, this.d, this.e));
    }
}
