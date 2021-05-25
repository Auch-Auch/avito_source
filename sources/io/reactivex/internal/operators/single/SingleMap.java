package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
public final class SingleMap<T, R> extends Single<R> {
    public final SingleSource<? extends T> a;
    public final Function<? super T, ? extends R> b;

    public static final class a<T, R> implements SingleObserver<T> {
        public final SingleObserver<? super R> a;
        public final Function<? super T, ? extends R> b;

        public a(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.a = singleObserver;
            this.b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                this.a.onSuccess(ObjectHelper.requireNonNull(this.b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.a = singleSource;
        this.b = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b));
    }
}
