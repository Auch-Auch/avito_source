package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
public final class zzbyt implements zzelo<zzbyr> {
    private final zzelx<Context> zzert;
    private final zzelx<Set<zzbys<zzqu>>> zzfor;
    private final zzelx<zzdkx> zzfpe;

    private zzbyt(zzelx<Context> zzelx, zzelx<Set<zzbys<zzqu>>> zzelx2, zzelx<zzdkx> zzelx3) {
        this.zzert = zzelx;
        this.zzfor = zzelx2;
        this.zzfpe = zzelx3;
    }

    public static zzbyt zzj(zzelx<Context> zzelx, zzelx<Set<zzbys<zzqu>>> zzelx2, zzelx<zzdkx> zzelx3) {
        return new zzbyt(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbyr(this.zzert.get(), this.zzfor.get(), this.zzfpe.get());
    }
}
