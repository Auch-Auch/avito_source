package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
public final class zzbbk implements Executor {
    private final Handler zzeea = new zzayb(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzp.zzkp();
                zzayh.zza(zzp.zzkt().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzeea.post(runnable);
        }
    }
}
