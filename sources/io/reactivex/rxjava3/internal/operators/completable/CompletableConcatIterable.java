package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
public final class CompletableConcatIterable extends Completable {
    public final Iterable<? extends CompletableSource> a;

    public static final class a extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableObserver a;
        public final Iterator<? extends CompletableSource> b;
        public final SequentialDisposable c = new SequentialDisposable();

        public a(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.a = completableObserver;
            this.b = it;
        }

        public void a() {
            if (!this.c.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it = this.b;
                while (!this.c.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.a.onComplete();
                            return;
                        }
                        try {
                            Object next = it.next();
                            Objects.requireNonNull(next, "The CompletableSource returned is null");
                            ((CompletableSource) next).subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.a.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.a.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.c.replace(disposable);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.a = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Iterator<? extends CompletableSource> it = this.a.iterator();
            Objects.requireNonNull(it, "The iterator returned is null");
            a aVar = new a(completableObserver, it);
            completableObserver.onSubscribe(aVar.c);
            aVar.a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}
