package com.google.android.gms.internal.ads;
public final class zzcnu implements zzdvi<zzdlj> {
    private final /* synthetic */ zzcnr zzghs;

    public zzcnu(zzcnr zzcnr) {
        this.zzghs = zzcnr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzdlj zzdlj) {
        zzcnr.zza(this.zzghs).zzb(zzdlj);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
    }
}
