package com.google.android.gms.internal.ads;

import java.io.IOException;
public final class zzks {
    private static final long[] zzawd = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzaox = new byte[8];

    public static int zzat(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = zzawd;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzjy zzjy, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!zzjy.zza(this.zzaox, 0, 1, z)) {
                return -1;
            }
            int zzat = zzat(this.zzaox[0] & 255);
            this.length = zzat;
            if (zzat != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.length;
        if (i2 > i) {
            this.state = 0;
            return -2;
        }
        if (i2 != 1) {
            zzjy.readFully(this.zzaox, 1, i2 - 1);
        }
        this.state = 0;
        return zza(this.zzaox, this.length, z2);
    }

    public final int zzgu() {
        return this.length;
    }

    public static long zza(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~zzawd[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
