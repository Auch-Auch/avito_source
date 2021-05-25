package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class FinderPatternFinder {
    public static final int MAX_MODULES = 97;
    public static final int MIN_SKIP = 3;
    public final BitMatrix a;
    public final List<FinderPattern> b;
    public boolean c;
    public final int[] d;
    public final ResultPointCallback e;

    public static final class b implements Serializable, Comparator<FinderPattern> {
        public final float a;

        public b(float f, a aVar) {
            this.a = f;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            FinderPattern finderPattern3 = finderPattern;
            FinderPattern finderPattern4 = finderPattern2;
            int compare = Integer.compare(finderPattern4.d, finderPattern3.d);
            return compare == 0 ? Float.compare(Math.abs(finderPattern3.getEstimatedModuleSize() - this.a), Math.abs(finderPattern4.getEstimatedModuleSize() - this.a)) : compare;
        }
    }

    public static final class c implements Serializable, Comparator<FinderPattern> {
        public final float a;

        public c(float f, a aVar) {
            this.a = f;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.getEstimatedModuleSize() - this.a), Math.abs(finderPattern.getEstimatedModuleSize() - this.a));
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    public static boolean foundPatternDiagonal(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 1.333f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    public final int[] b() {
        clearCounts(this.d);
        return this.d;
    }

    public final boolean c() {
        int size = this.b.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern finderPattern : this.b) {
            if (finderPattern.d >= 2) {
                i++;
                f2 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern finderPattern2 : this.b) {
            f += Math.abs(finderPattern2.getEstimatedModuleSize() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    public final void clearCounts(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    public final BitMatrix getImage() {
        return this.a;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.b;
    }

    @Deprecated
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        return handlePossibleCenter(iArr, i, i2);
    }

    public final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.a = bitMatrix;
        this.b = new ArrayList();
        this.d = new int[5];
        this.e = resultPointCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02f7 A[LOOP:18: B:160:0x0284->B:174:0x02f7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x02c9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:234:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handlePossibleCenter(int[] r18, int r19, int r20) {
        /*
        // Method dump skipped, instructions count: 785
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.handlePossibleCenter(int[], int, int):boolean");
    }
}
