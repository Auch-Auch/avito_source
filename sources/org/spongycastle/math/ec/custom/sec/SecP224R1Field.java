package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;
public class SecP224R1Field {
    public static final int[] a = {1, 0, 0, -1, -1, -1, -1};
    public static final int[] b = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
    public static final int[] c = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & BodyPartID.bodyIdMax);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = (BodyPartID.bodyIdMax & ((long) iArr[3])) + 1 + j2;
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            Nat.incAt(7, iArr, 4);
        }
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.add(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && Nat224.gte(iArr3, a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && Nat.gte(14, iArr3, b))) {
            int[] iArr4 = c;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && Nat224.gte(iArr2, a))) {
            a(iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat224.fromBigInteger(bigInteger);
        if (fromBigInteger[6] == -1) {
            int[] iArr = a;
            if (Nat224.gte(fromBigInteger, iArr)) {
                Nat224.subFrom(iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(7, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(7, iArr2, Nat224.add(iArr, a, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat224.createExt();
        Nat224.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.mulAddTo(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && Nat.gte(14, iArr3, b))) {
            int[] iArr4 = c;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat224.isZero(iArr)) {
            Nat224.zero(iArr2);
        } else {
            Nat224.sub(a, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[10]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr[11]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr[12]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr[13]) & BodyPartID.bodyIdMax;
        long j5 = ((((long) iArr[7]) & BodyPartID.bodyIdMax) + j2) - 1;
        long j6 = (((long) iArr[8]) & BodyPartID.bodyIdMax) + j3;
        long j7 = (((long) iArr[9]) & BodyPartID.bodyIdMax) + j4;
        long j8 = ((((long) iArr[0]) & BodyPartID.bodyIdMax) - j5) + 0;
        long j9 = j8 & BodyPartID.bodyIdMax;
        long j10 = ((((long) iArr[1]) & BodyPartID.bodyIdMax) - j6) + (j8 >> 32);
        iArr2[1] = (int) j10;
        long j11 = ((((long) iArr[2]) & BodyPartID.bodyIdMax) - j7) + (j10 >> 32);
        iArr2[2] = (int) j11;
        long j12 = (((((long) iArr[3]) & BodyPartID.bodyIdMax) + j5) - j) + (j11 >> 32);
        long j13 = j12 & BodyPartID.bodyIdMax;
        long j14 = (((((long) iArr[4]) & BodyPartID.bodyIdMax) + j6) - j2) + (j12 >> 32);
        iArr2[4] = (int) j14;
        long j15 = (((((long) iArr[5]) & BodyPartID.bodyIdMax) + j7) - j3) + (j14 >> 32);
        iArr2[5] = (int) j15;
        long j16 = (((((long) iArr[6]) & BodyPartID.bodyIdMax) + j) - j4) + (j15 >> 32);
        iArr2[6] = (int) j16;
        long j17 = (j16 >> 32) + 1;
        long j18 = j13 + j17;
        long j19 = j9 - j17;
        iArr2[0] = (int) j19;
        long j20 = j19 >> 32;
        if (j20 != 0) {
            long j21 = j20 + (((long) iArr2[1]) & BodyPartID.bodyIdMax);
            iArr2[1] = (int) j21;
            long j22 = (j21 >> 32) + (BodyPartID.bodyIdMax & ((long) iArr2[2]));
            iArr2[2] = (int) j22;
            j18 += j22 >> 32;
        }
        iArr2[3] = (int) j18;
        if (((j18 >> 32) != 0 && Nat.incAt(7, iArr2, 4) != 0) || (iArr2[6] == -1 && Nat224.gte(iArr2, a))) {
            a(iArr2);
        }
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & BodyPartID.bodyIdMax;
            long j3 = ((((long) iArr[0]) & BodyPartID.bodyIdMax) - j2) + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & BodyPartID.bodyIdMax);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = (BodyPartID.bodyIdMax & ((long) iArr[3])) + j2 + j4;
            iArr[3] = (int) j7;
            j = j7 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.incAt(7, iArr, 4) != 0) || (iArr[6] == -1 && Nat224.gte(iArr, a))) {
            a(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] createExt = Nat224.createExt();
        Nat224.square(iArr, createExt);
        reduce(createExt, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] createExt = Nat224.createExt();
        Nat224.square(iArr, createExt);
        reduce(createExt, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat224.square(iArr2, createExt);
                reduce(createExt, iArr2);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.sub(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & BodyPartID.bodyIdMax) + 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & BodyPartID.bodyIdMax);
                iArr3[1] = (int) j3;
                long j4 = (j3 >> 32) + (((long) iArr3[2]) & BodyPartID.bodyIdMax);
                iArr3[2] = (int) j4;
                j2 = j4 >> 32;
            }
            long j5 = ((BodyPartID.bodyIdMax & ((long) iArr3[3])) - 1) + j2;
            iArr3[3] = (int) j5;
            if ((j5 >> 32) != 0) {
                Nat.decAt(7, iArr3, 4);
            }
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = c;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(14, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && Nat224.gte(iArr2, a))) {
            a(iArr2);
        }
    }
}
