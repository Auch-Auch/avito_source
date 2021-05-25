package r6.a.b.c;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.core.SingleConverter;
import io.reactivex.rxjava3.core.SingleObserver;
public final class o<T> extends Single<T> implements SingleConverter<T, Single<T>> {
    public static final o<Object> b = new o<>(null);
    public final io.reactivex.rxjava3.core.Single<T> a;

    public static final class a<T> implements SingleObserver<T>, Disposable {
        public final io.reactivex.SingleObserver<? super T> a;
        public io.reactivex.rxjava3.disposables.Disposable b;

        public a(io.reactivex.SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(io.reactivex.rxjava3.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public o(io.reactivex.rxjava3.core.Single<T> single) {
        this.a = single;
    }

    @Override // io.reactivex.rxjava3.core.SingleConverter
    public Object apply(io.reactivex.rxjava3.core.Single single) {
        return new o(single);
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }
}
