package r6.a.b.c;

import io.reactivex.SingleConverter;
import io.reactivex.SingleObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
public final class n<T> extends Single<T> implements SingleConverter<T, Single<T>> {
    public static final n<Object> b = new n<>(null);
    public final io.reactivex.Single<T> a;

    public static final class a<T> implements SingleObserver<T>, Disposable {
        public final io.reactivex.rxjava3.core.SingleObserver<? super T> a;
        public io.reactivex.disposables.Disposable b;

        public a(io.reactivex.rxjava3.core.SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public n(io.reactivex.Single<T> single) {
        this.a = single;
    }

    @Override // io.reactivex.SingleConverter
    public Object apply(io.reactivex.Single single) {
        return new n(single);
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(io.reactivex.rxjava3.core.SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver));
    }
}
