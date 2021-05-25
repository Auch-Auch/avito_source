package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzdfp implements zzden<zzdfm> {
    private final Executor executor;
    private final zzaxk zzbps;
    private final ScheduledExecutorService zzflf;
    private final int zzgjp;
    private final zzaxg zzgvu;
    private final Context zzvr;

    public zzdfp(zzaxg zzaxg, int i, Context context, zzaxk zzaxk, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzgvu = zzaxg;
        this.zzgjp = i;
        this.zzvr = context;
        this.zzbps = zzaxk;
        this.zzflf = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdfm> zzaqs() {
        return zzdvc.zzg(zzdvl.zza(new zzdut(this) { // from class: com.google.android.gms.internal.ads.zzdfo
            private final zzdfp zzgwd;

            {
                this.zzgwd = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdut
            public final zzdvt zzard() {
                return this.zzgwd.zzarm();
            }
        }, this.executor)).zza(zzdfr.zzdwg, this.executor).zza(((Long) zzwe.zzpu().zzd(zzaat.zzcoh)).longValue(), TimeUnit.MILLISECONDS, this.zzflf).zza(Exception.class, new zzdsl(this) { // from class: com.google.android.gms.internal.ads.zzdfq
            private final zzdfp zzgwd;

            {
                this.zzgwd = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return this.zzgwd.zzb((Exception) obj);
            }
        }, zzdvv.zzaxm());
    }

    public final /* synthetic */ zzdvt zzarm() throws Exception {
        return this.zzgvu.zza(this.zzvr, this.zzgjp);
    }

    public final /* synthetic */ zzdfm zzb(Exception exc) {
        this.zzbps.zza(exc, "AttestationTokenSignal");
        return null;
    }
}
