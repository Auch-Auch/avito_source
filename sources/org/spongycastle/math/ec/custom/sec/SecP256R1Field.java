package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;
public class SecP256R1Field {
    public static final int[] a = {-1, -1, -1, 0, 0, 0, 1, -1};
    public static final int[] b = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & BodyPartID.bodyIdMax);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = ((((long) iArr[3]) & BodyPartID.bodyIdMax) - 1) + j2;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & BodyPartID.bodyIdMax);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & BodyPartID.bodyIdMax);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = ((((long) iArr[6]) & BodyPartID.bodyIdMax) - 1) + j6;
        iArr[6] = (int) j9;
        iArr[7] = (int) ((BodyPartID.bodyIdMax & ((long) iArr[7])) + 1 + (j9 >> 32));
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.add(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && Nat256.gte(iArr3, a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(16, iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && Nat.gte(16, iArr3, b))) {
            Nat.subFrom(16, b, iArr3);
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && Nat256.gte(iArr2, a))) {
            a(iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat256.fromBigInteger(bigInteger);
        if (fromBigInteger[7] == -1) {
            int[] iArr = a;
            if (Nat256.gte(fromBigInteger, iArr)) {
                Nat256.subFrom(iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(8, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(8, iArr2, Nat256.add(iArr, a, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] createExt = Nat256.createExt();
        Nat256.mul(iArr, iArr2, createExt);
        reduce(createExt, iArr3);
    }

    public static void multiplyAddToExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.mulAddTo(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && Nat.gte(16, iArr3, b))) {
            Nat.subFrom(16, b, iArr3);
        }
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat256.isZero(iArr)) {
            Nat256.zero(iArr2);
        } else {
            Nat256.sub(a, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[8]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr[9]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr[10]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr[11]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr[12]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr[13]) & BodyPartID.bodyIdMax;
        long j7 = ((long) iArr[14]) & BodyPartID.bodyIdMax;
        long j8 = ((long) iArr[15]) & BodyPartID.bodyIdMax;
        long j9 = j - 6;
        long j10 = j9 + j2;
        long j11 = j2 + j3;
        long j12 = (j3 + j4) - j8;
        long j13 = j4 + j5;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j7 + j8;
        long j17 = j15 - j10;
        long j18 = (((((long) iArr[0]) & BodyPartID.bodyIdMax) - j13) - j17) + 0;
        iArr2[0] = (int) j18;
        long j19 = ((((((long) iArr[1]) & BodyPartID.bodyIdMax) + j11) - j14) - j16) + (j18 >> 32);
        iArr2[1] = (int) j19;
        long j20 = (((((long) iArr[2]) & BodyPartID.bodyIdMax) + j12) - j15) + (j19 >> 32);
        iArr2[2] = (int) j20;
        long j21 = ((((((long) iArr[3]) & BodyPartID.bodyIdMax) + (j13 << 1)) + j17) - j16) + (j20 >> 32);
        iArr2[3] = (int) j21;
        long j22 = ((((((long) iArr[4]) & BodyPartID.bodyIdMax) + (j14 << 1)) + j7) - j11) + (j21 >> 32);
        iArr2[4] = (int) j22;
        long j23 = (((((long) iArr[5]) & BodyPartID.bodyIdMax) + (j15 << 1)) - j12) + (j22 >> 32);
        iArr2[5] = (int) j23;
        long j24 = (((long) iArr[6]) & BodyPartID.bodyIdMax) + (j16 << 1) + j17 + (j23 >> 32);
        iArr2[6] = (int) j24;
        long j25 = (((((((long) iArr[7]) & BodyPartID.bodyIdMax) + (j8 << 1)) + j9) - j12) - j14) + (j24 >> 32);
        iArr2[7] = (int) j25;
        reduce32((int) ((j25 >> 32) + 6), iArr2);
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
                long j6 = (j5 >> 32) + (((long) iArr[2]) & BodyPartID.bodyIdMax);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = ((((long) iArr[3]) & BodyPartID.bodyIdMax) - j2) + j4;
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (((long) iArr[4]) & BodyPartID.bodyIdMax);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (((long) iArr[5]) & BodyPartID.bodyIdMax);
                iArr[5] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = ((((long) iArr[6]) & BodyPartID.bodyIdMax) - j2) + j8;
            iArr[6] = (int) j11;
            long j12 = (BodyPartID.bodyIdMax & ((long) iArr[7])) + j2 + (j11 >> 32);
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && Nat256.gte(iArr, a))) {
            a(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] createExt = Nat256.createExt();
        Nat256.square(iArr, createExt);
        reduce(createExt, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] createExt = Nat256.createExt();
        Nat256.square(iArr, createExt);
        reduce(createExt, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat256.square(iArr2, createExt);
                reduce(createExt, iArr2);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.sub(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & BodyPartID.bodyIdMax) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & BodyPartID.bodyIdMax);
                iArr3[1] = (int) j3;
                long j4 = (j3 >> 32) + (((long) iArr3[2]) & BodyPartID.bodyIdMax);
                iArr3[2] = (int) j4;
                j2 = j4 >> 32;
            }
            long j5 = (((long) iArr3[3]) & BodyPartID.bodyIdMax) + 1 + j2;
            iArr3[3] = (int) j5;
            long j6 = j5 >> 32;
            if (j6 != 0) {
                long j7 = j6 + (((long) iArr3[4]) & BodyPartID.bodyIdMax);
                iArr3[4] = (int) j7;
                long j8 = (j7 >> 32) + (((long) iArr3[5]) & BodyPartID.bodyIdMax);
                iArr3[5] = (int) j8;
                j6 = j8 >> 32;
            }
            long j9 = (((long) iArr3[6]) & BodyPartID.bodyIdMax) + 1 + j6;
            iArr3[6] = (int) j9;
            iArr3[7] = (int) (((BodyPartID.bodyIdMax & ((long) iArr3[7])) - 1) + (j9 >> 32));
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(16, iArr, iArr2, iArr3) != 0) {
            Nat.addTo(16, b, iArr3);
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && Nat256.gte(iArr2, a))) {
            a(iArr2);
        }
    }
}
