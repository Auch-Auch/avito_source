package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzbpo {
    private final Executor executor;
    private volatile boolean zzaey = true;
    private final ScheduledExecutorService zzflf;
    private final zzdvt<zzbpj> zzfqb;

    public zzbpo(Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdvt<zzbpj> zzdvt) {
        this.executor = executor2;
        this.zzflf = scheduledExecutorService;
        this.zzfqb = zzdvt;
    }

    /* access modifiers changed from: public */
    private final void zzaip() {
        zzbbi.zzedy.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbps
            private final zzbpo zzfqc;

            {
                this.zzfqc = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfqc.zzaiq();
            }
        });
    }

    public final boolean isLoading() {
        return this.zzaey;
    }

    public final void zza(zzdvi<zzbpd> zzdvi) {
        zzdvl.zza(this.zzfqb, new zzbpr(this, zzdvi), this.executor);
    }

    public final /* synthetic */ void zzaiq() {
        this.zzaey = false;
    }

    /* access modifiers changed from: public */
    private final void zza(List<? extends zzdvt<? extends zzbpd>> list, zzdvi<zzbpd> zzdvi) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new Runnable(zzdvi) { // from class: com.google.android.gms.internal.ads.zzbpn
                private final zzdvi zzfqa;

                {
                    this.zzfqa = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfqa.zzb(new zzcmt(zzdmd.zzhcq));
                }
            });
            return;
        }
        zzdvt zzaf = zzdvl.zzaf(null);
        Iterator<? extends zzdvt<? extends zzbpd>> it = list.iterator();
        while (it.hasNext()) {
            zzaf = zzdvl.zzb(zzdvl.zzb(zzaf, Throwable.class, new zzduv(zzdvi) { // from class: com.google.android.gms.internal.ads.zzbpq
                private final zzdvi zzfqa;

                {
                    this.zzfqa = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzduv
                public final zzdvt zzf(Object obj) {
                    this.zzfqa.zzb((Throwable) obj);
                    return zzdvl.zzaf(null);
                }
            }, this.executor), new zzduv(this, zzdvi, (zzdvt) it.next()) { // from class: com.google.android.gms.internal.ads.zzbpp
                private final zzbpo zzfqc;
                private final zzdvi zzfqd;
                private final zzdvt zzfqe;

                {
                    this.zzfqc = r1;
                    this.zzfqd = r2;
                    this.zzfqe = r3;
                }

                @Override // com.google.android.gms.internal.ads.zzduv
                public final zzdvt zzf(Object obj) {
                    return this.zzfqc.zza(this.zzfqd, this.zzfqe, (zzbpd) obj);
                }
            }, this.executor);
        }
        zzdvl.zza(zzaf, new zzbpu(this, zzdvi), this.executor);
    }

    public final /* synthetic */ zzdvt zza(zzdvi zzdvi, zzdvt zzdvt, zzbpd zzbpd) throws Exception {
        if (zzbpd != null) {
            zzdvi.onSuccess(zzbpd);
        }
        return zzdvl.zza(zzdvt, zzacx.zzdbv.get().longValue(), TimeUnit.MILLISECONDS, this.zzflf);
    }
}
