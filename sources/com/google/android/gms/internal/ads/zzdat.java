package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzdat implements zzden<zzdaq> {
    private final Executor executor;
    private final ScheduledExecutorService zzflf;
    private final Context zzvr;

    public zzdat(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzvr = context;
        this.zzflf = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdaq> zzaqs() {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcwc)).booleanValue()) {
            return zzdvl.zzaf(null);
        }
        zzbbq zzbbq = new zzbbq();
        try {
            new zzdsh(zzbbq) { // from class: com.google.android.gms.internal.ads.zzdas
                private final zzbbq zzbvp;

                {
                    this.zzbvp = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdsh
                public final void zzbm(boolean z) {
                    this.zzbvp.set(Boolean.FALSE);
                }
            }.zzbm(false);
        } catch (Throwable unused) {
            zzbbd.zzfc("ArCoreApk is not ready.");
            zzbbq.set(Boolean.FALSE);
        }
        return zzdvl.zzb(zzdvl.zzb(zzdvl.zza(zzbbq, 200, TimeUnit.MILLISECONDS, this.zzflf), new zzdsl(this) { // from class: com.google.android.gms.internal.ads.zzdav
            private final zzdat zzgtg;

            {
                this.zzgtg = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return new zzdaq(false, false, ((Boolean) obj).booleanValue());
            }
        }, this.executor), Throwable.class, zzdau.zzbok, this.executor);
    }
}
