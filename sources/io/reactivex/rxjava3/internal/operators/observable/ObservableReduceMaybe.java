package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
public final class ObservableReduceMaybe<T> extends Maybe<T> {
    public final ObservableSource<T> a;
    public final BiFunction<T, T, T> b;

    public static final class a<T> implements Observer<T>, Disposable {
        public final MaybeObserver<? super T> a;
        public final BiFunction<T, T, T> b;
        public boolean c;
        public T d;
        public Disposable e;

        public a(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.a = maybeObserver;
            this.b = biFunction;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.c) {
                this.c = true;
                T t = this.d;
                this.d = null;
                if (t != null) {
                    this.a.onSuccess(t);
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.c = true;
            this.d = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.c) {
                T t2 = this.d;
                if (t2 == null) {
                    this.d = t;
                    return;
                }
                try {
                    T apply = this.b.apply(t2, t);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.d = apply;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.e.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.a = observableSource;
        this.b = biFunction;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new a(maybeObserver, this.b));
    }
}
