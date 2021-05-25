package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;
public class SecP192R1Field {
    public static final int[] a = {-1, -1, -2, -1, -1, -1};
    public static final int[] b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
    public static final int[] c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & BodyPartID.bodyIdMax);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = (BodyPartID.bodyIdMax & ((long) iArr[2])) + 1 + j2;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            Nat.incAt(6, iArr, 3);
        }
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.add(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && Nat192.gte(iArr3, a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, b))) {
            int[] iArr4 = c;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && Nat192.gte(iArr2, a))) {
            a(iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat192.fromBigInteger(bigInteger);
        if (fromBigInteger[5] == -1) {
            int[] iArr = a;
            if (Nat192.gte(fromBigInteger, iArr)) {
                Nat192.subFrom(iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(6, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(6, iArr2, Nat192.add(iArr, a, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat192.createExt();
        Nat192.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, b))) {
            int[] iArr4 = c;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat192.isZero(iArr)) {
            Nat192.zero(iArr2);
        } else {
            Nat192.sub(a, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[6]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr[7]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr[8]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr[9]) & BodyPartID.bodyIdMax;
        long j5 = (((long) iArr[10]) & BodyPartID.bodyIdMax) + j;
        long j6 = (((long) iArr[11]) & BodyPartID.bodyIdMax) + j2;
        long j7 = (((long) iArr[0]) & BodyPartID.bodyIdMax) + j5 + 0;
        int i = (int) j7;
        long j8 = (((long) iArr[1]) & BodyPartID.bodyIdMax) + j6 + (j7 >> 32);
        iArr2[1] = (int) j8;
        long j9 = j5 + j3;
        long j10 = j6 + j4;
        long j11 = (((long) iArr[2]) & BodyPartID.bodyIdMax) + j9 + (j8 >> 32);
        long j12 = j11 & BodyPartID.bodyIdMax;
        long j13 = (((long) iArr[3]) & BodyPartID.bodyIdMax) + j10 + (j11 >> 32);
        iArr2[3] = (int) j13;
        long j14 = j10 - j2;
        long j15 = (((long) iArr[4]) & BodyPartID.bodyIdMax) + (j9 - j) + (j13 >> 32);
        iArr2[4] = (int) j15;
        long j16 = (((long) iArr[5]) & BodyPartID.bodyIdMax) + j14 + (j15 >> 32);
        iArr2[5] = (int) j16;
        long j17 = j16 >> 32;
        long j18 = j12 + j17;
        long j19 = j17 + (((long) i) & BodyPartID.bodyIdMax);
        iArr2[0] = (int) j19;
        long j20 = j19 >> 32;
        if (j20 != 0) {
            long j21 = j20 + (BodyPartID.bodyIdMax & ((long) iArr2[1]));
            iArr2[1] = (int) j21;
            j18 += j21 >> 32;
        }
        iArr2[2] = (int) j18;
        if (((j18 >> 32) != 0 && Nat.incAt(6, iArr2, 3) != 0) || (iArr2[5] == -1 && Nat192.gte(iArr2, a))) {
            a(iArr2);
        }
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & BodyPartID.bodyIdMax;
            long j3 = (((long) iArr[0]) & BodyPartID.bodyIdMax) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & BodyPartID.bodyIdMax);
                iArr[1] = (int) j5;
                j4 = j5 >> 32;
            }
            long j6 = (BodyPartID.bodyIdMax & ((long) iArr[2])) + j2 + j4;
            iArr[2] = (int) j6;
            j = j6 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.incAt(6, iArr, 3) != 0) || (iArr[5] == -1 && Nat192.gte(iArr, a))) {
            a(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] createExt = Nat192.createExt();
        Nat192.square(iArr, createExt);
        reduce(createExt, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] createExt = Nat192.createExt();
        Nat192.square(iArr, createExt);
        reduce(createExt, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat192.square(iArr2, createExt);
                reduce(createExt, iArr2);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.sub(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & BodyPartID.bodyIdMax) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & BodyPartID.bodyIdMax);
                iArr3[1] = (int) j3;
                j2 = j3 >> 32;
            }
            long j4 = ((BodyPartID.bodyIdMax & ((long) iArr3[2])) - 1) + j2;
            iArr3[2] = (int) j4;
            if ((j4 >> 32) != 0) {
                Nat.decAt(6, iArr3, 3);
            }
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(12, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = c;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(12, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && Nat192.gte(iArr2, a))) {
            a(iArr2);
        }
    }
}
