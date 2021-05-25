package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;
@KeepForSdk
public class HandlerExecutor implements Executor {
    private final Handler zza;

    @KeepForSdk
    public HandlerExecutor(@RecentlyNonNull Looper looper) {
        this.zza = new zzi(looper);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@RecentlyNonNull Runnable runnable) {
        this.zza.post(runnable);
    }
}
