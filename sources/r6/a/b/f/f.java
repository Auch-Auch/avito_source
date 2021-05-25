package r6.a.b.f;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
public final class f<T> extends Maybe<T> {
    public final BooleanSupplier a;
    public final MaybeSource<? extends T> b;
    public final MaybeSource<? extends T> c;

    public f(BooleanSupplier booleanSupplier, MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        this.a = booleanSupplier;
        this.b = maybeSource;
        this.c = maybeSource2;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            if (this.a.getAsBoolean()) {
                this.b.subscribe(maybeObserver);
            } else {
                this.c.subscribe(maybeObserver);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }
}
