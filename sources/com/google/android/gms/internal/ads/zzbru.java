package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public final class zzbru implements zzbsu, zzbti, zzbwt, zzbyh {
    private final Executor executor;
    private final zzbtl zzfrn;
    private final zzdkx zzfro;
    private final ScheduledExecutorService zzfrp;
    private zzdwe<Boolean> zzfrq = zzdwe.zzaxn();
    private ScheduledFuture<?> zzfrr;

    public zzbru(zzbtl zzbtl, zzdkx zzdkx, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzfrn = zzbtl;
        this.zzfro = zzdkx;
        this.zzfrp = scheduledExecutorService;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdOpened() {
        int i = this.zzfro.zzhaz;
        if (i == 0 || i == 1) {
            this.zzfrn.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zzaix() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpx)).booleanValue()) {
            zzdkx zzdkx = this.zzfro;
            if (zzdkx.zzhaz != 2) {
                return;
            }
            if (zzdkx.zzham == 0) {
                this.zzfrn.onAdImpression();
                return;
            }
            zzdvl.zza(this.zzfrq, new zzbrw(this), this.executor);
            this.zzfrr = this.zzfrp.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbrt
                private final zzbru zzfrm;

                {
                    this.zzfrm = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfrm.zzajb();
                }
            }, (long) this.zzfro.zzham, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final synchronized void zzaiy() {
        if (!this.zzfrq.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzfrr;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zzfrq.set(Boolean.TRUE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zzaiz() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzaja() {
    }

    public final /* synthetic */ void zzajb() {
        synchronized (this) {
            if (!this.zzfrq.isDone()) {
                this.zzfrq.set(Boolean.TRUE);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void zzb(zzatj zzatj, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbti
    public final synchronized void zzf(zzuw zzuw) {
        if (!this.zzfrq.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzfrr;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zzfrq.setException(new Exception());
        }
    }
}
