package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.location.Location;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzdbp implements zzden<zzdbm> {
    private ApplicationInfo applicationInfo;
    private zzaya zzdza;
    private ScheduledExecutorService zzflf;
    public zzdln zzfqn;
    private zzamh zzgts;

    public zzdbp(zzamh zzamh, ScheduledExecutorService scheduledExecutorService, zzaya zzaya, ApplicationInfo applicationInfo2, zzdln zzdln) {
        this.zzgts = zzamh;
        this.zzflf = scheduledExecutorService;
        this.zzdza = zzaya;
        this.applicationInfo = applicationInfo2;
        this.zzfqn = zzdln;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdbm> zzaqs() {
        zzdvt zzdvt;
        if (!zzacd.zzczh.get().booleanValue()) {
            zzdvt = zzdvl.zzaf(null);
        } else if (!this.zzdza.zzxc()) {
            zzdvt = zzdvl.zzaf(null);
        } else {
            zzdvt = zzdvl.zzb(zzdvl.zza(this.zzgts.zza(this.applicationInfo), ((Long) zzwe.zzpu().zzd(zzaat.zzcsa)).longValue(), TimeUnit.MILLISECONDS, this.zzflf), Throwable.class, zzdbq.zzbok, zzbbi.zzedz);
        }
        return zzdvl.zzb(zzdvl.zzb(zzdvt, new zzdsl(this) { // from class: com.google.android.gms.internal.ads.zzdbr
            private final zzdbp zzgtt;

            {
                this.zzgtt = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                zzdbp zzdbp = this.zzgtt;
                Location location = (Location) obj;
                if (location != null) {
                    return location;
                }
                return zzdbp.zzfqn.zzhbu.zznb;
            }
        }, this.zzflf), zzdbo.zzdwg, zzbbi.zzedu);
    }
}
