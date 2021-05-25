package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
public final class IntUtils {
    public static int[] clone(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z &= iArr[length] == iArr2[length];
        }
        return z;
    }

    public static void fill(int[] iArr, int i) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = i;
        }
    }

    public static void quicksort(int[] iArr) {
        quicksort(iArr, 0, iArr.length - 1);
    }

    public static int[] subArray(int[] iArr, int i, int i2) {
        int i3 = i2 - i;
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, i, iArr2, 0, i3);
        return iArr2;
    }

    public static String toHexString(int[] iArr) {
        return ByteUtils.toHexString(BigEndianConversions.toByteArray(iArr));
    }

    public static String toString(int[] iArr) {
        String str = "";
        for (int i : iArr) {
            str = a.j(a.L(str), i, " ");
        }
        return str;
    }

    public static void quicksort(int[] iArr, int i, int i2) {
        if (i2 > i) {
            int i3 = iArr[i2];
            iArr[i2] = iArr[i2];
            iArr[i2] = i3;
            int i4 = i;
            int i5 = i4;
            while (i4 < i2) {
                if (iArr[i4] <= i3) {
                    int i6 = iArr[i5];
                    iArr[i5] = iArr[i4];
                    iArr[i4] = i6;
                    i5++;
                }
                i4++;
            }
            int i7 = iArr[i5];
            iArr[i5] = iArr[i2];
            iArr[i2] = i7;
            quicksort(iArr, i, i5 - 1);
            quicksort(iArr, i5 + 1, i2);
        }
    }
}
