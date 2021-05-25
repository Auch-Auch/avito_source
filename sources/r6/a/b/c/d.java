package r6.a.b.c;

import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
public final class d implements Disposable {
    public final io.reactivex.rxjava3.disposables.Disposable a;

    public d(io.reactivex.rxjava3.disposables.Disposable disposable) {
        this.a = disposable;
    }

    public static Disposable a(io.reactivex.rxjava3.disposables.Disposable disposable) {
        if (disposable == DisposableHelper.DISPOSED) {
            return io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }
        if (disposable == EmptyDisposable.INSTANCE) {
            return io.reactivex.internal.disposables.EmptyDisposable.INSTANCE;
        }
        return new d(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.a.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.a.isDisposed();
    }
}
