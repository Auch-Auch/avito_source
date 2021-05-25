package com.google.android.gms.internal.ads;
public final class zzbpu implements zzdvi<zzbpd> {
    private final /* synthetic */ zzdvi zzfqf;
    private final /* synthetic */ zzbpo zzfqg;

    public zzbpu(zzbpo zzbpo, zzdvi zzdvi) {
        this.zzfqg = zzbpo;
        this.zzfqf = zzdvi;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbpd zzbpd) {
        zzbpo.zza(this.zzfqg);
        this.zzfqf.onSuccess(zzbpd);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzbpo.zza(this.zzfqg);
        this.zzfqf.zzb(th);
    }
}
