package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import s6.a.e.c.b;
import s6.a.e.c.d;
public final class CompletableFromAction extends Completable {
    public final Action a;

    public CompletableFromAction(Action action) {
        this.a = action;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable a3 = b.a();
        completableObserver.onSubscribe(a3);
        d dVar = (d) a3;
        if (!dVar.isDisposed()) {
            try {
                this.a.run();
                if (!dVar.isDisposed()) {
                    completableObserver.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!dVar.isDisposed()) {
                    completableObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
