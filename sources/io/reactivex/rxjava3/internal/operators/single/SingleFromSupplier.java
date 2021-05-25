package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import s6.a.e.c.b;
import s6.a.e.c.d;
public final class SingleFromSupplier<T> extends Single<T> {
    public final Supplier<? extends T> a;

    public SingleFromSupplier(Supplier<? extends T> supplier) {
        this.a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable a3 = b.a();
        singleObserver.onSubscribe(a3);
        d dVar = (d) a3;
        if (!dVar.isDisposed()) {
            try {
                Object obj = (Object) this.a.get();
                Objects.requireNonNull(obj, "The supplier returned a null value");
                if (!dVar.isDisposed()) {
                    singleObserver.onSuccess(obj);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!dVar.isDisposed()) {
                    singleObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
