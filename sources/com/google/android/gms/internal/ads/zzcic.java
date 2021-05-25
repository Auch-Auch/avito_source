package com.google.android.gms.internal.ads;
public final class zzcic implements zzelo<zzcre<zzchu>> {
    private final zzelx<zzcvp<zzchu, zzdlx, zzcsn>> zzfmq;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzcvp<zzchu, zzdlx, zzcso>> zzgdd;

    public zzcic(zzelx<zzcvp<zzchu, zzdlx, zzcsn>> zzelx, zzelx<zzcvp<zzchu, zzdlx, zzcso>> zzelx2, zzelx<zzdln> zzelx3) {
        this.zzfmq = zzelx;
        this.zzgdd = zzelx2;
        this.zzfos = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        zzcvp<zzchu, zzdlx, zzcsn> zzcvp;
        zzelx<zzcvp<zzchu, zzdlx, zzcsn>> zzelx = this.zzfmq;
        zzelx<zzcvp<zzchu, zzdlx, zzcso>> zzelx2 = this.zzgdd;
        if (zzchz.zzgdc[this.zzfos.get().zzhcb.zzhbf - 1] != 1) {
            zzcvp = zzelx2.get();
        } else {
            zzcvp = zzelx.get();
        }
        return (zzcre) zzelu.zza(zzcvp, "Cannot return null from a non-@Nullable @Provides method");
    }
}
