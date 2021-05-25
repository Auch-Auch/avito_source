package com.google.android.gms.internal.ads;

import java.util.List;
public final class zzeho extends zzehj {
    private zzeho() {
        super();
    }

    private static <E> zzeha<E> zzd(Object obj, long j) {
        return (zzeha) zzejt.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final <L> List<L> zza(Object obj, long j) {
        zzeha zzd = zzd(obj, j);
        if (zzd.zzbdf()) {
            return zzd;
        }
        int size = zzd.size();
        zzeha zzft = zzd.zzft(size == 0 ? 10 : size << 1);
        zzejt.zza(obj, j, zzft);
        return zzft;
    }

    @Override // com.google.android.gms.internal.ads.zzehj
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzbdg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.ads.zzehj
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzeha<E> zzd = zzd(obj, j);
        zzeha<E> zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        zzeha<E> zzeha = zzd;
        zzeha = zzd;
        if (size > 0 && size2 > 0) {
            boolean zzbdf = zzd.zzbdf();
            zzeha<E> zzeha2 = zzd;
            if (!zzbdf) {
                zzeha2 = zzd.zzft(size2 + size);
            }
            zzeha2.addAll(zzd2);
            zzeha = zzeha2;
        }
        if (size > 0) {
            zzd2 = zzeha;
        }
        zzejt.zza(obj, j, zzd2);
    }
}
