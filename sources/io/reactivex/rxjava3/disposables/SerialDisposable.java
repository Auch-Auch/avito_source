package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;
public final class SerialDisposable implements Disposable {
    public final AtomicReference<Disposable> a;

    public SerialDisposable() {
        this.a = new AtomicReference<>();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.a);
    }

    @Nullable
    public Disposable get() {
        Disposable disposable = this.a.get();
        return disposable == DisposableHelper.DISPOSED ? EmptyDisposable.INSTANCE : disposable;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.a.get());
    }

    public boolean replace(@Nullable Disposable disposable) {
        return DisposableHelper.replace(this.a, disposable);
    }

    public boolean set(@Nullable Disposable disposable) {
        return DisposableHelper.set(this.a, disposable);
    }

    public SerialDisposable(@Nullable Disposable disposable) {
        this.a = new AtomicReference<>(disposable);
    }
}
