package com.google.android.gms.internal.ads;

import java.util.Arrays;
public class zznu implements zzob {
    private final int length;
    private int zzahr;
    private final zzho[] zzbfk;
    private final zznq zzbgs;
    private final int[] zzbgt;
    private final long[] zzbgu;

    public zznu(zznq zznq, int... iArr) {
        int i = 0;
        zzoz.checkState(iArr.length > 0);
        this.zzbgs = (zznq) zzoz.checkNotNull(zznq);
        int length2 = iArr.length;
        this.length = length2;
        this.zzbfk = new zzho[length2];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbfk[i2] = zznq.zzbe(iArr[i2]);
        }
        Arrays.sort(this.zzbfk, new zznw());
        this.zzbgt = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbgt[i] = zznq.zzh(this.zzbfk[i]);
                i++;
            } else {
                this.zzbgu = new long[i3];
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznu zznu = (zznu) obj;
            if (this.zzbgs == zznu.zzbgs && Arrays.equals(this.zzbgt, zznu.zzbgt)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzahr == 0) {
            this.zzahr = Arrays.hashCode(this.zzbgt) + (System.identityHashCode(this.zzbgs) * 31);
        }
        return this.zzahr;
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final int length() {
        return this.zzbgt.length;
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final zzho zzbe(int i) {
        return this.zzbfk[i];
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final int zzbf(int i) {
        return this.zzbgt[0];
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final zznq zzij() {
        return this.zzbgs;
    }
}
