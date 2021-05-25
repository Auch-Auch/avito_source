package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
public abstract class MainThreadDisposable implements Disposable {
    public final AtomicBoolean a = new AtomicBoolean();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainThreadDisposable.this.onDispose();
        }
    }

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StringBuilder L = a2.b.a.a.a.L("Expected to be called on the main thread but was ");
            L.append(Thread.currentThread().getName());
            throw new IllegalStateException(L.toString());
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (!this.a.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(new a());
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.a.get();
    }

    public abstract void onDispose();
}
