package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;
public final class zzka implements Runnable {
    public long zza;
    public long zzb;
    public final /* synthetic */ zzkb zzc;

    public zzka(zzkb zzkb, long j, long j2) {
        this.zzc = zzkb;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzkd
            private final zzka zza;

            {
                this.zza = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzka zzka = this.zza;
                zzkb zzkb = zzka.zzc;
                long j = zzka.zza;
                long j2 = zzka.zzb;
                zzkb.zza.zzd();
                zzkb.zza.zzr().zzw().zza("Application going to the background");
                boolean z = true;
                if (zzkb.zza.zzt().zza(zzaq.zzcc)) {
                    zzkb.zza.zzs().zzr.zza(true);
                }
                Bundle bundle = new Bundle();
                if (!zzkb.zza.zzt().zzj().booleanValue()) {
                    zzkb.zza.zzb.zzb(j2);
                    if (zzkb.zza.zzt().zza(zzaq.zzbr)) {
                        bundle.putLong("_et", zzkb.zza.zza(j2));
                        zzin.zza(zzkb.zza.zzi().zza(true), bundle, true);
                    } else {
                        z = false;
                    }
                    zzkb.zza.zza(false, z, j2);
                }
                zzkb.zza.zzf().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
            }
        });
    }
}
