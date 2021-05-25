package r6.a.b.f;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
public final class k<T> extends Single<T> {
    public final BooleanSupplier a;
    public final SingleSource<? extends T> b;
    public final SingleSource<? extends T> c;

    public k(BooleanSupplier booleanSupplier, SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.a = booleanSupplier;
        this.b = singleSource;
        this.c = singleSource2;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            if (this.a.getAsBoolean()) {
                this.b.subscribe(singleObserver);
            } else {
                this.c.subscribe(singleObserver);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
