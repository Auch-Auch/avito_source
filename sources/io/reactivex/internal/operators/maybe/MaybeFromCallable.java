package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    public final Callable<? extends T> a;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) this.a.call();
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                Object obj = (Object) this.a.call();
                if (empty.isDisposed()) {
                    return;
                }
                if (obj == 0) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
