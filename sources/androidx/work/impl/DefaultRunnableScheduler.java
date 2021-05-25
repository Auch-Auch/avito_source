package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DefaultRunnableScheduler implements RunnableScheduler {
    public final Handler a;

    public DefaultRunnableScheduler() {
        this.a = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    @Override // androidx.work.RunnableScheduler
    public void cancel(@NonNull Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }

    @NonNull
    public Handler getHandler() {
        return this.a;
    }

    @Override // androidx.work.RunnableScheduler
    public void scheduleWithDelay(long j, @NonNull Runnable runnable) {
        this.a.postDelayed(runnable, j);
    }

    @VisibleForTesting
    public DefaultRunnableScheduler(@NonNull Handler handler) {
        this.a = handler;
    }
}
