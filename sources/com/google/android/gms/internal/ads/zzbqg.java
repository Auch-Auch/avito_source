package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzbqg implements zzdvi<zzasp> {
    private final /* synthetic */ zzbqb zzfqz;

    public zzbqg(zzbqb zzbqb) {
        this.zzfqz = zzbqb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@NullableDecl zzasp zzasp) {
        this.zzfqz.zzfqr.zzbg(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzfqz.zzfqr.zzbg(false);
    }
}
