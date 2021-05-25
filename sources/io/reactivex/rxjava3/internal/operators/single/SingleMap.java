package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
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

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.a.onSuccess(apply);
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

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b));
    }
}
