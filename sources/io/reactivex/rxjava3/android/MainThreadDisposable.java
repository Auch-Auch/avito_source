package io.reactivex.rxjava3.android;

import a2.b.a.a.a;
import android.os.Looper;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
public abstract class MainThreadDisposable implements Disposable {
    public final AtomicBoolean a = new AtomicBoolean();

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StringBuilder L = a.L("Expected to be called on the main thread but was ");
            L.append(Thread.currentThread().getName());
            throw new IllegalStateException(L.toString());
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        if (!this.a.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(new Runnable() { // from class: s6.a.e.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    MainThreadDisposable.this.onDispose();
                }
            });
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return this.a.get();
    }

    public abstract void onDispose();
}
