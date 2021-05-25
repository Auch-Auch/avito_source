package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import s6.a.e.c.b;
import s6.a.e.c.d;
public final class MaybeFromFuture<T> extends Maybe<T> {
    public final Future<? extends T> a;
    public final long b;
    public final TimeUnit c;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.a = future;
        this.b = j;
        this.c = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable a3 = b.a();
        maybeObserver.onSubscribe(a3);
        d dVar = (d) a3;
        if (!dVar.isDisposed()) {
            try {
                long j = this.b;
                Object obj = j <= 0 ? (Object) this.a.get() : (Object) this.a.get(j, this.c);
                if (dVar.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable th) {
                th = th;
                Exceptions.throwIfFatal(th);
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.throwIfFatal(th);
                if (!dVar.isDisposed()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
