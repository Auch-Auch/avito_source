package com.google.android.gms.internal.ads;

import java.util.Arrays;
public final class zzkf {
    public final int zzaov = 1;
    public final byte[] zzaow;

    public zzkf(int i, byte[] bArr) {
        this.zzaow = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkf.class == obj.getClass()) {
            zzkf zzkf = (zzkf) obj;
            if (this.zzaov == zzkf.zzaov && Arrays.equals(this.zzaow, zzkf.zzaow)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzaow) + (this.zzaov * 31);
    }
}
