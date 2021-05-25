package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    public final ObservableSource<T> a;
    public final Predicate<? super T> b;

    public static final class a<T> implements Observer<T>, Disposable {
        public final SingleObserver<? super Boolean> a;
        public final Predicate<? super T> b;
        public Disposable c;
        public boolean d;

        public a(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.a = singleObserver;
            this.b = predicate;
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
            if (!this.d) {
                this.d = true;
                this.a.onSuccess(Boolean.TRUE);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.d) {
                try {
                    if (!this.b.test(t)) {
                        this.d = true;
                        this.c.dispose();
                        this.a.onSuccess(Boolean.FALSE);
                    }
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

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.a = observableSource;
        this.b = predicate;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableAll(this.a, this.b));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b));
    }
}
