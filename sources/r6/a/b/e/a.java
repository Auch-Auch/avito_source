package r6.a.b.e;

import hu.akarnokd.rxjava3.debug.RxJavaAssemblyException;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
public final class a extends Completable {
    public final CompletableSource a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    /* renamed from: r6.a.b.e.a$a  reason: collision with other inner class name */
    public static final class C0636a implements CompletableObserver, Disposable {
        public final CompletableObserver a;
        public final RxJavaAssemblyException b;
        public Disposable c;

        public C0636a(CompletableObserver completableObserver, RxJavaAssemblyException rxJavaAssemblyException) {
            this.a = completableObserver;
            this.b = rxJavaAssemblyException;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(this.b.appendLast(th));
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new C0636a(completableObserver, this.b));
    }
}
