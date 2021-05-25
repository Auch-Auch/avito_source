package com.google.android.gms.internal.mlkit_vision_common;
public final class zzfg extends zzfb {
    private zzfg() {
        super();
    }

    private static <E> zzes<E> zzb(Object obj, long j) {
        return (zzes) zzhf.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfb
    public final void zza(Object obj, long j) {
        zzb(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfb
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzes<E> zzb = zzb(obj, j);
        zzes<E> zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        zzes<E> zzes = zzb;
        zzes = zzb;
        if (size > 0 && size2 > 0) {
            boolean zza = zzb.zza();
            zzes<E> zzes2 = zzb;
            if (!zza) {
                zzes2 = zzb.zzb(size2 + size);
            }
            zzes2.addAll(zzb2);
            zzes = zzes2;
        }
        if (size > 0) {
            zzb2 = zzes;
        }
        zzhf.zza(obj, j, zzb2);
    }
}
