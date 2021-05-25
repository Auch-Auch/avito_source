package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
public final class zzbsq implements zzelo<zzavu> {
    private final zzelx<Context> zzert;
    private final zzelx<zzdkx> zzfnc;
    private final zzbsr zzfsq;
    private final zzelx<zzbbg> zzfsr;
    private final zzelx<zzavw> zzfss;

    private zzbsq(zzbsr zzbsr, zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzdkx> zzelx3, zzelx<zzavw> zzelx4) {
        this.zzfsq = zzbsr;
        this.zzert = zzelx;
        this.zzfsr = zzelx2;
        this.zzfnc = zzelx3;
        this.zzfss = zzelx4;
    }

    public static zzbsq zza(zzbsr zzbsr, zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzdkx> zzelx3, zzelx<zzavw> zzelx4) {
        return new zzbsq(zzbsr, zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        Context context = this.zzert.get();
        zzbbg zzbbg = this.zzfsr.get();
        zzdkx zzdkx = this.zzfnc.get();
        zzavw zzavw = this.zzfss.get();
        if (zzdkx.zzhas != null) {
            return new zzavl(context, zzbbg, zzdkx.zzhas, zzdkx.zzhao.zzdos, zzavw);
        }
        return null;
    }
}
