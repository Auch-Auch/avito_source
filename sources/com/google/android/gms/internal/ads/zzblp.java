package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzblp implements zzdvi<String> {
    private final /* synthetic */ String zzflo;
    private final /* synthetic */ zzbln zzflp;

    public zzblp(zzbln zzbln, String str) {
        this.zzflp = zzbln;
        this.zzflo = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        this.zzflp.zzfli.zza(this.zzflp.zzflg, this.zzflp.zzflh, false, this.zzflo, str, this.zzflp.zzflh.zzdit);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzflp.zzfli.zza(this.zzflp.zzflg, this.zzflp.zzflh, false, this.zzflo, null, this.zzflp.zzflh.zzdit);
    }
}
