package com.google.android.gms.internal.mlkit_common;

import java.util.Comparator;
public final class zzer implements Comparator<zzep> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzep zzep, zzep zzep2) {
        zzep zzep3 = zzep;
        zzep zzep4 = zzep2;
        zzeu zzeu = (zzeu) zzep3.iterator();
        zzeu zzeu2 = (zzeu) zzep4.iterator();
        while (zzeu.hasNext() && zzeu2.hasNext()) {
            int compare = Integer.compare(zzep.zzb(zzeu.zza()), zzep.zzb(zzeu2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzep3.zza(), zzep4.zza());
    }
}
