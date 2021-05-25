package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbsg;
public final class zzcub extends zzcty<zzchu> {
    private final zzbxj zzetx;
    private final zzbii zzgmy;
    private final zzbsg.zza zzgmz;

    public zzcub(zzbii zzbii, zzbsg.zza zza, zzbxj zzbxj) {
        this.zzgmy = zzbii;
        this.zzgmz = zza;
        this.zzetx = zzbxj;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final zzdvt<zzchu> zza(zzdln zzdln, Bundle bundle) {
        return this.zzgmy.zzadv().zze(this.zzgmz.zza(zzdln).zzf(bundle).zzajj()).zze(this.zzetx).zzage().zzafc().zzaiv();
    }
}
