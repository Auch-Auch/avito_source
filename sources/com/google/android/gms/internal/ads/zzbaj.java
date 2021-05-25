package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import javax.annotation.concurrent.GuardedBy;
public final class zzbaj {
    private final Object lock = new Object();
    private long zzecm;
    @GuardedBy("lock")
    private long zzecn = Long.MIN_VALUE;

    public zzbaj(long j) {
        this.zzecm = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzp.zzkw().elapsedRealtime();
            if (this.zzecn + this.zzecm > elapsedRealtime) {
                return false;
            }
            this.zzecn = elapsedRealtime;
            return true;
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzecm = j;
        }
    }
}
