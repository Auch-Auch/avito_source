package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzbme implements zzelo<zzblr> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzqo> zzfmz;
    private final zzelx<zzalz> zzfna;

    private zzbme(zzelx<zzqo> zzelx, zzelx<zzalz> zzelx2, zzelx<Executor> zzelx3) {
        this.zzfmz = zzelx;
        this.zzfna = zzelx2;
        this.zzerr = zzelx3;
    }

    public static zzbme zzb(zzelx<zzqo> zzelx, zzelx<zzalz> zzelx2, zzelx<Executor> zzelx3) {
        return new zzbme(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzblr) zzelu.zza(new zzblr(this.zzfmz.get().getUniqueId(), this.zzfna.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
