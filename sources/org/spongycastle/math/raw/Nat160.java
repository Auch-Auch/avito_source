package org.spongycastle.math.raw;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.util.Pack;
public abstract class Nat160 {
    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & BodyPartID.bodyIdMax) + (((long) iArr2[4]) & BodyPartID.bodyIdMax) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax) + (((long) iArr3[0]) & BodyPartID.bodyIdMax) + 0;
        iArr3[0] = (int) j;
        long j2 = (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax) + (((long) iArr3[1]) & BodyPartID.bodyIdMax) + (j >>> 32);
        iArr3[1] = (int) j2;
        long j3 = (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax) + (((long) iArr3[2]) & BodyPartID.bodyIdMax) + (j2 >>> 32);
        iArr3[2] = (int) j3;
        long j4 = (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax) + (((long) iArr3[3]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr3[3] = (int) j4;
        long j5 = (((long) iArr[4]) & BodyPartID.bodyIdMax) + (((long) iArr2[4]) & BodyPartID.bodyIdMax) + (((long) iArr3[4]) & BodyPartID.bodyIdMax) + (j4 >>> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & BodyPartID.bodyIdMax) + (((long) iArr2[0]) & BodyPartID.bodyIdMax) + 0;
        iArr2[0] = (int) j;
        long j2 = (((long) iArr[1]) & BodyPartID.bodyIdMax) + (((long) iArr2[1]) & BodyPartID.bodyIdMax) + (j >>> 32);
        iArr2[1] = (int) j2;
        long j3 = (((long) iArr[2]) & BodyPartID.bodyIdMax) + (((long) iArr2[2]) & BodyPartID.bodyIdMax) + (j2 >>> 32);
        iArr2[2] = (int) j3;
        long j4 = (((long) iArr[3]) & BodyPartID.bodyIdMax) + (((long) iArr2[3]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr2[3] = (int) j4;
        long j5 = (((long) iArr[4]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[4])) + (j4 >>> 32);
        iArr2[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & BodyPartID.bodyIdMax) + (((long) iArr2[i4]) & BodyPartID.bodyIdMax) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (((long) iArr[i6]) & BodyPartID.bodyIdMax) + (((long) iArr2[i7]) & BodyPartID.bodyIdMax) + (j >>> 32);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (((long) iArr[i9]) & BodyPartID.bodyIdMax) + (((long) iArr2[i10]) & BodyPartID.bodyIdMax) + (j2 >>> 32);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (((long) iArr[i12]) & BodyPartID.bodyIdMax) + (((long) iArr2[i13]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (((long) iArr[i15]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[i16])) + (j4 >>> 32);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        return (int) (j5 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean gte = gte(iArr, i, iArr2, i2);
        if (gte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        int i = 0;
        while (bigInteger.signum() != 0) {
            create[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return create;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 5) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        int i = 1;
        long j2 = ((long) iArr2[1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[4]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr[0]) & BodyPartID.bodyIdMax;
        long j7 = (j6 * j) + 0;
        iArr3[0] = (int) j7;
        long j8 = (j6 * j2) + (j7 >>> 32);
        iArr3[1] = (int) j8;
        long j9 = (j6 * j3) + (j8 >>> 32);
        iArr3[2] = (int) j9;
        long j10 = (j6 * j4) + (j9 >>> 32);
        iArr3[3] = (int) j10;
        long j11 = (j6 * j5) + (j10 >>> 32);
        iArr3[4] = (int) j11;
        iArr3[5] = (int) (j11 >>> 32);
        for (int i2 = 5; i < i2; i2 = 5) {
            long j12 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
            int i3 = i + 0;
            long j13 = (j12 * j) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax) + 0;
            iArr3[i3] = (int) j13;
            int i4 = i + 1;
            long j14 = (j12 * j2) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax) + (j13 >>> 32);
            iArr3[i4] = (int) j14;
            int i5 = i + 2;
            long j15 = (j12 * j3) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax) + (j14 >>> 32);
            iArr3[i5] = (int) j15;
            int i6 = i + 3;
            long j16 = (j12 * j4) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax) + (j15 >>> 32);
            iArr3[i6] = (int) j16;
            long j17 = j16 >>> 32;
            int i7 = i + 4;
            long j18 = (j12 * j5) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax) + j17;
            iArr3[i7] = (int) j18;
            iArr3[i + 5] = (int) (j18 >>> 32);
            i = i4;
            j = j;
            j2 = j2;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr[i2 + 0]) & BodyPartID.bodyIdMax;
        long j3 = (j * j2) + (((long) iArr2[i3 + 0]) & BodyPartID.bodyIdMax) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & BodyPartID.bodyIdMax;
        long j5 = (j * j4) + j2 + (((long) iArr2[i3 + 1]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr3[i4 + 1] = (int) j5;
        long j6 = ((long) iArr[i2 + 2]) & BodyPartID.bodyIdMax;
        long j7 = (j * j6) + j4 + (((long) iArr2[i3 + 2]) & BodyPartID.bodyIdMax) + (j5 >>> 32);
        iArr3[i4 + 2] = (int) j7;
        long j8 = ((long) iArr[i2 + 3]) & BodyPartID.bodyIdMax;
        long j9 = (j * j8) + j6 + (((long) iArr2[i3 + 3]) & BodyPartID.bodyIdMax) + (j7 >>> 32);
        iArr3[i4 + 3] = (int) j9;
        long j10 = ((long) iArr[i2 + 4]) & BodyPartID.bodyIdMax;
        long j11 = (j * j10) + j8 + (BodyPartID.bodyIdMax & ((long) iArr2[i3 + 4])) + (j9 >>> 32);
        iArr3[i4 + 4] = (int) j11;
        return (j11 >>> 32) + j10;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & BodyPartID.bodyIdMax;
        long j3 = j & BodyPartID.bodyIdMax;
        int i3 = i2 + 0;
        long j4 = (j2 * j3) + (((long) iArr[i3]) & BodyPartID.bodyIdMax) + 0;
        iArr[i3] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i4 = i2 + 1;
        long j7 = j6 + (((long) iArr[i4]) & BodyPartID.bodyIdMax) + (j4 >>> 32);
        iArr[i4] = (int) j7;
        int i5 = i2 + 2;
        long j8 = j5 + (((long) iArr[i5]) & BodyPartID.bodyIdMax) + (j7 >>> 32);
        iArr[i5] = (int) j8;
        int i6 = i2 + 3;
        long j9 = (j8 >>> 32) + (BodyPartID.bodyIdMax & ((long) iArr[i6]));
        iArr[i6] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i2, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = ((long) i2) & BodyPartID.bodyIdMax;
        int i4 = i3 + 0;
        long j3 = (j * j2) + (((long) iArr[i4]) & BodyPartID.bodyIdMax) + 0;
        iArr[i4] = (int) j3;
        int i5 = i3 + 1;
        long j4 = j2 + (((long) iArr[i5]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr[i5] = (int) j4;
        int i6 = i3 + 2;
        long j5 = (j4 >>> 32) + (((long) iArr[i6]) & BodyPartID.bodyIdMax);
        iArr[i6] = (int) j5;
        if ((j5 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[1]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[4]) & BodyPartID.bodyIdMax;
        long j7 = 0;
        while (i < 5) {
            long j8 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j9 = (j8 * j2) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j9;
            int i3 = i + 1;
            long j10 = (j8 * j3) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax) + (j9 >>> 32);
            iArr3[i3] = (int) j10;
            int i4 = i + 2;
            long j11 = (j8 * j4) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax) + (j10 >>> 32);
            iArr3[i4] = (int) j11;
            int i5 = i + 3;
            long j12 = (j8 * j5) + (((long) iArr3[i5]) & BodyPartID.bodyIdMax) + (j11 >>> 32);
            iArr3[i5] = (int) j12;
            long j13 = j12 >>> 32;
            int i6 = i + 4;
            long j14 = (j8 * j6) + (((long) iArr3[i6]) & BodyPartID.bodyIdMax) + j13;
            iArr3[i6] = (int) j14;
            int i7 = i + 5;
            long j15 = (j14 >>> 32) + j7 + (((long) iArr3[i7]) & BodyPartID.bodyIdMax);
            iArr3[i7] = (int) j15;
            j7 = j15 >>> 32;
            j = 4294967295L;
            j2 = j2;
            i = i3;
            j3 = j3;
            j4 = j4;
        }
        return (int) j7;
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = ((((long) iArr[i3]) & BodyPartID.bodyIdMax) * j) + j2;
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 5);
        return (int) j2;
    }

    public static int mulWordAddExt(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & BodyPartID.bodyIdMax;
        int i4 = i3 + 0;
        long j2 = ((((long) iArr[i2 + 0]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i4]) & BodyPartID.bodyIdMax) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = ((((long) iArr[i2 + 1]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i5]) & BodyPartID.bodyIdMax) + (j2 >>> 32);
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = ((((long) iArr[i2 + 2]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i6]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = ((((long) iArr[i2 + 3]) & BodyPartID.bodyIdMax) * j) + (((long) iArr2[i7]) & BodyPartID.bodyIdMax) + (j4 >>> 32);
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = (j * (((long) iArr[i2 + 4]) & BodyPartID.bodyIdMax)) + (((long) iArr2[i8]) & BodyPartID.bodyIdMax) + (j5 >>> 32);
        iArr2[i8] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & BodyPartID.bodyIdMax;
        int i3 = i2 + 0;
        long j3 = ((j & BodyPartID.bodyIdMax) * j2) + (((long) iArr[i3]) & BodyPartID.bodyIdMax) + 0;
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i4 = i2 + 1;
        long j5 = j4 + (((long) iArr[i4]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr[i4] = (int) j5;
        long j6 = j5 >>> 32;
        int i5 = i2 + 2;
        long j7 = j6 + (((long) iArr[i5]) & BodyPartID.bodyIdMax);
        iArr[i5] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i2, 3);
    }

    public static int mulWordsAdd(int i, int i2, int[] iArr, int i3) {
        long j = (((long) i2) & BodyPartID.bodyIdMax) * (((long) i) & BodyPartID.bodyIdMax);
        int i4 = i3 + 0;
        long j2 = j + (((long) iArr[i4]) & BodyPartID.bodyIdMax) + 0;
        iArr[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >>> 32) + (BodyPartID.bodyIdMax & ((long) iArr[i5]));
        iArr[i5] = (int) j3;
        if ((j3 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i3, 2);
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & BodyPartID.bodyIdMax;
        int i = 10;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & BodyPartID.bodyIdMax;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & BodyPartID.bodyIdMax) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & BodyPartID.bodyIdMax;
                long j7 = ((long) iArr2[2]) & BodyPartID.bodyIdMax;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & BodyPartID.bodyIdMax;
                long j11 = ((long) iArr2[3]) & BodyPartID.bodyIdMax;
                long j12 = ((long) iArr2[4]) & BodyPartID.bodyIdMax;
                long j13 = j9 + (j10 * j);
                int i8 = (int) j13;
                iArr2[2] = (i7 >>> 31) | (i8 << 1);
                long M0 = a.M0(j10, j6, j13 >>> 32, j11);
                long j14 = j12 + (M0 >>> 32);
                long j15 = M0 & BodyPartID.bodyIdMax;
                long j16 = ((long) iArr[3]) & BodyPartID.bodyIdMax;
                long j17 = (((long) iArr2[5]) & BodyPartID.bodyIdMax) + (j14 >>> 32);
                long j18 = j14 & BodyPartID.bodyIdMax;
                long j19 = j17 & BodyPartID.bodyIdMax;
                long j20 = (j16 * j) + j15;
                int i9 = (int) j20;
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
                long M02 = a.M0(j16, j6, j20 >>> 32, j18);
                long M03 = a.M0(j16, j10, M02 >>> 32, j19);
                long j21 = M02 & BodyPartID.bodyIdMax;
                long j22 = (((long) iArr2[6]) & BodyPartID.bodyIdMax) + (j17 >>> 32) + (M03 >>> 32);
                long j23 = M03 & BodyPartID.bodyIdMax;
                long j24 = ((long) iArr[4]) & BodyPartID.bodyIdMax;
                long j25 = (((long) iArr2[7]) & BodyPartID.bodyIdMax) + (j22 >>> 32);
                long j26 = j22 & BodyPartID.bodyIdMax;
                long j27 = BodyPartID.bodyIdMax & j25;
                long j28 = (j24 * j) + j21;
                int i10 = (int) j28;
                iArr2[4] = (i9 >>> 31) | (i10 << 1);
                int i11 = i10 >>> 31;
                long M04 = a.M0(j6, j24, j28 >>> 32, j23);
                long M05 = a.M0(j24, j10, M04 >>> 32, j26);
                long M06 = a.M0(j24, j16, M05 >>> 32, j27);
                long j29 = (((long) iArr2[8]) & BodyPartID.bodyIdMax) + (j25 >>> 32) + (M06 >>> 32);
                int i12 = (int) M04;
                iArr2[5] = i11 | (i12 << 1);
                int i13 = (int) M05;
                iArr2[6] = (i12 >>> 31) | (i13 << 1);
                int i14 = i13 >>> 31;
                int i15 = (int) M06;
                iArr2[7] = i14 | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j29;
                iArr2[8] = i16 | (i17 << 1);
                iArr2[9] = (i17 >>> 31) | ((iArr2[9] + ((int) (j29 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & BodyPartID.bodyIdMax) - (((long) iArr2[0]) & BodyPartID.bodyIdMax)) + 0;
        iArr3[0] = (int) j;
        long j2 = ((((long) iArr[1]) & BodyPartID.bodyIdMax) - (((long) iArr2[1]) & BodyPartID.bodyIdMax)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = ((((long) iArr[2]) & BodyPartID.bodyIdMax) - (((long) iArr2[2]) & BodyPartID.bodyIdMax)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = ((((long) iArr[3]) & BodyPartID.bodyIdMax) - (((long) iArr2[3]) & BodyPartID.bodyIdMax)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = ((((long) iArr[4]) & BodyPartID.bodyIdMax) - (((long) iArr2[4]) & BodyPartID.bodyIdMax)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & BodyPartID.bodyIdMax) - (((long) iArr[0]) & BodyPartID.bodyIdMax)) - (((long) iArr2[0]) & BodyPartID.bodyIdMax)) + 0;
        iArr3[0] = (int) j;
        long j2 = (((((long) iArr3[1]) & BodyPartID.bodyIdMax) - (((long) iArr[1]) & BodyPartID.bodyIdMax)) - (((long) iArr2[1]) & BodyPartID.bodyIdMax)) + (j >> 32);
        iArr3[1] = (int) j2;
        long j3 = (((((long) iArr3[2]) & BodyPartID.bodyIdMax) - (((long) iArr[2]) & BodyPartID.bodyIdMax)) - (((long) iArr2[2]) & BodyPartID.bodyIdMax)) + (j2 >> 32);
        iArr3[2] = (int) j3;
        long j4 = (((((long) iArr3[3]) & BodyPartID.bodyIdMax) - (((long) iArr[3]) & BodyPartID.bodyIdMax)) - (((long) iArr2[3]) & BodyPartID.bodyIdMax)) + (j3 >> 32);
        iArr3[3] = (int) j4;
        long j5 = (((((long) iArr3[4]) & BodyPartID.bodyIdMax) - (((long) iArr[4]) & BodyPartID.bodyIdMax)) - (((long) iArr2[4]) & BodyPartID.bodyIdMax)) + (j4 >> 32);
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & BodyPartID.bodyIdMax) - (((long) iArr[0]) & BodyPartID.bodyIdMax)) + 0;
        iArr2[0] = (int) j;
        long j2 = ((((long) iArr2[1]) & BodyPartID.bodyIdMax) - (((long) iArr[1]) & BodyPartID.bodyIdMax)) + (j >> 32);
        iArr2[1] = (int) j2;
        long j3 = ((((long) iArr2[2]) & BodyPartID.bodyIdMax) - (((long) iArr[2]) & BodyPartID.bodyIdMax)) + (j2 >> 32);
        iArr2[2] = (int) j3;
        long j4 = ((((long) iArr2[3]) & BodyPartID.bodyIdMax) - (((long) iArr[3]) & BodyPartID.bodyIdMax)) + (j3 >> 32);
        iArr2[3] = (int) j4;
        long j5 = ((((long) iArr2[4]) & BodyPartID.bodyIdMax) - (BodyPartID.bodyIdMax & ((long) iArr[4]))) + (j4 >> 32);
        iArr2[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 4; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        long j = ((long) i3) & BodyPartID.bodyIdMax;
        int i4 = i2 + 0;
        long j2 = (((long) iArr[i + 0]) & BodyPartID.bodyIdMax) + (((long) iArr2[i4]) & BodyPartID.bodyIdMax) + j;
        iArr2[i4] = (int) j2;
        int i5 = i2 + 1;
        long j3 = (((long) iArr[i + 1]) & BodyPartID.bodyIdMax) + (((long) iArr2[i5]) & BodyPartID.bodyIdMax) + (j2 >>> 32);
        iArr2[i5] = (int) j3;
        int i6 = i2 + 2;
        long j4 = (((long) iArr[i + 2]) & BodyPartID.bodyIdMax) + (((long) iArr2[i6]) & BodyPartID.bodyIdMax) + (j3 >>> 32);
        iArr2[i6] = (int) j4;
        int i7 = i2 + 3;
        long j5 = (((long) iArr[i + 3]) & BodyPartID.bodyIdMax) + (((long) iArr2[i7]) & BodyPartID.bodyIdMax) + (j4 >>> 32);
        iArr2[i7] = (int) j5;
        int i8 = i2 + 4;
        long j6 = (((long) iArr[i + 4]) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) iArr2[i8])) + (j5 >>> 32);
        iArr2[i8] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 0]) & BodyPartID.bodyIdMax)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = ((((long) iArr[i + 1]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax)) + (j >> 32);
        iArr3[i3 + 1] = (int) j2;
        long j3 = ((((long) iArr[i + 2]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax)) + (j2 >> 32);
        iArr3[i3 + 2] = (int) j3;
        long j4 = ((((long) iArr[i + 3]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax)) + (j3 >> 32);
        iArr3[i3 + 3] = (int) j4;
        long j5 = ((((long) iArr[i + 4]) & BodyPartID.bodyIdMax) - (((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax)) + (j4 >> 32);
        iArr3[i3 + 4] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i2 + 0;
        long j = ((((long) iArr2[i3]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 0]) & BodyPartID.bodyIdMax)) + 0;
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        long j2 = ((((long) iArr2[i4]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 1]) & BodyPartID.bodyIdMax)) + (j >> 32);
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = ((((long) iArr2[i5]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 2]) & BodyPartID.bodyIdMax)) + (j2 >> 32);
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = ((((long) iArr2[i6]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 3]) & BodyPartID.bodyIdMax)) + (j3 >> 32);
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = ((((long) iArr2[i7]) & BodyPartID.bodyIdMax) - (((long) iArr[i + 4]) & BodyPartID.bodyIdMax)) + (j4 >> 32);
        iArr2[i7] = (int) j5;
        return (int) (j5 >> 32);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[i2 + 0]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax;
        int i4 = i3;
        int i5 = 0;
        long j7 = 0;
        while (i5 < 5) {
            long j8 = ((long) iArr[i + i5]) & j;
            int i6 = i4 + 0;
            long j9 = (j8 * j2) + (((long) iArr3[i6]) & j) + 0;
            iArr3[i6] = (int) j9;
            int i7 = i4 + 1;
            long j10 = (j8 * j3) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax) + (j9 >>> 32);
            iArr3[i7] = (int) j10;
            int i8 = i4 + 2;
            long j11 = (j8 * j4) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax) + (j10 >>> 32);
            iArr3[i8] = (int) j11;
            int i9 = i4 + 3;
            long j12 = (j8 * j5) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax) + (j11 >>> 32);
            iArr3[i9] = (int) j12;
            long j13 = j12 >>> 32;
            int i10 = i4 + 4;
            long j14 = (j8 * j6) + (((long) iArr3[i10]) & BodyPartID.bodyIdMax) + j13;
            iArr3[i10] = (int) j14;
            int i11 = i4 + 5;
            long j15 = j7 + (((long) iArr3[i11]) & BodyPartID.bodyIdMax) + (j14 >>> 32);
            iArr3[i11] = (int) j15;
            j7 = j15 >>> 32;
            i5++;
            i4 = i7;
            j2 = j2;
            j = 4294967295L;
            j3 = j3;
            j4 = j4;
        }
        return (int) j7;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & BodyPartID.bodyIdMax;
        long j2 = ((long) iArr2[i2 + 1]) & BodyPartID.bodyIdMax;
        long j3 = ((long) iArr2[i2 + 2]) & BodyPartID.bodyIdMax;
        long j4 = ((long) iArr2[i2 + 3]) & BodyPartID.bodyIdMax;
        long j5 = ((long) iArr2[i2 + 4]) & BodyPartID.bodyIdMax;
        long j6 = ((long) iArr[i + 0]) & BodyPartID.bodyIdMax;
        long j7 = (j6 * j) + 0;
        iArr3[i3 + 0] = (int) j7;
        long j8 = (j6 * j2) + (j7 >>> 32);
        iArr3[i3 + 1] = (int) j8;
        long j9 = (j6 * j3) + (j8 >>> 32);
        iArr3[i3 + 2] = (int) j9;
        long j10 = (j6 * j4) + (j9 >>> 32);
        iArr3[i3 + 3] = (int) j10;
        long j11 = (j6 * j5) + (j10 >>> 32);
        iArr3[i3 + 4] = (int) j11;
        iArr3[i3 + 5] = (int) (j11 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 5) {
            i5 += i4;
            long j12 = ((long) iArr[i + i6]) & BodyPartID.bodyIdMax;
            int i7 = i5 + 0;
            long j13 = (j12 * j) + (((long) iArr3[i7]) & BodyPartID.bodyIdMax) + 0;
            iArr3[i7] = (int) j13;
            int i8 = i5 + 1;
            long j14 = (j12 * j2) + (((long) iArr3[i8]) & BodyPartID.bodyIdMax) + (j13 >>> 32);
            iArr3[i8] = (int) j14;
            int i9 = i5 + 2;
            long j15 = (j12 * j3) + (((long) iArr3[i9]) & BodyPartID.bodyIdMax) + (j14 >>> 32);
            iArr3[i9] = (int) j15;
            int i10 = i5 + 3;
            long j16 = (j12 * j4) + (((long) iArr3[i10]) & BodyPartID.bodyIdMax) + (j15 >>> 32);
            iArr3[i10] = (int) j16;
            int i11 = i5 + 4;
            long j17 = (j12 * j5) + (((long) iArr3[i11]) & BodyPartID.bodyIdMax) + (j16 >>> 32);
            iArr3[i11] = (int) j17;
            iArr3[i5 + 5] = (int) (j17 >>> 32);
            i6++;
            j3 = j3;
            j = j;
            i4 = 1;
        }
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & BodyPartID.bodyIdMax;
        int i3 = 0;
        int i4 = 10;
        int i5 = 4;
        while (true) {
            int i6 = i5 - 1;
            long j2 = ((long) iArr[i + i5]) & BodyPartID.bodyIdMax;
            long j3 = j2 * j2;
            int i7 = i4 - 1;
            iArr2[i2 + i7] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 = i7 - 1;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i3 << 31)) & BodyPartID.bodyIdMax) | (j4 >>> 33);
                iArr2[i2 + 0] = (int) j4;
                long j6 = ((long) iArr[i + 1]) & BodyPartID.bodyIdMax;
                int i8 = i2 + 2;
                long j7 = ((long) iArr2[i8]) & BodyPartID.bodyIdMax;
                long j8 = (j6 * j) + j5;
                int i9 = (int) j8;
                iArr2[i2 + 1] = (((int) (j4 >>> 32)) & 1) | (i9 << 1);
                int i10 = i9 >>> 31;
                long j9 = ((long) iArr[i + 2]) & BodyPartID.bodyIdMax;
                int i11 = i2 + 3;
                long j10 = ((long) iArr2[i11]) & BodyPartID.bodyIdMax;
                int i12 = i2 + 4;
                long j11 = ((long) iArr2[i12]) & BodyPartID.bodyIdMax;
                long j12 = (j9 * j) + j7 + (j8 >>> 32);
                int i13 = (int) j12;
                iArr2[i8] = i10 | (i13 << 1);
                int i14 = i13 >>> 31;
                long M0 = a.M0(j9, j6, j12 >>> 32, j10);
                long j13 = j11 + (M0 >>> 32);
                long j14 = M0 & BodyPartID.bodyIdMax;
                long j15 = ((long) iArr[i + 3]) & BodyPartID.bodyIdMax;
                int i15 = i2 + 5;
                long j16 = (((long) iArr2[i15]) & BodyPartID.bodyIdMax) + (j13 >>> 32);
                long j17 = j13 & BodyPartID.bodyIdMax;
                int i16 = i2 + 6;
                long j18 = (((long) iArr2[i16]) & BodyPartID.bodyIdMax) + (j16 >>> 32);
                long j19 = j16 & BodyPartID.bodyIdMax;
                long j20 = (j15 * j) + j14;
                int i17 = (int) j20;
                iArr2[i11] = i14 | (i17 << 1);
                int i18 = i17 >>> 31;
                long M02 = a.M0(j15, j6, j20 >>> 32, j17);
                long M03 = a.M0(j15, j9, M02 >>> 32, j19);
                long j21 = M02 & BodyPartID.bodyIdMax;
                long j22 = j18 + (M03 >>> 32);
                long j23 = M03 & BodyPartID.bodyIdMax;
                long j24 = ((long) iArr[i + 4]) & BodyPartID.bodyIdMax;
                int i19 = i2 + 7;
                long j25 = (((long) iArr2[i19]) & BodyPartID.bodyIdMax) + (j22 >>> 32);
                long j26 = j22 & BodyPartID.bodyIdMax;
                int i20 = i2 + 8;
                long j27 = (((long) iArr2[i20]) & BodyPartID.bodyIdMax) + (j25 >>> 32);
                long j28 = j25 & BodyPartID.bodyIdMax;
                long j29 = (j * j24) + j21;
                int i21 = (int) j29;
                iArr2[i12] = (i21 << 1) | i18;
                long M04 = a.M0(j24, j6, j29 >>> 32, j23);
                long M05 = a.M0(j24, j9, M04 >>> 32, j26);
                long M06 = a.M0(j24, j15, M05 >>> 32, j28);
                long j30 = j27 + (M06 >>> 32);
                int i22 = (int) M04;
                iArr2[i15] = (i22 << 1) | (i21 >>> 31);
                int i23 = i22 >>> 31;
                int i24 = (int) M05;
                iArr2[i16] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) M06;
                iArr2[i19] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j30;
                iArr2[i20] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = i2 + 9;
                iArr2[i30] = i29 | ((iArr2[i30] + ((int) (j30 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }
}
