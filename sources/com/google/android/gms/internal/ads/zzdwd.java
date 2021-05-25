package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdwd<V> extends zzdvf<V> {
    @NullableDecl
    private zzdvt<V> zzhqj;
    @NullableDecl
    private ScheduledFuture<?> zzhqk;

    private zzdwd(zzdvt<V> zzdvt) {
        this.zzhqj = (zzdvt) zzdsv.checkNotNull(zzdvt);
    }

    public static <V> zzdvt<V> zzb(zzdvt<V> zzdvt, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdwd zzdwd = new zzdwd(zzdvt);
        zzdwf zzdwf = new zzdwf(zzdwd);
        zzdwd.zzhqk = scheduledExecutorService.schedule(zzdwf, j, timeUnit);
        zzdvt.addListener(zzdwf, zzdva.INSTANCE);
        return zzdwd;
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhqj);
        ScheduledFuture<?> scheduledFuture = this.zzhqk;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzhqj = null;
        this.zzhqk = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final String pendingToString() {
        zzdvt<V> zzdvt = this.zzhqj;
        ScheduledFuture<?> scheduledFuture = this.zzhqk;
        if (zzdvt == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdvt);
        String s2 = a.s2(valueOf.length() + 14, "inputFuture=[", valueOf, "]");
        if (scheduledFuture == null) {
            return s2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return s2;
        }
        String valueOf2 = String.valueOf(s2);
        StringBuilder sb = new StringBuilder(valueOf2.length() + 43);
        sb.append(valueOf2);
        sb.append(", remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }
}
