package com.google.android.gms.internal.gtm;

import android.os.Looper;
public final class zzbt implements Runnable {
    private final /* synthetic */ zzbs zzyu;

    public zzbt(zzbs zzbs) {
        this.zzyu = zzbs;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzyu.zzwc.zzcq().zza(this);
            return;
        }
        boolean zzez = this.zzyu.zzez();
        this.zzyu.zzyt = 0;
        if (zzez) {
            this.zzyu.run();
        }
    }
}
