package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public final class zzku extends zzkr {
    public final long zzawf;
    public final List<zzkt> zzawg = new ArrayList();
    public final List<zzku> zzawh = new ArrayList();

    public zzku(int i, long j) {
        super(i);
        this.zzawf = j;
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final String toString() {
        String zzas = zzkr.zzas(this.type);
        String arrays = Arrays.toString(this.zzawg.toArray());
        String arrays2 = Arrays.toString(this.zzawh.toArray());
        StringBuilder K = a.K(a.q0(arrays2, a.q0(arrays, a.q0(zzas, 22))), zzas, " leaves: ", arrays, " containers: ");
        K.append(arrays2);
        return K.toString();
    }

    public final void zza(zzkt zzkt) {
        this.zzawg.add(zzkt);
    }

    public final zzkt zzau(int i) {
        int size = this.zzawg.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkt zzkt = this.zzawg.get(i2);
            if (zzkt.type == i) {
                return zzkt;
            }
        }
        return null;
    }

    public final zzku zzav(int i) {
        int size = this.zzawh.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzku zzku = this.zzawh.get(i2);
            if (zzku.type == i) {
                return zzku;
            }
        }
        return null;
    }

    public final void zza(zzku zzku) {
        this.zzawh.add(zzku);
    }
}
