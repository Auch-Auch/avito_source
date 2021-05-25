package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsg;
public final class zzctz extends zzcty<zzbzr> {
    private final zzbxj zzetx;
    private final zzcwh zzfga;
    private final zzbii zzgmy;
    private final zzbsg.zza zzgmz;

    public zzctz(zzbii zzbii, zzbsg.zza zza, zzcwh zzcwh, zzbxj zzbxj) {
        this.zzgmy = zzbii;
        this.zzgmz = zza;
        this.zzfga = zzcwh;
        this.zzetx = zzbxj;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final zzdvt<zzbzr> zza(zzdln zzdln, Bundle bundle) {
        return this.zzgmy.zzadt().zzd(this.zzgmz.zza(zzdln).zzf(bundle).zzajj()).zzd(this.zzetx).zzb(this.zzfga).zzafz().zzafc().zzaiv();
    }
}
