package com.google.android.gms.internal.ads;
public final class zzdmp implements zzelo<zzaya> {
    private final zzdmq zzhdf;
    private final zzelx<zzdmo> zzhdg;

    private zzdmp(zzdmq zzdmq, zzelx<zzdmo> zzelx) {
        this.zzhdf = zzdmq;
        this.zzhdg = zzelx;
    }

    public static zzdmp zza(zzdmq zzdmq, zzelx<zzdmo> zzelx) {
        return new zzdmp(zzdmq, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzhdf, this.zzhdg.get());
    }

    public static zzaya zza(zzdmq zzdmq, zzdmo zzdmo) {
        return (zzaya) zzelu.zza(zzdmo.zzdza, "Cannot return null from a non-@Nullable @Provides method");
    }
}
