package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
public final class zzcwl implements zzcwf<zzbzr> {
    private final zzcar zzglr;
    private final Context zzvr;

    public zzcwl(Context context, zzcar zzcar) {
        this.zzvr = context;
        this.zzglr = zzcar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzcwf
    public final /* synthetic */ zzbzr zza(zzdlj zzdlj, zzdkx zzdkx, View view, zzcwm zzcwm) {
        zzbzt zza = this.zzglr.zza(new zzbpt(zzdlj, zzdkx, null), new zzcwn(this, zzcwo.zzgpg));
        zzcwm.zza(new zzcwq(this, zza));
        return zza.zzagb();
    }
}
