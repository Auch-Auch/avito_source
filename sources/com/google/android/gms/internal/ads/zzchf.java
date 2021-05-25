package com.google.android.gms.internal.ads;
public final class zzchf implements zzdvi<zzbfq> {
    private final /* synthetic */ String zzemq;
    private final /* synthetic */ zzahf zzgco;

    public zzchf(zzchc zzchc, String str, zzahf zzahf) {
        this.zzemq = str;
        this.zzgco = zzahf;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbfq zzbfq) {
        zzbfq.zzb(this.zzemq, this.zzgco);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
    }
}
