package r6.a.b.c;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.CompletableObserver;
public final class b extends Completable implements CompletableConverter<Completable> {
    public static final b b = new b(null);
    public final io.reactivex.rxjava3.core.Completable a;

    public static final class a implements CompletableObserver, Disposable {
        public final io.reactivex.CompletableObserver a;
        public io.reactivex.rxjava3.disposables.Disposable b;

        public a(io.reactivex.CompletableObserver completableObserver) {
            this.a = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(io.reactivex.rxjava3.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }
    }

    public b(io.reactivex.rxjava3.core.Completable completable) {
        this.a = completable;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.rxjava3.core.CompletableConverter
    public Completable apply(io.reactivex.rxjava3.core.Completable completable) {
        return new b(completable);
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver));
    }
}
