package com.google.android.gms.internal.gtm;

import java.util.List;
public final class zzrx extends zzru {
    private zzrx() {
        super();
    }

    private static <E> zzrj<E> zzd(Object obj, long j) {
        return (zzrj) zztx.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.gtm.zzru
    public final <L> List<L> zza(Object obj, long j) {
        zzrj zzd = zzd(obj, j);
        if (zzd.zzmy()) {
            return zzd;
        }
        int size = zzd.size();
        zzrj zzaj = zzd.zzaj(size == 0 ? 10 : size << 1);
        zztx.zza(obj, j, zzaj);
        return zzaj;
    }

    @Override // com.google.android.gms.internal.gtm.zzru
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzmi();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.gtm.zzru
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzrj<E> zzd = zzd(obj, j);
        zzrj<E> zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        zzrj<E> zzrj = zzd;
        zzrj = zzd;
        if (size > 0 && size2 > 0) {
            boolean zzmy = zzd.zzmy();
            zzrj<E> zzrj2 = zzd;
            if (!zzmy) {
                zzrj2 = zzd.zzaj(size2 + size);
            }
            zzrj2.addAll(zzd2);
            zzrj = zzrj2;
        }
        if (size > 0) {
            zzd2 = zzrj;
        }
        zztx.zza(obj, j, zzd2);
    }
}
