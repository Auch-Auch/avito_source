package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
public final class zzh {
    public static final zzh zza = zza().zzb().zzc();
    private static final zzh zzb = zza().zza().zzc();
    private final boolean zzc;
    private final boolean zzd;
    private final zzad<zzo> zze;

    private zzh(boolean z, boolean z2, zzad<zzo> zzad) {
        this.zzc = z;
        this.zzd = false;
        this.zze = zzad;
    }

    private static zzg zza() {
        return new zzg(null);
    }

    public static /* synthetic */ int zza(zzh zzh, Context context, zzr zzr) {
        zzad<zzo> zzad = zzh.zze;
        int size = zzad.size();
        int i = 0;
        while (i < size) {
            zzo zzo = zzad.get(i);
            i++;
            int i2 = zze.zza[zzo.zza(context, zzr, zzh.zzc) - 1];
            if (i2 == 1) {
                return zzq.zza;
            }
            if (i2 == 2) {
                return zzq.zzb;
            }
        }
        return zzq.zzc;
    }

    public /* synthetic */ zzh(boolean z, boolean z2, zzad zzad, zze zze2) {
        this(z, false, zzad);
    }
}
