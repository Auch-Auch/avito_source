package r6.a.b.f;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
public final class h<T> extends Observable<T> {
    public final BooleanSupplier a;
    public final ObservableSource<? extends T> b;
    public final ObservableSource<? extends T> c;

    public h(BooleanSupplier booleanSupplier, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        this.a = booleanSupplier;
        this.b = observableSource;
        this.c = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            if (this.a.getAsBoolean()) {
                this.b.subscribe(observer);
            } else {
                this.c.subscribe(observer);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
