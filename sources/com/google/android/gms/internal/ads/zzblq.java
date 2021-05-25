package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzblq implements zzdvi<String> {
    private final /* synthetic */ zzbln zzflp;

    public zzblq(zzbln zzbln) {
        this.zzflp = zzbln;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        this.zzflp.zzfli.zza(this.zzflp.zzflg, this.zzflp.zzflh, false, "", str, this.zzflp.zzflh.zzdis);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzflp.zzfli.zza(this.zzflp.zzflg, this.zzflp.zzflh, false, "", "failure_click_attok", this.zzflp.zzflh.zzdis);
    }
}
