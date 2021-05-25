package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
public final class zzcfd implements zzdsl<zzy, Bitmap> {
    private final /* synthetic */ double zzgau;
    private final /* synthetic */ boolean zzgav;
    private final /* synthetic */ zzcfe zzgaw;

    public zzcfd(zzcfe zzcfe, double d, boolean z) {
        this.zzgaw = zzcfe;
        this.zzgau = d;
        this.zzgav = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdsl
    public final /* synthetic */ Bitmap apply(zzy zzy) {
        return this.zzgaw.zza(zzy.data, this.zzgau, this.zzgav);
    }
}
