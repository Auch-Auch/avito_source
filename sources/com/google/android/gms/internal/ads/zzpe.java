package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.Arrays;
public final class zzpe {
    private int size;
    private long[] zzbjq;

    public zzpe() {
        this(32);
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.zzbjq;
        if (i == jArr.length) {
            this.zzbjq = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.zzbjq;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzbjq[i];
        }
        throw new IndexOutOfBoundsException(a.p2(46, "Invalid index ", i, ", size is ", this.size));
    }

    public final int size() {
        return this.size;
    }

    private zzpe(int i) {
        this.zzbjq = new long[32];
    }
}
