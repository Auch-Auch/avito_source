package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
public final class ObservableScan<T> extends s6.a.c.b.c.a<T, T> {
    public final BiFunction<T, T, T> a;

    public static final class a<T> implements Observer<T>, Disposable {
        public final Observer<? super T> a;
        public final BiFunction<T, T, T> b;
        public Disposable c;
        public T d;
        public boolean e;

        public a(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.a = observer;
            this.b = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.e) {
                this.e = true;
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.e) {
                Observer<? super T> observer = this.a;
                T t2 = this.d;
                if (t2 == null) {
                    this.d = t;
                    observer.onNext(t);
                    return;
                }
                try {
                    T t3 = (T) ObjectHelper.requireNonNull(this.b.apply(t2, t), "The value returned by the accumulator is null");
                    this.d = t3;
                    observer.onNext(t3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.c.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.a = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a));
    }
}
