package com.google.android.gms.internal.measurement;

import java.util.List;
public final class zziy extends zzit {
    private zziy() {
        super();
    }

    private static <E> zzik<E> zzc(Object obj, long j) {
        return (zzik) zzla.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzit
    public final <L> List<L> zza(Object obj, long j) {
        zzik zzc = zzc(obj, j);
        if (zzc.zza()) {
            return zzc;
        }
        int size = zzc.size();
        zzik zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzla.zza(obj, j, zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzit
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzik<E> zzc = zzc(obj, j);
        zzik<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzik<E> zzik = zzc;
        zzik = zzc;
        if (size > 0 && size2 > 0) {
            boolean zza = zzc.zza();
            zzik<E> zzik2 = zzc;
            if (!zza) {
                zzik2 = zzc.zza(size2 + size);
            }
            zzik2.addAll(zzc2);
            zzik = zzik2;
        }
        if (size > 0) {
            zzc2 = zzik;
        }
        zzla.zza(obj, j, zzc2);
    }
}
