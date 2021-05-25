package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public final class zzdwc<V> extends zzdvj<V> implements zzdvt<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zzhqi;

    public zzdwc(zzdvt<V> zzdvt, ScheduledFuture<?> scheduledFuture) {
        super(zzdvt);
        this.zzhqi = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzdvh, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zzhqi.cancel(z);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzhqi.compareTo((Delayed) obj);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zzhqi.getDelay(timeUnit);
    }
}
