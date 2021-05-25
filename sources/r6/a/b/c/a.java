package r6.a.b.c;

import io.reactivex.CompletableConverter;
import io.reactivex.CompletableObserver;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
public final class a extends Completable implements CompletableConverter<Completable> {
    public static final a b = new a(null);
    public final io.reactivex.Completable a;

    /* renamed from: r6.a.b.c.a$a  reason: collision with other inner class name */
    public static final class C0635a implements CompletableObserver, Disposable {
        public final io.reactivex.rxjava3.core.CompletableObserver a;
        public io.reactivex.disposables.Disposable b;

        public C0635a(io.reactivex.rxjava3.core.CompletableObserver completableObserver) {
            this.a = completableObserver;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.b = disposable;
            this.a.onSubscribe(this);
        }
    }

    public a(io.reactivex.Completable completable) {
        this.a = completable;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.CompletableConverter
    public Completable apply(io.reactivex.Completable completable) {
        return new a(completable);
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(io.reactivex.rxjava3.core.CompletableObserver completableObserver) {
        this.a.subscribe(new C0635a(completableObserver));
    }
}
