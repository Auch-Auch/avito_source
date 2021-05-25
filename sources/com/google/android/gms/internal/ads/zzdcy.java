package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdek;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzdcy<S extends zzdek<?>> implements zzden<S> {
    private final ScheduledExecutorService zzfnh;
    private final zzden<S> zzgtp;
    private final long zzgug;

    public zzdcy(zzden<S> zzden, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgtp = zzden;
        this.zzgug = j;
        this.zzfnh = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<S> zzaqs() {
        zzdvt<S> zzaqs = this.zzgtp.zzaqs();
        long j = this.zzgug;
        if (j > 0) {
            zzaqs = zzdvl.zza(zzaqs, j, TimeUnit.MILLISECONDS, this.zzfnh);
        }
        return zzdvl.zzb(zzaqs, Throwable.class, zzddb.zzbok, zzbbi.zzedz);
    }
}
