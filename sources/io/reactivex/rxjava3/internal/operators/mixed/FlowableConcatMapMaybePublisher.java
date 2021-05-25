package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class FlowableConcatMapMaybePublisher<T, R> extends Flowable<R> {
    public final Publisher<T> b;
    public final Function<? super T, ? extends MaybeSource<? extends R>> c;
    public final ErrorMode d;
    public final int e;

    public FlowableConcatMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.b = publisher;
        this.c = function;
        this.d = errorMode;
        this.e = i;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new FlowableConcatMapMaybe.a(subscriber, this.c, this.e, this.d));
    }
}
