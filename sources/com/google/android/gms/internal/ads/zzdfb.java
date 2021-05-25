package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzdfb implements zzden<zzdey> {
    private final Executor executor;
    private final ScheduledExecutorService zzflf;
    private final zzaxg zzgvu;
    private final Context zzvr;

    public zzdfb(zzaxg zzaxg, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzgvu = zzaxg;
        this.zzvr = context;
        this.zzflf = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdey> zzaqs() {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcog)).booleanValue()) {
            return zzdvl.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzdvc.zzg(this.zzgvu.zzal(this.zzvr)).zza(zzdfa.zzdwg, this.executor).zza(((Long) zzwe.zzpu().zzd(zzaat.zzcoh)).longValue(), TimeUnit.MILLISECONDS, this.zzflf).zza(Throwable.class, new zzdsl(this) { // from class: com.google.android.gms.internal.ads.zzdfd
            private final zzdfb zzgvv;

            {
                this.zzgvv = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return this.zzgvv.zzf((Throwable) obj);
            }
        }, this.executor);
    }

    public final /* synthetic */ zzdey zzf(Throwable th) {
        zzwe.zzpq();
        return new zzdey(null, zzbat.zzbn(this.zzvr));
    }
}
