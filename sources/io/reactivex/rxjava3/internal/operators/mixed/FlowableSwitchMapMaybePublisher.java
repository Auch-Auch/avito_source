package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapMaybe;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class FlowableSwitchMapMaybePublisher<T, R> extends Flowable<R> {
    public final Publisher<T> b;
    public final Function<? super T, ? extends MaybeSource<? extends R>> c;
    public final boolean d;

    public FlowableSwitchMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.b = publisher;
        this.c = function;
        this.d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new FlowableSwitchMapMaybe.a(subscriber, this.c, this.d));
    }
}
