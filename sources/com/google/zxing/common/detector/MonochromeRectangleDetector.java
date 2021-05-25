package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
@Deprecated
public final class MonochromeRectangleDetector {
    public final BitMatrix a;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.a = bitMatrix;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0031 A[EDGE_INSN: B:61:0x0031->B:18:0x0031 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0067 A[EDGE_INSN: B:77:0x0067->B:40:0x0067 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] a(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L_0x0005:
            if (r2 < r8) goto L_0x003a
            com.google.zxing.common.BitMatrix r3 = r5.a
            if (r10 == 0) goto L_0x0012
            boolean r3 = r3.get(r2, r6)
            if (r3 == 0) goto L_0x001b
            goto L_0x0018
        L_0x0012:
            boolean r3 = r3.get(r6, r2)
            if (r3 == 0) goto L_0x001b
        L_0x0018:
            int r2 = r2 + -1
            goto L_0x0005
        L_0x001b:
            r3 = r2
        L_0x001c:
            int r3 = r3 + -1
            if (r3 < r8) goto L_0x0031
            com.google.zxing.common.BitMatrix r4 = r5.a
            if (r10 == 0) goto L_0x002b
            boolean r4 = r4.get(r3, r6)
            if (r4 == 0) goto L_0x001c
            goto L_0x0031
        L_0x002b:
            boolean r4 = r4.get(r6, r3)
            if (r4 == 0) goto L_0x001c
        L_0x0031:
            int r4 = r2 - r3
            if (r3 < r8) goto L_0x003a
            if (r4 <= r7) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r2 = r3
            goto L_0x0005
        L_0x003a:
            r8 = 1
            int r2 = r2 + r8
        L_0x003c:
            if (r0 >= r9) goto L_0x0070
            com.google.zxing.common.BitMatrix r3 = r5.a
            if (r10 == 0) goto L_0x0049
            boolean r3 = r3.get(r0, r6)
            if (r3 == 0) goto L_0x0052
            goto L_0x004f
        L_0x0049:
            boolean r3 = r3.get(r6, r0)
            if (r3 == 0) goto L_0x0052
        L_0x004f:
            int r0 = r0 + 1
            goto L_0x003c
        L_0x0052:
            r3 = r0
        L_0x0053:
            int r3 = r3 + r8
            if (r3 >= r9) goto L_0x0067
            com.google.zxing.common.BitMatrix r4 = r5.a
            if (r10 == 0) goto L_0x0061
            boolean r4 = r4.get(r3, r6)
            if (r4 == 0) goto L_0x0053
            goto L_0x0067
        L_0x0061:
            boolean r4 = r4.get(r6, r3)
            if (r4 == 0) goto L_0x0053
        L_0x0067:
            int r4 = r3 - r0
            if (r3 >= r9) goto L_0x0070
            if (r4 <= r7) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r0 = r3
            goto L_0x003c
        L_0x0070:
            int r0 = r0 + -1
            if (r0 <= r2) goto L_0x007c
            int[] r6 = new int[r1]
            r7 = 0
            r6[r7] = r2
            r6[r8] = r0
            return r6
        L_0x007c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.a(int, int, int, int, boolean):int[]");
    }

    public final ResultPoint b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int[] iArr;
        int[] iArr2 = null;
        int i10 = i;
        int i11 = i5;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            if (i2 == 0) {
                iArr = a(i11, i9, i3, i4, true);
            } else {
                iArr = a(i10, i9, i7, i8, false);
            }
            if (iArr != null) {
                i11 += i6;
                i10 += i2;
                iArr2 = iArr;
            } else if (iArr2 != null) {
                char c = 1;
                if (i2 == 0) {
                    int i12 = i11 - i6;
                    if (iArr2[0] >= i) {
                        return new ResultPoint((float) iArr2[1], (float) i12);
                    }
                    if (iArr2[1] <= i) {
                        return new ResultPoint((float) iArr2[0], (float) i12);
                    }
                    if (i6 > 0) {
                        c = 0;
                    }
                    return new ResultPoint((float) iArr2[c], (float) i12);
                }
                int i13 = i10 - i2;
                if (iArr2[0] >= i5) {
                    return new ResultPoint((float) i13, (float) iArr2[1]);
                }
                if (iArr2[1] <= i5) {
                    return new ResultPoint((float) i13, (float) iArr2[0]);
                }
                float f = (float) i13;
                if (i2 < 0) {
                    c = 0;
                }
                return new ResultPoint(f, (float) iArr2[c]);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.a.getHeight();
        int width = this.a.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int max = Math.max(1, height / 256);
        int max2 = Math.max(1, width / 256);
        int i3 = -max;
        int i4 = i2 / 2;
        int y = ((int) b(i2, 0, 0, width, i, i3, 0, height, i4).getY()) - 1;
        int i5 = i / 2;
        ResultPoint b = b(i2, -max2, 0, width, i, 0, y, height, i5);
        int x = ((int) b.getX()) - 1;
        ResultPoint b2 = b(i2, max2, x, width, i, 0, y, height, i5);
        int x2 = ((int) b2.getX()) + 1;
        ResultPoint b3 = b(i2, 0, x, x2, i, max, y, height, i4);
        return new ResultPoint[]{b(i2, 0, x, x2, i, i3, y, ((int) b3.getY()) + 1, i2 / 4), b, b2, b3};
    }
}
