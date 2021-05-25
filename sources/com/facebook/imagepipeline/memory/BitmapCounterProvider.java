package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.ThreadSafe;
public class BitmapCounterProvider {
    public static final int MAX_BITMAP_TOTAL_SIZE;
    public static int a = 384;
    public static volatile BitmapCounter b;

    static {
        int i;
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (((long) min) > 16777216) {
            i = (min / 4) * 3;
        } else {
            i = min / 2;
        }
        MAX_BITMAP_TOTAL_SIZE = i;
    }

    @ThreadSafe
    public static BitmapCounter get() {
        if (b == null) {
            synchronized (BitmapCounterProvider.class) {
                if (b == null) {
                    b = new BitmapCounter(a, MAX_BITMAP_TOTAL_SIZE);
                }
            }
        }
        return b;
    }

    public static void initialize(BitmapCounterConfig bitmapCounterConfig) {
        if (b == null) {
            a = bitmapCounterConfig.getMaxBitmapCount();
            return;
        }
        throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
    }
}
