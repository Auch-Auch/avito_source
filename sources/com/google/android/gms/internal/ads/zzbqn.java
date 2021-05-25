package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
public final class zzbqn implements zzelo<zzaxj> {
    private final zzelx<zzaxv> zzeyd;
    private final zzelx<Clock> zzfms;
    private final zzelx<zzdln> zzfos;

    private zzbqn(zzelx<Clock> zzelx, zzelx<zzaxv> zzelx2, zzelx<zzdln> zzelx3) {
        this.zzfms = zzelx;
        this.zzeyd = zzelx2;
        this.zzfos = zzelx3;
    }

    public static zzbqn zzg(zzelx<Clock> zzelx, zzelx<zzaxv> zzelx2, zzelx<zzdln> zzelx3) {
        return new zzbqn(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzaxj) zzelu.zza(this.zzeyd.get().zza(this.zzfms.get(), this.zzfos.get().zzhbv), "Cannot return null from a non-@Nullable @Provides method");
    }
}
