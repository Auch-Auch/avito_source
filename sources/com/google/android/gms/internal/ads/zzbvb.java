package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
public final class zzbvb extends zzbxe<zzbvf> {
    private final Clock zzbpw;
    @GuardedBy("this")
    private boolean zzfmt = false;
    private final ScheduledExecutorService zzfnh;
    @GuardedBy("this")
    private long zzfnj = -1;
    @GuardedBy("this")
    private long zzfnk = -1;
    @Nullable
    @GuardedBy("this")
    private ScheduledFuture<?> zzftc;

    public zzbvb(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfnh = scheduledExecutorService;
        this.zzbpw = clock;
    }

    /* access modifiers changed from: private */
    public final void zzajo() {
        zza(zzbva.zzfst);
    }

    private final synchronized void zzfe(long j) {
        ScheduledFuture<?> scheduledFuture = this.zzftc;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.zzftc.cancel(true);
        }
        this.zzfnj = this.zzbpw.elapsedRealtime() + j;
        this.zzftc = this.zzfnh.schedule(new zzbvc(this), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.zzfmt) {
            ScheduledFuture<?> scheduledFuture = this.zzftc;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zzfnk = -1;
            } else {
                this.zzftc.cancel(true);
                this.zzfnk = this.zzfnj - this.zzbpw.elapsedRealtime();
            }
            this.zzfmt = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfmt) {
            if (this.zzfnk > 0 && this.zzftc.isCancelled()) {
                zzfe(this.zzfnk);
            }
            this.zzfmt = false;
        }
    }

    public final synchronized void zzajn() {
        this.zzfmt = false;
        zzfe(0);
    }

    public final synchronized void zzdw(int i) {
        if (i > 0) {
            long millis = TimeUnit.SECONDS.toMillis((long) i);
            if (this.zzfmt) {
                long j = this.zzfnk;
                if (j <= 0 || millis >= j) {
                    millis = j;
                }
                this.zzfnk = millis;
                return;
            }
            long elapsedRealtime = this.zzbpw.elapsedRealtime();
            long j2 = this.zzfnj;
            if (elapsedRealtime > j2 || j2 - this.zzbpw.elapsedRealtime() > millis) {
                zzfe(millis);
            }
        }
    }
}
