package com.google.android.gms.internal.measurement;

import java.util.Comparator;
public final class zzgv implements Comparator<zzgt> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzgt zzgt, zzgt zzgt2) {
        zzgt zzgt3 = zzgt;
        zzgt zzgt4 = zzgt2;
        zzgy zzgy = (zzgy) zzgt3.iterator();
        zzgy zzgy2 = (zzgy) zzgt4.iterator();
        while (zzgy.hasNext() && zzgy2.hasNext()) {
            int compare = Integer.compare(zzgt.zzb(zzgy.zza()), zzgt.zzb(zzgy2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgt3.zza(), zzgt4.zza());
    }
}
