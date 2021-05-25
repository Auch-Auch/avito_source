package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Comparator;
public final class zzdh implements Comparator<zzdf> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdf zzdf, zzdf zzdf2) {
        zzdf zzdf3 = zzdf;
        zzdf zzdf4 = zzdf2;
        zzdo zzdo = (zzdo) zzdf3.iterator();
        zzdo zzdo2 = (zzdo) zzdf4.iterator();
        while (zzdo.hasNext() && zzdo2.hasNext()) {
            int compare = Integer.compare(zzdf.zzb(zzdo.zza()), zzdf.zzb(zzdo2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdf3.zza(), zzdf4.zza());
    }
}
