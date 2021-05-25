package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdin implements zzdvi<Void> {
    public zzdin(zzdii zzdii) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@NullableDecl Void r1) {
        zzaxy.zzei("Notification of cache hit successful.");
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzaxy.zzei("Notification of cache hit failed.");
    }
}
