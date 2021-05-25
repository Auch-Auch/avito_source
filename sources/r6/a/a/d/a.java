package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
public final class a extends Completable {
    public final CompletableSource a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    /* renamed from: r6.a.a.d.a$a  reason: collision with other inner class name */
    public static final class C0584a implements CompletableObserver, Disposable {
        public final CompletableObserver a;
        public final RxJavaAssemblyException b;
        public Disposable c;

        public C0584a(CompletableObserver completableObserver, RxJavaAssemblyException rxJavaAssemblyException) {
            this.a = completableObserver;
            this.b = rxJavaAssemblyException;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(this.b.appendLast(th));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public a(CompletableSource completableSource) {
        this.a = completableSource;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new C0584a(completableObserver, this.b));
    }
}
