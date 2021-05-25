package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm;
public final class zzep {
    public static zzbm.zzae zza(int i, int i2) {
        zzbm.zzae.zza zza;
        zzbm.zzae.zzb zza2 = zzbm.zzae.zza();
        if (i == -1) {
            zza = zzbm.zzae.zza.BITMAP;
        } else if (i == 35) {
            zza = zzbm.zzae.zza.YUV_420_888;
        } else if (i == 842094169) {
            zza = zzbm.zzae.zza.YV12;
        } else if (i == 16) {
            zza = zzbm.zzae.zza.NV16;
        } else if (i != 17) {
            zza = zzbm.zzae.zza.UNKNOWN_FORMAT;
        } else {
            zza = zzbm.zzae.zza.NV21;
        }
        return (zzbm.zzae) ((zzgd) zza2.zza(zza).zza(i2).zzh());
    }
}
