package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public final class zzcnq {
    private final ScheduledExecutorService zzflf;
    private final zzdvw zzgay;
    private final zzeli<zzcpj> zzghc;
    private final zzcol zzghn;

    public zzcnq(ScheduledExecutorService scheduledExecutorService, zzdvw zzdvw, zzcol zzcol, zzeli<zzcpj> zzeli) {
        this.zzflf = scheduledExecutorService;
        this.zzgay = zzdvw;
        this.zzghn = zzcol;
        this.zzghc = zzeli;
    }

    public final /* synthetic */ zzdvt zza(zzasp zzasp, int i, Throwable th) throws Exception {
        return this.zzghc.get().zzd(zzasp, i);
    }

    public final zzdvt<InputStream> zzg(zzasp zzasp) {
        zzdvt<InputStream> zzdvt;
        String str = zzasp.packageName;
        zzp.zzkp();
        if (zzayh.zzer(str)) {
            zzdvt = zzdvl.immediateFailedFuture(new zzcpa(zzdmd.zzhco));
        } else {
            zzdvt = this.zzghn.zzj(zzasp);
        }
        int callingUid = Binder.getCallingUid();
        return zzdvc.zzg(zzdvt).zza((long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcuo)).intValue(), TimeUnit.SECONDS, this.zzflf).zza(Throwable.class, new zzduv(this, zzasp, callingUid) { // from class: com.google.android.gms.internal.ads.zzcnp
            private final int zzeay;
            private final zzasp zzggz;
            private final zzcnq zzghm;

            {
                this.zzghm = r1;
                this.zzggz = r2;
                this.zzeay = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzghm.zza(this.zzggz, this.zzeay, (Throwable) obj);
            }
        }, this.zzgay);
    }
}
