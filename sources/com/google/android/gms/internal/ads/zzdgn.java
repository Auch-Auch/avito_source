package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzdgn implements zzden<zzdgk> {
    private ScheduledExecutorService zzflf;
    private zzaqt zzgwr;
    private Context zzvr;

    public zzdgn(zzaqt zzaqt, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzgwr = zzaqt;
        this.zzflf = scheduledExecutorService;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdgk> zzaqs() {
        return zzdvl.zzb(zzdvl.zza(this.zzgwr.zzr(this.zzvr), ((Long) zzwe.zzpu().zzd(zzaat.zzcsi)).longValue(), TimeUnit.MILLISECONDS, this.zzflf), zzdgm.zzdwg, zzbbi.zzedu);
    }
}
