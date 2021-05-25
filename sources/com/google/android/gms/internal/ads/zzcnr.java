package com.google.android.gms.internal.ads;
public abstract class zzcnr implements zzduv<zzasp, zzdlj> {
    private final zzbve zzgho;

    public zzcnr(zzbve zzbve) {
        this.zzgho = zzbve;
    }

    public abstract zzdvt<zzdlj> zzb(zzasp zzasp) throws zzcmt;

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvt' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduv
    public final /* synthetic */ zzdvt<zzdlj> zzf(zzasp zzasp) throws Exception {
        zzasp zzasp2 = zzasp;
        this.zzgho.zzd(zzasp2);
        zzdvt<zzdlj> zzb = zzb(zzasp2);
        zzdvl.zza(zzb, new zzcnu(this), zzbbi.zzedz);
        return zzb;
    }
}
