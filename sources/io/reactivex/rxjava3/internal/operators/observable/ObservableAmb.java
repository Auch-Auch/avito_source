package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableAmb<T> extends Observable<T> {
    public final ObservableSource<? extends T>[] a;
    public final Iterable<? extends ObservableSource<? extends T>> b;

    public static final class a<T> implements Disposable {
        public final Observer<? super T> a;
        public final b<T>[] b;
        public final AtomicInteger c = new AtomicInteger();

        public a(Observer<? super T> observer, int i) {
            this.a = observer;
            this.b = new b[i];
        }

        public boolean a(int i) {
            int i2 = 0;
            if (this.c.get() != 0 || !this.c.compareAndSet(0, i)) {
                return false;
            }
            b<T>[] bVarArr = this.b;
            int length = bVarArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (i3 != i) {
                    b<T> bVar = bVarArr[i2];
                    Objects.requireNonNull(bVar);
                    DisposableHelper.dispose(bVar);
                }
                i2 = i3;
            }
            return true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.c.get() != -1) {
                this.c.lazySet(-1);
                b<T>[] bVarArr = this.b;
                for (b<T> bVar : bVarArr) {
                    Objects.requireNonNull(bVar);
                    DisposableHelper.dispose(bVar);
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == -1;
        }
    }

    public static final class b<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        public final a<T> a;
        public final int b;
        public final Observer<? super T> c;
        public boolean d;

        public b(a<T> aVar, int i, Observer<? super T> observer) {
            this.a = aVar;
            this.b = i;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.d) {
                this.c.onComplete();
            } else if (this.a.a(this.b)) {
                this.d = true;
                this.c.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d) {
                this.c.onError(th);
            } else if (this.a.a(this.b)) {
                this.d = true;
                this.c.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.d) {
                this.c.onNext(t);
            } else if (this.a.a(this.b)) {
                this.d = true;
                this.c.onNext(t);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.a = observableSourceArr;
        this.b = iterable;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        int i;
        ObservableSource<? extends T>[] observableSourceArr = this.a;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i = 0;
                for (ObservableSource<? extends T> observableSource : this.b) {
                    if (observableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (i == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i >> 2) + i)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i2 = i + 1;
                    observableSourceArr[i] = observableSource;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            i = observableSourceArr.length;
        }
        if (i == 0) {
            EmptyDisposable.complete(observer);
        } else if (i == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            a aVar = new a(observer, i);
            b<T>[] bVarArr = aVar.b;
            int length = bVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                bVarArr[i3] = new b<>(aVar, i4, aVar.a);
                i3 = i4;
            }
            aVar.c.lazySet(0);
            aVar.a.onSubscribe(aVar);
            for (int i5 = 0; i5 < length && aVar.c.get() == 0; i5++) {
                observableSourceArr[i5].subscribe(bVarArr[i5]);
            }
        }
    }
}
