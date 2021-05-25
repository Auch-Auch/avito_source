package com.google.android.gms.internal.ads;

import android.os.SystemClock;
public final class zzpl implements zzpd {
    private boolean started;
    private zzhu zzafd = zzhu.zzahv;
    private long zzbkf;
    private long zzbkg;

    public final void start() {
        if (!this.started) {
            this.zzbkg = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzel(zzfx());
            this.started = false;
        }
    }

    public final void zza(zzpd zzpd) {
        zzel(zzpd.zzfx());
        this.zzafd = zzpd.zzfq();
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzb(zzhu zzhu) {
        if (this.started) {
            zzel(zzfx());
        }
        this.zzafd = zzhu;
        return zzhu;
    }

    public final void zzel(long j) {
        this.zzbkf = j;
        if (this.started) {
            this.zzbkg = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzfq() {
        return this.zzafd;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final long zzfx() {
        long j;
        long j2 = this.zzbkf;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkg;
        zzhu zzhu = this.zzafd;
        if (zzhu.zzahw == 1.0f) {
            j = zzha.zzdn(elapsedRealtime);
        } else {
            j = zzhu.zzdu(elapsedRealtime);
        }
        return j2 + j;
    }
}
