package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
public final class MaybeError<T> extends Maybe<T> {
    public final Throwable a;

    public MaybeError(Throwable th) {
        this.a = th;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(EmptyDisposable.INSTANCE);
        maybeObserver.onError(this.a);
    }
}
