package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzcsh implements zzcre<zzbni> {
    private final ScheduledExecutorService zzflf;
    private final zzbsx zzfue;
    private final zzdvw zzgay;
    private final zzboe zzglv;
    private final zzcrn zzglw;

    public zzcsh(zzboe zzboe, zzcrn zzcrn, zzbsx zzbsx, ScheduledExecutorService scheduledExecutorService, zzdvw zzdvw) {
        this.zzglv = zzboe;
        this.zzglw = zzcrn;
        this.zzfue = zzbsx;
        this.zzflf = scheduledExecutorService;
        this.zzgay = zzdvw;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        return zzdlj.zzhbp.zzfqn.zzasp() != null && this.zzglw.zza(zzdlj, zzdkx);
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<zzbni> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        return this.zzgay.zze(new Callable(this, zzdlj, zzdkx) { // from class: com.google.android.gms.internal.ads.zzcsk
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcsh zzgly;

            {
                this.zzgly = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgly.zzc(this.zzgbj, this.zzfoo);
            }
        });
    }

    public final /* synthetic */ zzbni zzc(zzdlj zzdlj, zzdkx zzdkx) throws Exception {
        return this.zzglv.zza(new zzbpt(zzdlj, zzdkx, null), new zzbos(zzdlj.zzhbp.zzfqn.zzasp(), new Runnable(this, zzdlj, zzdkx) { // from class: com.google.android.gms.internal.ads.zzcsj
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcsh zzgly;

            {
                this.zzgly = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgly.zzd(this.zzgbj, this.zzfoo);
            }
        })).zzafy();
    }

    public final /* synthetic */ void zzd(zzdlj zzdlj, zzdkx zzdkx) {
        zzdvl.zza(zzdvl.zza(this.zzglw.zzb(zzdlj, zzdkx), (long) zzdkx.zzhax, TimeUnit.SECONDS, this.zzflf), new zzcsm(this), this.zzgay);
    }
}
