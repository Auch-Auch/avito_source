package com.google.zxing.common.reedsolomon;

import a2.j.k.c.a.a;
public final class GenericGF {
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM = new GenericGF(19, 16, 1);
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
    public final int[] a;
    public final int[] b;
    public final a c;
    public final a d;
    public final int e;
    public final int f;
    public final int g;

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        GenericGF genericGF2 = new GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int i, int i2, int i3) {
        this.f = i;
        this.e = i2;
        this.g = i3;
        this.a = new int[i2];
        this.b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.a[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.b[this.a[i6]] = i6;
        }
        this.c = new a(this, new int[]{0});
        this.d = new a(this, new int[]{1});
    }

    public a a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.c;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new a(this, iArr);
        }
    }

    public int b(int i) {
        if (i != 0) {
            return this.a[(this.e - this.b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.e - 1)];
    }

    public int getGeneratorBase() {
        return this.g;
    }

    public int getSize() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f));
        sb.append(',');
        return a2.b.a.a.a.i(sb, this.e, ')');
    }
}
