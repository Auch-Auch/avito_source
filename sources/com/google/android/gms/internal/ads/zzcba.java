package com.google.android.gms.internal.ads;
public final class zzcba implements zzelo<zzcre<zzbzr>> {
    private final zzelx<zzdvw> zzfol;
    private final zzelx<zzdpf> zzfow;
    private final zzelx<zzctc> zzfox;
    private final zzelx<zzcvl> zzfoy;

    public zzcba(zzelx<zzdpf> zzelx, zzelx<zzdvw> zzelx2, zzelx<zzctc> zzelx3, zzelx<zzcvl> zzelx4) {
        this.zzfow = zzelx;
        this.zzfol = zzelx2;
        this.zzfox = zzelx3;
        this.zzfoy = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzcre) zzelu.zza(new zzcvp(this.zzfow.get(), this.zzfol.get(), this.zzfoy.get(), this.zzfox.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
