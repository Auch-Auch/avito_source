package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
public final class CompletablePeek extends Completable {
    public final CompletableSource a;
    public final Consumer<? super Disposable> b;
    public final Consumer<? super Throwable> c;
    public final Action d;
    public final Action e;
    public final Action f;
    public final Action g;

    public final class a implements CompletableObserver, Disposable {
        public final CompletableObserver a;
        public Disposable b;

        public a(CompletableObserver completableObserver) {
            this.a = completableObserver;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            try {
                CompletablePeek.this.g.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            if (this.b != DisposableHelper.DISPOSED) {
                try {
                    CompletablePeek.this.d.run();
                    CompletablePeek.this.e.run();
                    this.a.onComplete();
                    try {
                        CompletablePeek.this.f.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.a.onError(th2);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            if (this.b == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            try {
                CompletablePeek.this.c.accept(th);
                CompletablePeek.this.e.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
            try {
                CompletablePeek.this.f.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.b.accept(disposable);
                if (DisposableHelper.validate(this.b, disposable)) {
                    this.b = disposable;
                    this.a.onSubscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                disposable.dispose();
                this.b = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th, this.a);
            }
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.a = completableSource;
        this.b = consumer;
        this.c = consumer2;
        this.d = action;
        this.e = action2;
        this.f = action3;
        this.g = action4;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }
}
