package org.spongycastle.math.raw;

import org.spongycastle.asn1.cmc.BodyPartID;
public abstract class Mont256 {
    public static int inverse32(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = (2 - (i * i2)) * i2;
        int i4 = (2 - (i * i3)) * i3;
        return (2 - (i * i4)) * i4;
    }

    public static void multAdd(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        char c = 0;
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            long j2 = ((long) iArr3[c]) & BodyPartID.bodyIdMax;
            long j3 = ((long) iArr[i2]) & BodyPartID.bodyIdMax;
            long j4 = j3 * j;
            long j5 = (j4 & BodyPartID.bodyIdMax) + j2;
            long j6 = ((long) (((int) j5) * i)) & BodyPartID.bodyIdMax;
            long j7 = (((long) iArr4[c]) & BodyPartID.bodyIdMax) * j6;
            long j8 = ((j5 + (j7 & BodyPartID.bodyIdMax)) >>> 32) + (j4 >>> 32) + (j7 >>> 32);
            int i4 = 1;
            for (int i5 = 8; i4 < i5; i5 = 8) {
                long j9 = (((long) iArr2[i4]) & BodyPartID.bodyIdMax) * j3;
                long j10 = (((long) iArr4[i4]) & BodyPartID.bodyIdMax) * j6;
                long j11 = (j9 & BodyPartID.bodyIdMax) + (j10 & BodyPartID.bodyIdMax) + (((long) iArr3[i4]) & BodyPartID.bodyIdMax) + j8;
                iArr3[i4 - 1] = (int) j11;
                j8 = (j11 >>> 32) + (j9 >>> 32) + (j10 >>> 32);
                i4++;
                j6 = j6;
            }
            long j12 = j8 + (((long) i3) & BodyPartID.bodyIdMax);
            iArr3[7] = (int) j12;
            i3 = (int) (j12 >>> 32);
            i2++;
            j = j;
            c = 0;
        }
        if (i3 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void multAddXF(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        char c = 0;
        long j = ((long) iArr2[0]) & BodyPartID.bodyIdMax;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= 8) {
                break;
            }
            long j2 = ((long) iArr[i]) & BodyPartID.bodyIdMax;
            long j3 = (j2 * j) + (((long) iArr3[c]) & BodyPartID.bodyIdMax);
            long j4 = j3 & BodyPartID.bodyIdMax;
            long j5 = (j3 >>> 32) + j4;
            int i3 = 1;
            for (int i4 = 8; i3 < i4; i4 = 8) {
                long j6 = (((long) iArr2[i3]) & BodyPartID.bodyIdMax) * j2;
                long j7 = (((long) iArr4[i3]) & BodyPartID.bodyIdMax) * j4;
                long j8 = (j6 & BodyPartID.bodyIdMax) + (j7 & BodyPartID.bodyIdMax) + (((long) iArr3[i3]) & BodyPartID.bodyIdMax) + j5;
                iArr3[i3 - 1] = (int) j8;
                j5 = (j8 >>> 32) + (j6 >>> 32) + (j7 >>> 32);
                i3++;
                j = j;
                j2 = j2;
                j4 = j4;
            }
            long j9 = j5 + (((long) i2) & BodyPartID.bodyIdMax);
            iArr3[7] = (int) j9;
            i2 = (int) (j9 >>> 32);
            i++;
            j = j;
            c = 0;
        }
        if (i2 != 0 || Nat256.gte(iArr3, iArr4)) {
            Nat256.sub(iArr3, iArr4, iArr3);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2, int i) {
        char c = 0;
        int i2 = 0;
        while (i2 < 8) {
            int i3 = iArr[c];
            long j = ((long) (i3 * i)) & BodyPartID.bodyIdMax;
            long j2 = (((((long) iArr2[c]) & BodyPartID.bodyIdMax) * j) + (((long) i3) & BodyPartID.bodyIdMax)) >>> 32;
            int i4 = 1;
            while (i4 < 8) {
                long j3 = ((((long) iArr2[i4]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[i4]) & BodyPartID.bodyIdMax) + j2;
                iArr[i4 - 1] = (int) j3;
                j2 = j3 >>> 32;
                i4++;
                i2 = i2;
            }
            iArr[7] = (int) j2;
            i2++;
            c = 0;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }

    public static void reduceXF(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 8; i++) {
            long j = ((long) iArr[0]) & BodyPartID.bodyIdMax;
            long j2 = j;
            for (int i2 = 1; i2 < 8; i2++) {
                long j3 = ((((long) iArr2[i2]) & BodyPartID.bodyIdMax) * j) + (((long) iArr[i2]) & BodyPartID.bodyIdMax) + j2;
                iArr[i2 - 1] = (int) j3;
                j2 = j3 >>> 32;
            }
            iArr[7] = (int) j2;
        }
        if (Nat256.gte(iArr, iArr2)) {
            Nat256.sub(iArr, iArr2, iArr);
        }
    }
}
