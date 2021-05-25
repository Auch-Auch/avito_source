package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
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
import java.util.concurrent.atomic.AtomicBoolean;
public final class ObservableUsing<T, D> extends Observable<T> {
    public final Callable<? extends D> a;
    public final Function<? super D, ? extends ObservableSource<? extends T>> b;
    public final Consumer<? super D> c;
    public final boolean d;

    public static final class a<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;
        public final Observer<? super T> a;
        public final D b;
        public final Consumer<? super D> c;
        public final boolean d;
        public Disposable e;

        public a(Observer<? super T> observer, D d2, Consumer<? super D> consumer, boolean z) {
            this.a = observer;
            this.b = d2;
            this.c = consumer;
            this.d = z;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.c.accept(this.b);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            a();
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.c.accept(this.b);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.a.onError(th);
                        return;
                    }
                }
                this.e.dispose();
                this.a.onComplete();
                return;
            }
            this.a.onComplete();
            this.e.dispose();
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.c.accept(this.b);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.e.dispose();
                this.a.onError(th);
                return;
            }
            this.a.onError(th);
            this.e.dispose();
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.a = callable;
        this.b = function;
        this.c = consumer;
        this.d = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.a.call();
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.b.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(observer, call, this.c, this.d));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(new CompositeException(th, th), observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, observer);
        }
    }
}
