package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;
public final class zzs implements Executor {
    private final /* synthetic */ Handler val$handler;

    public zzs(zzt zzt, Handler handler) {
        this.val$handler = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.val$handler.post(runnable);
    }
}
