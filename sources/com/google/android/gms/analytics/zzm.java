package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.zzk;
import java.lang.Thread;
import java.util.concurrent.FutureTask;
public final class zzm extends FutureTask<T> {
    private final /* synthetic */ zzk.zza zzsy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzm(zzk.zza zza, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.zzsy = zza;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = zzk.this.zzsv;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String.valueOf(th).length();
        }
        super.setException(th);
    }
}
