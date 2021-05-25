package r6.a.b.c;

import io.reactivex.ObservableConverter;
import io.reactivex.Observer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
public final class j<T> extends Observable<T> implements ObservableConverter<T, Observable<T>> {
    public static final j<Object> b = new j<>(null);
    public final io.reactivex.Observable<T> a;

    public static final class a<T> implements Observer<T>, Disposable {
        public final io.reactivex.rxjava3.core.Observer<? super T> a;
        public io.reactivex.disposables.Disposable b;

        public a(io.reactivex.rxjava3.core.Observer<? super T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }
    }

    public j(io.reactivex.Observable<T> observable) {
        this.a = observable;
    }

    @Override // io.reactivex.ObservableConverter
    public Object apply(io.reactivex.Observable observable) {
        return new j(observable);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(io.reactivex.rxjava3.core.Observer<? super T> observer) {
        this.a.subscribe(new a(observer));
    }
}
