package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
public final class CompletableToSingle<T> extends Single<T> {
    public final CompletableSource a;
    public final Supplier<? extends T> b;
    public final T c;

    public final class a implements CompletableObserver {
        public final SingleObserver<? super T> a;

        public a(SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            T t;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Supplier<? extends T> supplier = completableToSingle.b;
            if (supplier != null) {
                try {
                    t = (Object) supplier.get();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.a.onError(th);
                    return;
                }
            } else {
                t = completableToSingle.c;
            }
            if (t == null) {
                this.a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.a.onSubscribe(disposable);
        }
    }

    public CompletableToSingle(CompletableSource completableSource, Supplier<? extends T> supplier, T t) {
        this.a = completableSource;
        this.c = t;
        this.b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }
}
