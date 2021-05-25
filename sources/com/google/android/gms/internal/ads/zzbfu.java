package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzbfu implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzavu zzemm;
    private final /* synthetic */ int zzemn;
    private final /* synthetic */ zzbft zzemo;

    public zzbfu(zzbft zzbft, View view, zzavu zzavu, int i) {
        this.zzemo = zzbft;
        this.val$view = view;
        this.zzemm = zzavu;
        this.zzemn = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzemo.zza(this.val$view, this.zzemm, this.zzemn - 1);
    }
}
