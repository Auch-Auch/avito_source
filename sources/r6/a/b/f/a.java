package r6.a.b.f;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
public final class a extends Completable {
    public final BooleanSupplier a;
    public final CompletableSource b;
    public final CompletableSource c;

    public a(BooleanSupplier booleanSupplier, CompletableSource completableSource, CompletableSource completableSource2) {
        this.a = booleanSupplier;
        this.b = completableSource;
        this.c = completableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            if (this.a.getAsBoolean()) {
                this.b.subscribe(completableObserver);
            } else {
                this.c.subscribe(completableObserver);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}
