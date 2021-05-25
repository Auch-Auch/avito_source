package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzchi implements zzdvi<zzbfq> {
    private final /* synthetic */ String zzgcp;
    private final /* synthetic */ Map zzgcq;

    public zzchi(zzchc zzchc, String str, Map map) {
        this.zzgcp = str;
        this.zzgcq = map;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzbfq zzbfq) {
        zzbfq.zza(this.zzgcp, this.zzgcq);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
    }
}
