package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzea implements Runnable {
    private final /* synthetic */ Context zzxp;

    public zzea(zzdy zzdy, Context context) {
        this.zzxp = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zzb(this.zzxp);
        } catch (Exception e) {
            zzdy.zzxg.zza(2019, -1, e);
        }
    }
}
