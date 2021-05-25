package com.google.android.gms.internal.ads;
public final class zzcsm implements zzdvi<zzbni> {
    private final /* synthetic */ zzcsh zzgma;

    public zzcsm(zzcsh zzcsh) {
        this.zzgma = zzcsh;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbni zzbni) {
        zzbni.zzahw();
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzuw zze = zzcmt.zze(th);
        this.zzgma.zzfue.zzg(zze);
        zzdly.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }
}
