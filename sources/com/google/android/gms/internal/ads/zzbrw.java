package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzbrw implements zzdvi<Boolean> {
    private final /* synthetic */ zzbru zzfrv;

    public zzbrw(zzbru zzbru) {
        this.zzfrv = zzbru;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@NullableDecl Boolean bool) {
        this.zzfrv.zzfrn.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
    }
}
