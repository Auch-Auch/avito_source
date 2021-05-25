package com.google.android.gms.internal.mlkit_vision_face;
public final class zzha extends zzgv {
    private zzha() {
        super();
    }

    private static <E> zzgm<E> zzb(Object obj, long j) {
        return (zzgm) zziz.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgv
    public final void zza(Object obj, long j) {
        zzb(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgv
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzgm<E> zzb = zzb(obj, j);
        zzgm<E> zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        zzgm<E> zzgm = zzb;
        zzgm = zzb;
        if (size > 0 && size2 > 0) {
            boolean zza = zzb.zza();
            zzgm<E> zzgm2 = zzb;
            if (!zza) {
                zzgm2 = zzb.zzb(size2 + size);
            }
            zzgm2.addAll(zzb2);
            zzgm = zzgm2;
        }
        if (size > 0) {
            zzb2 = zzgm;
        }
        zziz.zza(obj, j, zzb2);
    }
}
