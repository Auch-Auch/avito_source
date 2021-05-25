package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
public class DefaultBitmapPoolParams {
    public static final SparseIntArray a = new SparseIntArray(0);

    public static PoolParams get() {
        int i;
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min > 16777216) {
            i = (min / 4) * 3;
        } else {
            i = min / 2;
        }
        return new PoolParams(0, i, a);
    }
}
