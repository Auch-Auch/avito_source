package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.internal.ads.zzbse;
public final class zzdih<R extends zzbse<AdT>, AdT extends zzbpd> implements zzdnw<AdT> {
    private final zzdiz<R, zzdnh<AdT>> zzgyq;

    public zzdih(zzdiz<R, zzdnh<AdT>> zzdiz) {
        this.zzgyq = zzdiz;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.ads.zzdiz<R extends com.google.android.gms.internal.ads.zzbse<AdT>, com.google.android.gms.internal.ads.zzdnh<AdT extends com.google.android.gms.internal.ads.zzbpd>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdnw
    public final zzdvt<zzdnh<AdT>> zza(zzdnv zzdnv) {
        zzdig zzdig = (zzdig) zzdnv;
        return this.zzgyq.zza(zzdig.zzgyo, zzdig.zzgyn);
    }

    @Override // com.google.android.gms.internal.ads.zzdnw
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzdnw
    public final void zza(zzdnh<AdT> zzdnh) {
        zzdnh.zzhfh = this.zzgyq.zzasb().zzafc();
    }
}
