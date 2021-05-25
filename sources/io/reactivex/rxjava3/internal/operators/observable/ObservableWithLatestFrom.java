package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableWithLatestFrom<T, U, R> extends s6.a.e.d.c.c.a<T, R> {
    public final BiFunction<? super T, ? super U, ? extends R> a;
    public final ObservableSource<? extends U> b;

    public static final class a<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        public final Observer<? super R> a;
        public final BiFunction<? super T, ? super U, ? extends R> b;
        public final AtomicReference<Disposable> c = new AtomicReference<>();
        public final AtomicReference<Disposable> d = new AtomicReference<>();

        public a(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.a = observer;
            this.b = biFunction;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.c);
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.c.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.d);
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.b.apply(t, obj);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.a.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    this.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.c, disposable);
        }
    }

    public final class b implements Observer<U> {
        public final a<T, U, R> a;

        public b(ObservableWithLatestFrom observableWithLatestFrom, a<T, U, R> aVar) {
            this.a = aVar;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            a<T, U, R> aVar = this.a;
            DisposableHelper.dispose(aVar.c);
            aVar.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.a.d, disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.a = biFunction;
        this.b = observableSource2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        a aVar = new a(serializedObserver, this.a);
        serializedObserver.onSubscribe(aVar);
        this.b.subscribe(new b(this, aVar));
        this.source.subscribe(aVar);
    }
}
