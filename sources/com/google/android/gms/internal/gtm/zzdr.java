package com.google.android.gms.internal.gtm;

import androidx.annotation.WorkerThread;
public final class zzdr implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    public zzdr(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        if (zzdq.zza(this.zzanc) == 2) {
            zzdq.zzb(this.zzanc).dispatch();
        }
    }
}
