package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
public final class SafeObserver<T> implements Observer<T>, Disposable {
    public final Observer<? super T> a;
    public Disposable b;
    public boolean c;

    public SafeObserver(@NonNull Observer<? super T> observer) {
        this.a = observer;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.c) {
            this.c = true;
            if (this.b == null) {
                NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    this.a.onSubscribe(EmptyDisposable.INSTANCE);
                    try {
                        this.a.onError(nullPointerException);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
                }
            } else {
                try {
                    this.a.onComplete();
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(th3);
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        if (this.c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.c = true;
        if (this.b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.a.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.a.onError(th);
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(new CompositeException(th, th4));
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        if (!this.c) {
            if (this.b == null) {
                this.c = true;
                NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    this.a.onSubscribe(EmptyDisposable.INSTANCE);
                    try {
                        this.a.onError(nullPointerException);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
                }
            } else if (t == null) {
                NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.b.dispose();
                    onError(nullPointerException2);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(new CompositeException(nullPointerException2, th3));
                }
            } else {
                try {
                    this.a.onNext(t);
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    onError(new CompositeException(th, th4));
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.b, disposable)) {
            this.b = disposable;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(th, th));
            }
        }
    }
}
