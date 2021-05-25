package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;
public class SecP384R1Field {
    public static final int[] a = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] b = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] c = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + 1;
        iArr[0] = (int) j;
        long j2 = ((((long) iArr[1]) & BodyPartID.bodyIdMax) - 1) + (j >> 32);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & BodyPartID.bodyIdMax);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = (((long) iArr[3]) & BodyPartID.bodyIdMax) + 1 + j3;
        iArr[3] = (int) j5;
        long j6 = (BodyPartID.bodyIdMax & ((long) iArr[4])) + 1 + (j5 >> 32);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.incAt(12, iArr, 5);
        }
    }

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && Nat.gte(12, iArr3, a))) {
            a(iArr3);
        }
    }

    public static void addExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.add(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && Nat.gte(24, iArr3, b))) {
            int[] iArr4 = c;
            if (Nat.addTo(iArr4.length, iArr4, iArr3) != 0) {
                Nat.incAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        if (Nat.inc(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, a))) {
            a(iArr2);
        }
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(384, bigInteger);
        if (fromBigInteger[11] == -1) {
            int[] iArr = a;
            if (Nat.gte(12, fromBigInteger, iArr)) {
                Nat.subFrom(12, iArr, fromBigInteger);
            }
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            Nat.shiftDownBit(12, iArr, 0, iArr2);
        } else {
            Nat.shiftDownBit(12, iArr2, Nat.add(12, iArr, a, iArr2));
        }
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(24);
        Nat384.mul(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat.isZero(12, iArr)) {
            Nat.zero(12, iArr2);
        } else {
            Nat.sub(12, a, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[16]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr[17]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr[18]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr[19]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr[20]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr[21]) & BodyPartID.bodyIdMax;
        long j7 = ((long) iArr[22]) & BodyPartID.bodyIdMax;
        long j8 = ((long) iArr[23]) & BodyPartID.bodyIdMax;
        long j9 = ((((long) iArr[12]) & BodyPartID.bodyIdMax) + j5) - 1;
        long j10 = (((long) iArr[13]) & BodyPartID.bodyIdMax) + j7;
        long j11 = (((long) iArr[14]) & BodyPartID.bodyIdMax) + j7 + j8;
        long j12 = (((long) iArr[15]) & BodyPartID.bodyIdMax) + j8;
        long j13 = j2 + j6;
        long j14 = j6 - j8;
        long j15 = j7 - j8;
        long j16 = j9 + j14;
        long j17 = (((long) iArr[0]) & BodyPartID.bodyIdMax) + j16 + 0;
        iArr2[0] = (int) j17;
        long j18 = (((((long) iArr[1]) & BodyPartID.bodyIdMax) + j8) - j9) + j10 + (j17 >> 32);
        iArr2[1] = (int) j18;
        long j19 = (((((long) iArr[2]) & BodyPartID.bodyIdMax) - j6) - j10) + j11 + (j18 >> 32);
        iArr2[2] = (int) j19;
        long j20 = ((((long) iArr[3]) & BodyPartID.bodyIdMax) - j11) + j12 + j16 + (j19 >> 32);
        iArr2[3] = (int) j20;
        long j21 = (((((((long) iArr[4]) & BodyPartID.bodyIdMax) + j) + j6) + j10) - j12) + j16 + (j20 >> 32);
        iArr2[4] = (int) j21;
        long j22 = ((((long) iArr[5]) & BodyPartID.bodyIdMax) - j) + j10 + j11 + j13 + (j21 >> 32);
        iArr2[5] = (int) j22;
        long j23 = (((((long) iArr[6]) & BodyPartID.bodyIdMax) + j3) - j2) + j11 + j12 + (j22 >> 32);
        iArr2[6] = (int) j23;
        long j24 = ((((((long) iArr[7]) & BodyPartID.bodyIdMax) + j) + j4) - j3) + j12 + (j23 >> 32);
        iArr2[7] = (int) j24;
        long j25 = (((((((long) iArr[8]) & BodyPartID.bodyIdMax) + j) + j2) + j5) - j4) + (j24 >> 32);
        iArr2[8] = (int) j25;
        long j26 = (((((long) iArr[9]) & BodyPartID.bodyIdMax) + j3) - j5) + j13 + (j25 >> 32);
        iArr2[9] = (int) j26;
        long j27 = ((((((long) iArr[10]) & BodyPartID.bodyIdMax) + j3) + j4) - j14) + j15 + (j26 >> 32);
        iArr2[10] = (int) j27;
        long j28 = ((((((long) iArr[11]) & BodyPartID.bodyIdMax) + j4) + j5) - j15) + (j27 >> 32);
        iArr2[11] = (int) j28;
        reduce32((int) ((j28 >> 32) + 1), iArr2);
    }

    public static void reduce32(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & BodyPartID.bodyIdMax;
            long j3 = (((long) iArr[0]) & BodyPartID.bodyIdMax) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = ((((long) iArr[1]) & BodyPartID.bodyIdMax) - j2) + (j3 >> 32);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (((long) iArr[2]) & BodyPartID.bodyIdMax);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = (((long) iArr[3]) & BodyPartID.bodyIdMax) + j2 + j5;
            iArr[3] = (int) j7;
            long j8 = (BodyPartID.bodyIdMax & ((long) iArr[4])) + j2 + (j7 >> 32);
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.incAt(12, iArr, 5) != 0) || (iArr[11] == -1 && Nat.gte(12, iArr, a))) {
            a(iArr);
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] create = Nat.create(24);
        Nat384.square(iArr, create);
        reduce(create, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat384.square(iArr2, create);
                reduce(create, iArr2);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(12, iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & BodyPartID.bodyIdMax) - 1;
            iArr3[0] = (int) j;
            long j2 = (((long) iArr3[1]) & BodyPartID.bodyIdMax) + 1 + (j >> 32);
            iArr3[1] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (((long) iArr3[2]) & BodyPartID.bodyIdMax);
                iArr3[2] = (int) j4;
                j3 = j4 >> 32;
            }
            long j5 = ((((long) iArr3[3]) & BodyPartID.bodyIdMax) - 1) + j3;
            iArr3[3] = (int) j5;
            long j6 = ((BodyPartID.bodyIdMax & ((long) iArr3[4])) - 1) + (j5 >> 32);
            iArr3[4] = (int) j6;
            if ((j6 >> 32) != 0) {
                Nat.decAt(12, iArr3, 5);
            }
        }
    }

    public static void subtractExt(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.sub(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = c;
            if (Nat.subFrom(iArr4.length, iArr4, iArr3) != 0) {
                Nat.decAt(24, iArr3, iArr4.length);
            }
        }
    }

    public static void twice(int[] iArr, int[] iArr2) {
        if (Nat.shiftUpBit(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && Nat.gte(12, iArr2, a))) {
            a(iArr2);
        }
    }
}
