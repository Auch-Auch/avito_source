package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;
@TargetApi(21)
public final class zzif {
    private static final zzif zzaiv = new zzif(new int[]{2}, 2);
    private final int[] zzaiw;
    private final int zzaix = 2;

    private zzif(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzaiw = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzif)) {
            return false;
        }
        zzif zzif = (zzif) obj;
        return Arrays.equals(this.zzaiw, zzif.zzaiw) && this.zzaix == zzif.zzaix;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzaiw) * 31) + this.zzaix;
    }

    public final String toString() {
        int i = this.zzaix;
        String arrays = Arrays.toString(this.zzaiw);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zzw(int i) {
        return Arrays.binarySearch(this.zzaiw, i) >= 0;
    }
}
