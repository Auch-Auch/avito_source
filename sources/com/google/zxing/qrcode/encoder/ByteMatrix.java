package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;
public final class ByteMatrix {
    public final byte[][] a;
    public final int b;
    public final int c;

    public ByteMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.a = (byte[][]) Array.newInstance(byte.class, iArr);
        this.b = i;
        this.c = i2;
    }

    public void clear(byte b2) {
        for (byte[] bArr : this.a) {
            Arrays.fill(bArr, b2);
        }
    }

    public byte get(int i, int i2) {
        return this.a[i2][i];
    }

    public byte[][] getArray() {
        return this.a;
    }

    public int getHeight() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public void set(int i, int i2, byte b2) {
        this.a[i2][i] = b2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            byte[] bArr = this.a[i];
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b2 = bArr[i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i, int i2, int i3) {
        this.a[i2][i] = (byte) i3;
    }

    public void set(int i, int i2, boolean z) {
        this.a[i2][i] = z ? (byte) 1 : 0;
    }
}
