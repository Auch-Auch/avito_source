package com.google.android.gms.internal.ads;

import java.util.Arrays;
public final class zznp {
    public static final zznp zzbgq = new zznp(new zznq[0]);
    public final int length;
    private int zzahr;
    private final zznq[] zzbgr;

    public zznp(zznq... zznqArr) {
        this.zzbgr = zznqArr;
        this.length = zznqArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznp.class == obj.getClass()) {
            zznp zznp = (zznp) obj;
            if (this.length == zznp.length && Arrays.equals(this.zzbgr, zznp.zzbgr)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahr == 0) {
            this.zzahr = Arrays.hashCode(this.zzbgr);
        }
        return this.zzahr;
    }

    public final int zza(zznq zznq) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbgr[i] == zznq) {
                return i;
            }
        }
        return -1;
    }

    public final zznq zzbd(int i) {
        return this.zzbgr[i];
    }
}
