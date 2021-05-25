package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
public final class zzbfw implements zzdvi<Map<String, String>> {
    private final /* synthetic */ zzbft zzemo;
    private final /* synthetic */ List zzemp;
    private final /* synthetic */ String zzemq;

    public zzbfw(zzbft zzbft, List list, String str) {
        this.zzemo = zzbft;
        this.zzemp = list;
        this.zzemq = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(Map<String, String> map) {
        this.zzemo.zza(map, this.zzemp, this.zzemq);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
    }
}
