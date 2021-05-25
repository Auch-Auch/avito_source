package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
public final class MaybeDefer<T> extends Maybe<T> {
    public final Supplier<? extends MaybeSource<? extends T>> a;

    public MaybeDefer(Supplier<? extends MaybeSource<? extends T>> supplier) {
        this.a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            Object obj = this.a.get();
            Objects.requireNonNull(obj, "The maybeSupplier returned a null MaybeSource");
            ((MaybeSource) obj).subscribe(maybeObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }
}
