package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
public final class zzbaf {
    private Handler handler = null;
    private final Object lock = new Object();
    private HandlerThread zzeci = null;
    private int zzecj = 0;

    public final Handler getHandler() {
        return this.handler;
    }

    public final Looper zzyf() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzecj != 0) {
                Preconditions.checkNotNull(this.zzeci, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzeci == null) {
                zzaxy.zzei("Starting the looper thread.");
                HandlerThread handlerThread = new HandlerThread("LooperProvider");
                this.zzeci = handlerThread;
                handlerThread.start();
                this.handler = new zzdsf(this.zzeci.getLooper());
                zzaxy.zzei("Looper thread started.");
            } else {
                zzaxy.zzei("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzecj++;
            looper = this.zzeci.getLooper();
        }
        return looper;
    }
}
