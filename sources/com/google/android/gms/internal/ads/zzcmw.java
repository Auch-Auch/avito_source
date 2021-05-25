package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
public final class zzcmw {
    private final zzdvw zzgay;
    private final zzdvw zzgha;
    private final zzcoh zzghb;
    private final zzeli<zzcpj> zzghc;

    public zzcmw(zzdvw zzdvw, zzdvw zzdvw2, zzcoh zzcoh, zzeli<zzcpj> zzeli) {
        this.zzgha = zzdvw;
        this.zzgay = zzdvw2;
        this.zzghb = zzcoh;
        this.zzghc = zzeli;
    }

    public final /* synthetic */ zzdvt zza(zzasp zzasp, int i, zzcpa zzcpa) throws Exception {
        return this.zzghc.get().zzb(zzasp, i);
    }

    public final zzdvt<InputStream> zze(zzasp zzasp) {
        zzdvt zzdvt;
        String str = zzasp.packageName;
        zzp.zzkp();
        if (zzayh.zzer(str)) {
            zzdvt = zzdvl.immediateFailedFuture(new zzcpa(zzdmd.zzhco));
        } else {
            zzdvt = zzdvl.zzb(this.zzgha.zze(new Callable(this, zzasp) { // from class: com.google.android.gms.internal.ads.zzcmv
                private final zzcmw zzggy;
                private final zzasp zzggz;

                {
                    this.zzggy = r1;
                    this.zzggz = r2;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzggy.zzf(this.zzggz);
                }
            }), ExecutionException.class, zzcmy.zzbok, this.zzgay);
        }
        return zzdvl.zzb(zzdvt, zzcpa.class, new zzduv(this, zzasp, Binder.getCallingUid()) { // from class: com.google.android.gms.internal.ads.zzcmx
            private final int zzeay;
            private final zzcmw zzggy;
            private final zzasp zzggz;

            {
                this.zzggy = r1;
                this.zzggz = r2;
                this.zzeay = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzggy.zza(this.zzggz, this.zzeay, (zzcpa) obj);
            }
        }, this.zzgay);
    }

    public final /* synthetic */ InputStream zzf(zzasp zzasp) throws Exception {
        return this.zzghb.zzi(zzasp).get((long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcuo)).intValue(), TimeUnit.SECONDS);
    }
}
