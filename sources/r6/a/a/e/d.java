package r6.a.a.e;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.EmptyDisposable;
public final class d<T> extends Observable<T> {
    public final BooleanSupplier a;
    public final ObservableSource<? extends T> b;
    public final ObservableSource<? extends T> c;

    public d(BooleanSupplier booleanSupplier, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        this.a = booleanSupplier;
        this.b = observableSource;
        this.c = observableSource2;
    }

    @Override // io.reactivex.Observable
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
