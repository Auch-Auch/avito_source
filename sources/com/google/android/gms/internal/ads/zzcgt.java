package com.google.android.gms.internal.ads;
public final class zzcgt implements zzelo<zzcgu> {
    private final zzelx<String> zzfsn;
    private final zzelx<zzccv> zzfwo;
    private final zzelx<zzcco> zzgcf;

    private zzcgt(zzelx<String> zzelx, zzelx<zzcco> zzelx2, zzelx<zzccv> zzelx3) {
        this.zzfsn = zzelx;
        this.zzgcf = zzelx2;
        this.zzfwo = zzelx3;
    }

    public static zzcgt zzl(zzelx<String> zzelx, zzelx<zzcco> zzelx2, zzelx<zzccv> zzelx3) {
        return new zzcgt(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcgu(this.zzfsn.get(), this.zzgcf.get(), this.zzfwo.get());
    }
}
