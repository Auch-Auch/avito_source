package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsg;
public final class zzctw extends zzcty<zzbpj> {
    private final zzbxj zzetx;
    private final zzcbj zzetz;
    private final zzbii zzgmy;
    private final zzbsg.zza zzgmz;

    public zzctw(zzbii zzbii, zzcbj zzcbj, zzbsg.zza zza, zzbxj zzbxj) {
        this.zzgmy = zzbii;
        this.zzetz = zzcbj;
        this.zzgmz = zza;
        this.zzetx = zzbxj;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final zzdvt<zzbpj> zza(zzdln zzdln, Bundle bundle) {
        return this.zzgmy.zzadu().zza(this.zzgmz.zza(zzdln).zzf(bundle).zzajj()).zza(this.zzetx).zza(this.zzetz).zzaek().zzafc().zzaiv();
    }
}
