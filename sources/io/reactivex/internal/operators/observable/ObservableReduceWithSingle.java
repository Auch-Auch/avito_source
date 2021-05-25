package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;
public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    public final ObservableSource<T> a;
    public final Callable<R> b;
    public final BiFunction<R, ? super T, R> c;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.a = observableSource;
        this.b = callable;
        this.c = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.a.subscribe(new ObservableReduceSeedSingle.a(singleObserver, this.c, ObjectHelper.requireNonNull(this.b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
