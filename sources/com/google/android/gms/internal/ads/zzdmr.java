package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdmr implements zzelo<Context> {
    private final zzdmq zzhdf;
    private final zzelx<zzdmo> zzhdg;

    private zzdmr(zzdmq zzdmq, zzelx<zzdmo> zzelx) {
        this.zzhdf = zzdmq;
        this.zzhdg = zzelx;
    }

    public static zzdmr zzb(zzdmq zzdmq, zzelx<zzdmo> zzelx) {
        return new zzdmr(zzdmq, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzhdf, this.zzhdg.get());
    }

    public static Context zzb(zzdmq zzdmq, zzdmo zzdmo) {
        return (Context) zzelu.zza(zzdmo.zzaai, "Cannot return null from a non-@Nullable @Provides method");
    }
}
