package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zztw;
public final class zzcbe implements zzelo<zzcbb> {
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfkr;
    private final zzelx<zztw.zza.EnumC0204zza> zzfne;
    private final zzelx<zzbfq> zzfoi;
    private final zzelx<zzdkx> zzfpe;

    private zzcbe(zzelx<Context> zzelx, zzelx<zzbfq> zzelx2, zzelx<zzdkx> zzelx3, zzelx<zzbbg> zzelx4, zzelx<zztw.zza.EnumC0204zza> zzelx5) {
        this.zzert = zzelx;
        this.zzfoi = zzelx2;
        this.zzfpe = zzelx3;
        this.zzfkr = zzelx4;
        this.zzfne = zzelx5;
    }

    public static zzcbe zzc(zzelx<Context> zzelx, zzelx<zzbfq> zzelx2, zzelx<zzdkx> zzelx3, zzelx<zzbbg> zzelx4, zzelx<zztw.zza.EnumC0204zza> zzelx5) {
        return new zzcbe(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcbb(this.zzert.get(), this.zzfoi.get(), this.zzfpe.get(), this.zzfkr.get(), this.zzfne.get());
    }
}
