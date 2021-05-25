package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    public final ObservableSource<? extends T> a;
    public final ObservableSource<U> b;

    public final class a implements Observer<U> {
        public final SequentialDisposable a;
        public final Observer<? super T> b;
        public boolean c;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableDelaySubscriptionOther$a$a  reason: collision with other inner class name */
        public final class C0483a implements Observer<T> {
            public C0483a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a.this.b.onComplete();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a.this.b.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(T t) {
                a.this.b.onNext(t);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                a.this.a.update(disposable);
            }
        }

        public a(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.a = sequentialDisposable;
            this.b = observer;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.c) {
                this.c = true;
                ObservableDelaySubscriptionOther.this.a.subscribe(new C0483a());
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.c = true;
            this.b.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.a = observableSource;
        this.b = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.b.subscribe(new a(sequentialDisposable, observer));
    }
}
