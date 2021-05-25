package com.google.android.gms.internal.vision;

import java.util.Comparator;
public final class zzgu implements Comparator<zzgs> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzgs zzgs, zzgs zzgs2) {
        zzgs zzgs3 = zzgs;
        zzgs zzgs4 = zzgs2;
        zzhb zzhb = (zzhb) zzgs3.iterator();
        zzhb zzhb2 = (zzhb) zzgs4.iterator();
        while (zzhb.hasNext() && zzhb2.hasNext()) {
            int compare = Integer.compare(zzgs.zza(zzhb.nextByte()), zzgs.zza(zzhb2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgs3.size(), zzgs4.size());
    }
}
