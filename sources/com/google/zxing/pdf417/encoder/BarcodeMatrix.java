package com.google.zxing.pdf417.encoder;

import a2.j.k.h.b.a;
import java.lang.reflect.Array;
public final class BarcodeMatrix {
    public final a[] a;
    public int b;
    public final int c;
    public final int d;

    public BarcodeMatrix(int i, int i2) {
        a[] aVarArr = new a[i];
        this.a = aVarArr;
        int length = aVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.a[i3] = new a(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    public a a() {
        return this.a[this.b];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = this.d * i;
        iArr[0] = this.c * i2;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        int i3 = this.c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i3 - i4) - 1;
            a aVar = this.a[i4 / i2];
            int length = aVar.a.length * i;
            byte[] bArr2 = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                bArr2[i6] = aVar.a[i6 / i];
            }
            bArr[i5] = bArr2;
        }
        return bArr;
    }
}
