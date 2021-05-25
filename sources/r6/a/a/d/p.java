package r6.a.a.d;

import hu.akarnokd.rxjava2.debug.RxJavaAssemblyException;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
public final class p<T> extends Single<T> {
    public final SingleSource<T> a;
    public final RxJavaAssemblyException b = new RxJavaAssemblyException();

    public static final class a<T> implements SingleObserver<T>, Disposable {
        public final SingleObserver<? super T> a;
        public final RxJavaAssemblyException b;
        public Disposable c;

        public a(SingleObserver<? super T> singleObserver, RxJavaAssemblyException rxJavaAssemblyException) {
            this.a = singleObserver;
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

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(this.b.appendLast(th));
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public p(SingleSource<T> singleSource) {
        this.a = singleSource;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new a(singleObserver, this.b));
    }
}
