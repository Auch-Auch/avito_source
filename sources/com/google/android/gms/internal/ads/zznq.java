package com.google.android.gms.internal.ads;

import java.util.Arrays;
public final class zznq {
    public final int length;
    private int zzahr;
    private final zzho[] zzbfk;

    public zznq(zzho... zzhoArr) {
        zzoz.checkState(zzhoArr.length > 0);
        this.zzbfk = zzhoArr;
        this.length = zzhoArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznq.class == obj.getClass()) {
            zznq zznq = (zznq) obj;
            if (this.length == zznq.length && Arrays.equals(this.zzbfk, zznq.zzbfk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahr == 0) {
            this.zzahr = Arrays.hashCode(this.zzbfk) + 527;
        }
        return this.zzahr;
    }

    public final zzho zzbe(int i) {
        return this.zzbfk[i];
    }

    public final int zzh(zzho zzho) {
        int i = 0;
        while (true) {
            zzho[] zzhoArr = this.zzbfk;
            if (i >= zzhoArr.length) {
                return -1;
            }
            if (zzho == zzhoArr[i]) {
                return i;
            }
            i++;
        }
    }
}
