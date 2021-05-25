package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;
public final class SingleOnErrorComplete<T> extends Maybe<T> {
    public final Single<T> a;
    public final Predicate<? super Throwable> b;

    public SingleOnErrorComplete(Single<T> single, Predicate<? super Throwable> predicate) {
        this.a = single;
        this.b = predicate;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new MaybeOnErrorComplete.OnErrorCompleteMultiObserver(maybeObserver, this.b));
    }
}
