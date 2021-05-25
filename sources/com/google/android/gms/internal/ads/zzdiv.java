package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdiv implements zzdsl<zzcpa, zzdix> {
    private final /* synthetic */ zzdit zzgza;

    public zzdiv(zzdit zzdit) {
        this.zzgza = zzdit;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdsl
    @NullableDecl
    public final /* synthetic */ zzdix apply(@NullableDecl zzcpa zzcpa) {
        zzbbd.zzc("", zzcpa);
        zzaxy.zzei("Failed to get a cache key, reverting to legacy flow.");
        zzdit zzdit = this.zzgza;
        zzdit.zzgyz = new zzdix(null, zzdit.zzash(), null);
        return this.zzgza.zzgyz;
    }
}
