package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import org.reactivestreams.Publisher;
public final class FlowableSwitchMapCompletablePublisher<T> extends Completable {
    public final Publisher<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final boolean c;

    public FlowableSwitchMapCompletablePublisher(Publisher<T> publisher, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.a = publisher;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new FlowableSwitchMapCompletable.a(completableObserver, this.b, this.c));
    }
}
