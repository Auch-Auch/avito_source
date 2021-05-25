package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
public final class zzboy implements zzbuj, zzqu {
    private final zzdkx zzflh;
    private final zzbtl zzfpk;
    private final zzbun zzfpl;
    private final AtomicBoolean zzfpm = new AtomicBoolean();
    private final AtomicBoolean zzfpn = new AtomicBoolean();

    public zzboy(zzdkx zzdkx, zzbtl zzbtl, zzbun zzbun) {
        this.zzflh = zzdkx;
        this.zzfpk = zzbtl;
        this.zzfpl = zzbun;
    }

    private final void zzaij() {
        if (this.zzfpm.compareAndSet(false, true)) {
            this.zzfpk.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        if (this.zzflh.zzhah != 1) {
            zzaij();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqr) {
        if (this.zzflh.zzhah == 1 && zzqr.zzbrk) {
            zzaij();
        }
        if (zzqr.zzbrk && this.zzfpn.compareAndSet(false, true)) {
            this.zzfpl.zzajl();
        }
    }
}
