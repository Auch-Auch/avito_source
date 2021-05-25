package r6.a.b.c;

import io.reactivex.MaybeConverter;
import io.reactivex.MaybeObserver;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.Disposable;
public final class h<T> extends Maybe<T> implements MaybeConverter<T, Maybe<T>> {
    public static final h<Object> b = new h<>(null);
    public final io.reactivex.Maybe<T> a;

    public static final class a<T> implements MaybeObserver<T>, Disposable {
        public final io.reactivex.rxjava3.core.MaybeObserver<? super T> a;
        public io.reactivex.disposables.Disposable b;

        public a(io.reactivex.rxjava3.core.MaybeObserver<? super T> maybeObserver) {
            this.a = maybeObserver;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public h(io.reactivex.Maybe<T> maybe) {
        this.a = maybe;
    }

    @Override // io.reactivex.MaybeConverter
    public Object apply(io.reactivex.Maybe maybe) {
        return new h(maybe);
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(io.reactivex.rxjava3.core.MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new a(maybeObserver));
    }
}
