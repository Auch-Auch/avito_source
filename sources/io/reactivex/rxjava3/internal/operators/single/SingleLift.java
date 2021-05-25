package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOperator;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
public final class SingleLift<T, R> extends Single<R> {
    public final SingleSource<T> a;
    public final SingleOperator<? extends R, ? super T> b;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.a = singleSource;
        this.b = singleOperator;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: io.reactivex.rxjava3.core.SingleSource<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            SingleObserver<? super Object> apply = this.b.apply(singleObserver);
            Objects.requireNonNull(apply, "The onLift returned a null SingleObserver");
            this.a.subscribe(apply);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
