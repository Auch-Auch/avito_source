package com.google.android.gms.internal.ads;

import android.view.View;
public final class zzbhk implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzavu zzemm;
    private final /* synthetic */ int zzemn;
    private final /* synthetic */ zzbhi zzepq;

    public zzbhk(zzbhi zzbhi, View view, zzavu zzavu, int i) {
        this.zzepq = zzbhi;
        this.val$view = view;
        this.zzemm = zzavu;
        this.zzemn = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbhi.zza(this.zzepq, this.val$view, this.zzemm, this.zzemn - 1);
    }
}
