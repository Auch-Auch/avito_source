package r6.a.b.c;

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.core.MaybeConverter;
import io.reactivex.rxjava3.core.MaybeObserver;
public final class i<T> extends Maybe<T> implements MaybeConverter<T, Maybe<T>> {
    public static final i<Object> b = new i<>(null);
    public final io.reactivex.rxjava3.core.Maybe<T> a;

    public static final class a<T> implements MaybeObserver<T>, Disposable {
        public final io.reactivex.MaybeObserver<? super T> a;
        public io.reactivex.rxjava3.disposables.Disposable b;

        public a(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.a = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(io.reactivex.rxjava3.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public i(io.reactivex.rxjava3.core.Maybe<T> maybe) {
        this.a = maybe;
    }

    @Override // io.reactivex.rxjava3.core.MaybeConverter
    public Object apply(io.reactivex.rxjava3.core.Maybe maybe) {
        return new i(maybe);
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new a(maybeObserver));
    }
}
