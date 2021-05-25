package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
public final class zzcrd<DelegateT, AdapterT> implements zzcre<AdapterT> {
    @VisibleForTesting
    private final zzcre<DelegateT> zzgla;
    private final zzdsl<DelegateT, AdapterT> zzglb;

    public zzcrd(zzcre<DelegateT> zzcre, zzdsl<DelegateT, AdapterT> zzdsl) {
        this.zzgla = zzcre;
        this.zzglb = zzdsl;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        return this.zzgla.zza(zzdlj, zzdkx);
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<AdapterT> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        return zzdvl.zzb(this.zzgla.zzb(zzdlj, zzdkx), this.zzglb, zzbbi.zzedu);
    }
}
