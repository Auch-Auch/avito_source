package com.google.android.gms.internal.vision;

import java.util.List;
public final class zziy extends zzix {
    private zziy() {
        super();
    }

    private static <E> zzik<E> zzc(Object obj, long j) {
        return (zzik) zzld.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <L> List<L> zza(Object obj, long j) {
        zzik zzc = zzc(obj, j);
        if (zzc.zzei()) {
            return zzc;
        }
        int size = zzc.size();
        zzik zzan = zzc.zzan(size == 0 ? 10 : size << 1);
        zzld.zza(obj, j, zzan);
        return zzan;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzej();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzik<E> zzc = zzc(obj, j);
        zzik<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzik<E> zzik = zzc;
        zzik = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzei = zzc.zzei();
            zzik<E> zzik2 = zzc;
            if (!zzei) {
                zzik2 = zzc.zzan(size2 + size);
            }
            zzik2.addAll(zzc2);
            zzik = zzik2;
        }
        if (size > 0) {
            zzc2 = zzik;
        }
        zzld.zza(obj, j, zzc2);
    }
}
