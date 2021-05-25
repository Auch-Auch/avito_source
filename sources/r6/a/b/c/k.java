package r6.a.b.c;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.core.ObservableConverter;
import io.reactivex.rxjava3.core.Observer;
public final class k<T> extends Observable<T> implements ObservableConverter<T, Observable<T>> {
    public static final k<Object> b = new k<>(null);
    public final io.reactivex.rxjava3.core.Observable<T> a;

    public static final class a<T> implements Observer<T>, Disposable {
        public final io.reactivex.Observer<? super T> a;
        public io.reactivex.rxjava3.disposables.Disposable b;

        public a(io.reactivex.Observer<? super T> observer) {
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

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(io.reactivex.rxjava3.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }
    }

    public k(io.reactivex.rxjava3.core.Observable<T> observable) {
        this.a = observable;
    }

    @Override // io.reactivex.rxjava3.core.ObservableConverter
    public Object apply(io.reactivex.rxjava3.core.Observable observable) {
        return new k(observable);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.a.subscribe(new a(observer));
    }
}
