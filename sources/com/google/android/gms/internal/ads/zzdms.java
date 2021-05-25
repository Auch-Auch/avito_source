package com.google.android.gms.internal.ads;
public final class zzdms implements zzelo<zzdmo> {
    private final zzelx<zzdmm> zzfmp;
    private final zzdmq zzhdf;
    private final zzelx<String> zzhdh;

    private zzdms(zzdmq zzdmq, zzelx<zzdmm> zzelx, zzelx<String> zzelx2) {
        this.zzhdf = zzdmq;
        this.zzfmp = zzelx;
        this.zzhdh = zzelx2;
    }

    public static zzdms zza(zzdmq zzdmq, zzelx<zzdmm> zzelx, zzelx<String> zzelx2) {
        return new zzdms(zzdmq, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdmo) zzelu.zza(this.zzfmp.get().zzgv(this.zzhdh.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
