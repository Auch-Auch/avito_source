package com.google.android.gms.internal.ads;
public final class zzbpr implements zzdvi<zzbpj> {
    private final /* synthetic */ zzdvi zzfqf;
    private final /* synthetic */ zzbpo zzfqg;

    public zzbpr(zzbpo zzbpo, zzdvi zzdvi) {
        this.zzfqg = zzbpo;
        this.zzfqf = zzdvi;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbpj zzbpj) {
        zzbpo.zza(this.zzfqg, zzbpj.zzfpy, this.zzfqf);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzfqf.zzb(th);
        zzbpo.zza(this.zzfqg);
    }
}
