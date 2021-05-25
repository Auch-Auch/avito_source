package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
public final class zzbmn implements zzrh {
    private final Clock zzbpw;
    @GuardedBy("this")
    private Runnable zzdze = null;
    private final ScheduledExecutorService zzfnh;
    @Nullable
    @GuardedBy("this")
    private ScheduledFuture<?> zzfni;
    @GuardedBy("this")
    private long zzfnj = -1;
    @GuardedBy("this")
    private long zzfnk = -1;
    @GuardedBy("this")
    private boolean zzfnl = false;

    public zzbmn(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfnh = scheduledExecutorService;
        this.zzbpw = clock;
        zzp.zzks().zza(this);
    }

    @VisibleForTesting
    private final synchronized void zzahc() {
        if (!this.zzfnl) {
            ScheduledFuture<?> scheduledFuture = this.zzfni;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zzfnk = -1;
            } else {
                this.zzfni.cancel(true);
                this.zzfnk = this.zzfnj - this.zzbpw.elapsedRealtime();
            }
            this.zzfnl = true;
        }
    }

    @VisibleForTesting
    private final synchronized void zzahd() {
        ScheduledFuture<?> scheduledFuture;
        if (this.zzfnl) {
            if (this.zzfnk > 0 && (scheduledFuture = this.zzfni) != null && scheduledFuture.isCancelled()) {
                this.zzfni = this.zzfnh.schedule(this.zzdze, this.zzfnk, TimeUnit.MILLISECONDS);
            }
            this.zzfnl = false;
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzdze = runnable;
        long j = (long) i;
        this.zzfnj = this.zzbpw.elapsedRealtime() + j;
        this.zzfni = this.zzfnh.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzrh
    public final void zzp(boolean z) {
        if (z) {
            zzahd();
        } else {
            zzahc();
        }
    }
}
