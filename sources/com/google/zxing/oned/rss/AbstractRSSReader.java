package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
public abstract class AbstractRSSReader extends OneDReader {
    public final int[] a = new int[4];
    public final int[] b;
    public final float[] c;
    public final float[] d;
    public final int[] e;
    public final int[] f;

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.b = iArr;
        this.c = new float[4];
        this.d = new float[4];
        this.e = new int[(iArr.length / 2)];
        this.f = new int[(iArr.length / 2)];
    }

    @Deprecated
    public static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    public static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    public static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    public static boolean isFinderPattern(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f2 = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (OneDReader.patternMatchVariance(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] getDataCharacterCounters() {
        return this.b;
    }

    public final int[] getDecodeFinderCounters() {
        return this.a;
    }

    public final int[] getEvenCounts() {
        return this.f;
    }

    public final float[] getEvenRoundingErrors() {
        return this.d;
    }

    public final int[] getOddCounts() {
        return this.e;
    }

    public final float[] getOddRoundingErrors() {
        return this.c;
    }
}
