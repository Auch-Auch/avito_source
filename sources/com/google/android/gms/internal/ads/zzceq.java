package com.google.android.gms.internal.ads;
public final class zzceq implements zzelo<zzceh> {
    private final zzelx<zzchc> zzewz;
    private final zzelx<zzcih> zzgac;

    public zzceq(zzelx<zzcih> zzelx, zzelx<zzchc> zzelx2) {
        this.zzgac = zzelx;
        this.zzewz = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzceh(this.zzgac.get(), this.zzewz.get());
    }
}
