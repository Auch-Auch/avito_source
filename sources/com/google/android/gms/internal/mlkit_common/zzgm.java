package com.google.android.gms.internal.mlkit_common;
public final class zzgm extends zzgl {
    private zzgm() {
        super();
    }

    private static <E> zzfy<E> zzb(Object obj, long j) {
        return (zzfy) zzip.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgl
    public final void zza(Object obj, long j) {
        zzb(obj, j).b_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.mlkit_common.zzgl
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzfy<E> zzb = zzb(obj, j);
        zzfy<E> zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        zzfy<E> zzfy = zzb;
        zzfy = zzb;
        if (size > 0 && size2 > 0) {
            boolean zza = zzb.zza();
            zzfy<E> zzfy2 = zzb;
            if (!zza) {
                zzfy2 = zzb.zzb(size2 + size);
            }
            zzfy2.addAll(zzb2);
            zzfy = zzfy2;
        }
        if (size > 0) {
            zzb2 = zzfy;
        }
        zzip.zza(obj, j, zzb2);
    }
}
