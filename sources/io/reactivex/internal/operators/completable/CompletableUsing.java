package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
public final class CompletableUsing<R> extends Completable {
    public final Callable<R> a;
    public final Function<? super R, ? extends CompletableSource> b;
    public final Consumer<? super R> c;
    public final boolean d;

    public static final class a<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        public final CompletableObserver a;
        public final Consumer<? super R> b;
        public final boolean c;
        public Disposable d;

        public a(CompletableObserver completableObserver, R r, Consumer<? super R> consumer, boolean z) {
            super(r);
            this.a = completableObserver;
            this.b = consumer;
            this.c = z;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            if (this.c) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.b.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.a.onError(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.a.onComplete();
            if (!this.c) {
                a();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            if (this.c) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.b.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.a.onError(th);
            if (!this.c) {
                a();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        this.a = callable;
        this.b = function;
        this.c = consumer;
        this.d = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            R call = this.a.call();
            try {
                ((CompletableSource) ObjectHelper.requireNonNull(this.b.apply(call), "The completableFunction returned a null CompletableSource")).subscribe(new a(completableObserver, call, this.c, this.d));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, completableObserver);
        }
    }
}
