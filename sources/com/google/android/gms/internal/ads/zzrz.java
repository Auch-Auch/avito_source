package com.google.android.gms.internal.ads;

import java.util.Comparator;
public final class zzrz implements Comparator<zzrn> {
    public zzrz(zzsa zzsa) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzrn zzrn, zzrn zzrn2) {
        zzrn zzrn3 = zzrn;
        zzrn zzrn4 = zzrn2;
        if (zzrn3.zzmm() < zzrn4.zzmm()) {
            return -1;
        }
        if (zzrn3.zzmm() > zzrn4.zzmm()) {
            return 1;
        }
        if (zzrn3.zzml() < zzrn4.zzml()) {
            return -1;
        }
        if (zzrn3.zzml() > zzrn4.zzml()) {
            return 1;
        }
        float zzmn = (zzrn3.zzmn() - zzrn3.zzml()) * (zzrn3.zzmo() - zzrn3.zzmm());
        float zzmn2 = (zzrn4.zzmn() - zzrn4.zzml()) * (zzrn4.zzmo() - zzrn4.zzmm());
        if (zzmn > zzmn2) {
            return -1;
        }
        if (zzmn < zzmn2) {
            return 1;
        }
        return 0;
    }
}
