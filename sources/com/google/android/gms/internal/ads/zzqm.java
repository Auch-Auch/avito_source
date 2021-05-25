package com.google.android.gms.internal.ads;

import android.view.Surface;
public final class zzqm implements Runnable {
    private final /* synthetic */ zzqg zzbmt;
    private final /* synthetic */ Surface zzbnb;

    public zzqm(zzqg zzqg, Surface surface) {
        this.zzbmt = zzqg;
        this.zzbnb = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbmt.zzbmu.zza(this.zzbnb);
    }
}
