package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
public final class b {
    private final byte[] a;
    private final int b;
    private int c;

    public static class a extends IOException {
        public a(int i, int i2) {
            super(a2.b.a.a.a.S2("CodedOutputStream was writing to a flat byte array and ran out of space (pos ", i, " limit ", i2, ")."));
        }
    }

    private b(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static int b(double d) {
        return 8;
    }

    public static int b(float f) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int d(int i, long j) {
        return d(j) + h(i);
    }

    public static int e(int i, long j) {
        return e(j) + h(i);
    }

    public static int f(int i, int i2) {
        return f(i2) + h(i);
    }

    public static int h(int i) {
        return j(g.a(i, 0));
    }

    public static int h(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int j(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static long j(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int l(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public void b(int i, long j) throws IOException {
        g(i, 0);
        b(j);
    }

    public void c(int i, int i2) throws IOException {
        g(i, 0);
        c(i2);
    }

    public void g(int i) throws IOException {
        a((byte) i);
    }

    public void i(int i) throws IOException {
        while ((i & -128) != 0) {
            g((i & 127) | 128);
            i >>>= 7;
        }
        g(i);
    }

    public void k(int i) throws IOException {
        g(i & 255);
        g((i >> 8) & 255);
        g((i >> 16) & 255);
        g((i >> 24) & 255);
    }

    public static int d(int i, int i2) {
        return d(i2) + h(i);
    }

    public static int e(int i, int i2) {
        return e(i2) + h(i);
    }

    public static int f(int i, long j) {
        return f(j) + h(i);
    }

    public void a(int i, double d) throws IOException {
        g(i, 1);
        a(d);
    }

    public void g(int i, int i2) throws IOException {
        i(g.a(i, i2));
    }

    public static int d(long j) {
        return h(j);
    }

    public static int e(long j) {
        return h(j);
    }

    public static int f(int i) {
        return j(l(i));
    }

    public void b(int i, int i2) throws IOException {
        g(i, 0);
        b(i2);
    }

    public void c(int i, long j) throws IOException {
        g(i, 0);
        c(j);
    }

    public void g(long j) throws IOException {
        while ((-128 & j) != 0) {
            g((((int) j) & 127) | 128);
            j >>>= 7;
        }
        g((int) j);
    }

    public void i(long j) throws IOException {
        g(((int) j) & 255);
        g(((int) (j >> 8)) & 255);
        g(((int) (j >> 16)) & 255);
        g(((int) (j >> 24)) & 255);
        g(((int) (j >> 32)) & 255);
        g(((int) (j >> 40)) & 255);
        g(((int) (j >> 48)) & 255);
        g(((int) (j >> 56)) & 255);
    }

    public static int d(int i) {
        if (i >= 0) {
            return j(i);
        }
        return 10;
    }

    public static int e(int i) {
        return j(i);
    }

    public static int f(long j) {
        return h(j(j));
    }

    public void a(int i, float f) throws IOException {
        g(i, 5);
        a(f);
    }

    public void b(long j) throws IOException {
        g(j);
    }

    public void c(int i) throws IOException {
        i(l(i));
    }

    public void a(int i, long j) throws IOException {
        g(i, 0);
        a(j);
    }

    public void b(int i) throws IOException {
        i(i);
    }

    public void c(long j) throws IOException {
        g(j(j));
    }

    public static int b(int i, double d) {
        return b(d) + h(i);
    }

    public void c(byte[] bArr) throws IOException {
        b(bArr, 0, bArr.length);
    }

    public static int b(int i, float f) {
        return b(f) + h(i);
    }

    public void a(int i, int i2) throws IOException {
        g(i, 0);
        a(i2);
    }

    public static int b(int i, boolean z) {
        return b(z) + h(i);
    }

    public static int b(int i, String str) {
        return b(str) + h(i);
    }

    public void a(int i, boolean z) throws IOException {
        g(i, 0);
        a(z);
    }

    public static int b(int i, e eVar) {
        return b(eVar) + h(i);
    }

    public static int b(int i, byte[] bArr) {
        return b(bArr) + h(i);
    }

    public void a(int i, String str) throws IOException {
        g(i, 2);
        a(str);
    }

    public static int b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return j(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public void a(int i, e eVar) throws IOException {
        g(i, 2);
        a(eVar);
    }

    public static int b(e eVar) {
        int b2 = eVar.b();
        return j(b2) + b2;
    }

    public void a(int i, byte[] bArr) throws IOException {
        g(i, 2);
        a(bArr);
    }

    public static int b(byte[] bArr) {
        return j(bArr.length) + bArr.length;
    }

    public void a(double d) throws IOException {
        i(Double.doubleToLongBits(d));
    }

    public void a(float f) throws IOException {
        k(Float.floatToIntBits(f));
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void a(long j) throws IOException {
        g(j);
    }

    public void a(int i) throws IOException {
        if (i >= 0) {
            i(i);
        } else {
            g((long) i);
        }
    }

    public void b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b;
        int i4 = this.c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.a, i4, i2);
            this.c += i2;
            return;
        }
        throw new a(this.c, this.b);
    }

    public void a(boolean z) throws IOException {
        g(z ? 1 : 0);
    }

    public void a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        i(bytes.length);
        c(bytes);
    }

    public void a(e eVar) throws IOException {
        i(eVar.a());
        eVar.a(this);
    }

    public void a(byte[] bArr) throws IOException {
        i(bArr.length);
        c(bArr);
    }

    public int a() {
        return this.b - this.c;
    }

    public void a(byte b2) throws IOException {
        int i = this.c;
        if (i != this.b) {
            byte[] bArr = this.a;
            this.c = i + 1;
            bArr[i] = b2;
            return;
        }
        throw new a(this.c, this.b);
    }
}
