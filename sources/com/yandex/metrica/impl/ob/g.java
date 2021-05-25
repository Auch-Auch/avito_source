package com.yandex.metrica.impl.ob;

import java.io.IOException;
public final class g {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final float[] c = new float[0];
    public static final double[] d = new double[0];
    public static final boolean[] e = new boolean[0];
    public static final String[] f = new String[0];
    public static final byte[][] g = new byte[0][];
    public static final byte[] h = new byte[0];

    public static int a(int i) {
        return i & 7;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(a aVar, int i) throws IOException {
        return aVar.b(i);
    }

    public static int b(int i) {
        return i >>> 3;
    }

    public static final int b(a aVar, int i) throws IOException {
        int t = aVar.t();
        aVar.b(i);
        int i2 = 1;
        while (aVar.a() == i) {
            aVar.b(i);
            i2++;
        }
        aVar.f(t);
        return i2;
    }
}
