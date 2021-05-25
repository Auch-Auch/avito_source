package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Comparator;
public final class zzfb implements Comparator<zzez> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzez zzez, zzez zzez2) {
        zzez zzez3 = zzez;
        zzez zzez4 = zzez2;
        zzfi zzfi = (zzfi) zzez3.iterator();
        zzfi zzfi2 = (zzfi) zzez4.iterator();
        while (zzfi.hasNext() && zzfi2.hasNext()) {
            int compare = Integer.compare(zzez.zzb(zzfi.zza()), zzez.zzb(zzfi2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzez3.zza(), zzez4.zza());
    }
}
