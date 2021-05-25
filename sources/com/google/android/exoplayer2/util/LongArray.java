package com.google.android.exoplayer2.util;

import a2.b.a.a.a;
import java.util.Arrays;
public final class LongArray {
    public int a;
    public long[] b;

    public LongArray() {
        this(32);
    }

    public void add(long j) {
        int i = this.a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public long get(int i) {
        if (i >= 0 && i < this.a) {
            return this.b[i];
        }
        StringBuilder M = a.M("Invalid index ", i, ", size is ");
        M.append(this.a);
        throw new IndexOutOfBoundsException(M.toString());
    }

    public int size() {
        return this.a;
    }

    public long[] toArray() {
        return Arrays.copyOf(this.b, this.a);
    }

    public LongArray(int i) {
        this.b = new long[i];
    }
}
