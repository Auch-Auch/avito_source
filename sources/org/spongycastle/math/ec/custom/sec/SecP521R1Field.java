package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat512;
public class SecP521R1Field {
    public static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        int add = Nat.add(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (add > 511 || (add == 511 && Nat.eq(16, iArr3, a))) {
            add = (Nat.inc(16, iArr3) + add) & 511;
        }
        iArr3[16] = add;
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        int inc = Nat.inc(16, iArr, iArr2) + iArr[16];
        if (inc > 511 || (inc == 511 && Nat.eq(16, iArr2, a))) {
            inc = (Nat.inc(16, iArr2) + inc) & 511;
        }
        iArr2[16] = inc;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(521, bigInteger);
        if (Nat.eq(17, fromBigInteger, a)) {
            Nat.zero(17, fromBigInteger);
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (Nat.shiftDownBit(16, iArr, i, iArr2) >>> 23) | (i >>> 1);
    }

    public static void implMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat512.mul(iArr, iArr2, iArr3);
        int i = iArr[16];
        int i2 = iArr2[16];
        iArr3[32] = (i * i2) + Nat.mul31BothAdd(16, i, iArr2, i2, iArr, iArr3, 16);
    }

    public static void implSquare(int[] iArr, int[] iArr2) {
        Nat512.square(iArr, iArr2);
        int i = iArr[16];
        iArr2[32] = (i * i) + Nat.mulWordAddTo(16, i << 1, iArr, 0, iArr2, 16);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(33);
        implMultiply(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat.isZero(17, iArr)) {
            Nat.zero(17, iArr2);
        } else {
            Nat.sub(17, a, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int addTo = Nat.addTo(16, iArr, iArr2) + (Nat.shiftDownBits(16, iArr, 16, 9, i, iArr2, 0) >>> 23) + (i >>> 9);
        if (addTo > 511 || (addTo == 511 && Nat.eq(16, iArr2, a))) {
            addTo = (Nat.inc(16, iArr2) + addTo) & 511;
        }
        iArr2[16] = addTo;
    }

    public static void reduce23(int[] iArr) {
        int i = iArr[16];
        int addWordTo = Nat.addWordTo(16, i >>> 9, iArr) + (i & 511);
        if (addWordTo > 511 || (addWordTo == 511 && Nat.eq(16, iArr, a))) {
            addWordTo = (Nat.inc(16, iArr) + addWordTo) & 511;
        }
        iArr[16] = addWordTo;
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(33);
        implSquare(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] create = Nat.create(33);
        implSquare(iArr, create);
        reduce(create, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                implSquare(iArr2, create);
                reduce(create, iArr2);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        int sub = (Nat.sub(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (sub < 0) {
            sub = (Nat.dec(16, iArr3) + sub) & 511;
        }
        iArr3[16] = sub;
    }

    public static void twice(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (Nat.shiftUpBit(16, iArr, i << 23, iArr2) | (i << 1)) & 511;
    }
}
