package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
public final class ObservableSwitchIfEmpty<T> extends s6.a.e.d.c.c.a<T, T> {
    public final ObservableSource<? extends T> a;

    public static final class a<T> implements Observer<T> {
        public final Observer<? super T> a;
        public final ObservableSource<? extends T> b;
        public final SequentialDisposable c = new SequentialDisposable();
        public boolean d = true;

        public a(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.b = observableSource;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.d) {
                this.d = false;
                this.b.subscribe(this);
                return;
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.d) {
                this.d = false;
            }
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            this.c.update(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.a = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer, this.a);
        observer.onSubscribe(aVar.c);
        this.source.subscribe(aVar);
    }
}
