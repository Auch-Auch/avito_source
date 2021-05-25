package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzbqf implements zzdvi<Void> {
    private final /* synthetic */ zzbqb zzfqz;

    public zzbqf(zzbqb zzbqb) {
        this.zzfqz = zzbqb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@NullableDecl Void r2) {
        this.zzfqz.zzfqr.zzbh(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzfqz.zzfqr.zzbh(false);
    }
}
