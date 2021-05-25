package r6.a.b.c;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
public final class c implements Disposable {
    public final io.reactivex.disposables.Disposable a;

    public c(io.reactivex.disposables.Disposable disposable) {
        this.a = disposable;
    }

    public static Disposable a(io.reactivex.disposables.Disposable disposable) {
        if (disposable == DisposableHelper.DISPOSED) {
            return io.reactivex.rxjava3.internal.disposables.DisposableHelper.DISPOSED;
        }
        if (disposable == EmptyDisposable.INSTANCE) {
            return io.reactivex.rxjava3.internal.disposables.EmptyDisposable.INSTANCE;
        }
        return new c(disposable);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.a.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.a.isDisposed();
    }
}
