package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
public class DefaultByteArrayPoolParams {
    public static PoolParams get() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(16384, 5);
        return new PoolParams(81920, 1048576, sparseIntArray);
    }
}
