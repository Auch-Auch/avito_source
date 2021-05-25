package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbuz implements zzelo<zzbux> {
    private final zzelx<zzdkx> zzflw;
    private final zzelx<Set<zzbys<zzbuy>>> zzfor;

    private zzbuz(zzelx<Set<zzbys<zzbuy>>> zzelx, zzelx<zzdkx> zzelx2) {
        this.zzfor = zzelx;
        this.zzflw = zzelx2;
    }

    public static zzbuz zzu(zzelx<Set<zzbys<zzbuy>>> zzelx, zzelx<zzdkx> zzelx2) {
        return new zzbuz(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbux(this.zzfor.get(), this.zzflw.get());
    }
}
