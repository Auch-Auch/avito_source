package com.google.android.gms.internal.ads;

import java.util.Comparator;
public final class zzrs implements Comparator<zzry> {
    public zzrs(zzrp zzrp) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzry zzry, zzry zzry2) {
        zzry zzry3 = zzry;
        zzry zzry4 = zzry2;
        int i = zzry3.zzbtv - zzry4.zzbtv;
        if (i != 0) {
            return i;
        }
        return (int) (zzry3.value - zzry4.value);
    }
}
