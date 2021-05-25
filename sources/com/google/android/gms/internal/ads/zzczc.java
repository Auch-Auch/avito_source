package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;
public final class zzczc implements zzelo<zzdvt<zzczg>> {
    private final zzelx<zzdpf> zzfow;
    private final zzelx<zzczf> zzgry;
    private final zzelx<zzbrz> zzgrz;

    public zzczc(zzelx<zzdpf> zzelx, zzelx<zzczf> zzelx2, zzelx<zzbrz> zzelx3) {
        this.zzfow = zzelx;
        this.zzgry = zzelx2;
        this.zzgrz = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdvt) zzelu.zza(this.zzfow.get().zza((zzdpf) zzdpg.GENERATE_SIGNALS, (zzdvt) this.zzgrz.get().zzajd()).zza(this.zzgry.get()).zza((long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcuo)).intValue(), TimeUnit.SECONDS).zzauz(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
