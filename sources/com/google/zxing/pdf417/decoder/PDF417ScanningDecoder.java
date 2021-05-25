package com.google.zxing.pdf417.decoder;

import a2.j.k.h.a.c;
import a2.j.k.h.a.d;
import a2.j.k.h.a.f;
import a2.j.k.h.a.h;
import a2.j.k.h.a.i;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
public final class PDF417ScanningDecoder {
    public static final ErrorCorrection a = new ErrorCorrection();

    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a2.j.k.h.a.c a(a2.j.k.h.a.h r15) throws com.google.zxing.NotFoundException {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.a(a2.j.k.h.a.h):a2.j.k.h.a.c");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0213 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f5 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.common.DecoderResult b(int[] r26, int r27, int[] r28) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        // Method dump skipped, instructions count: 866
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.b(int[], int, int[]):com.google.zxing.common.DecoderResult");
    }

    public static d c(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i;
        int i9 = z ? -1 : 1;
        boolean z2 = z;
        int i10 = i3;
        int i11 = 0;
        loop0:
        while (true) {
            if (i11 >= 2) {
                break;
            }
            while (true) {
                if (z2) {
                    if (i10 < i8) {
                        continue;
                        break;
                    }
                } else if (i10 >= i2) {
                    continue;
                    break;
                }
                if (z2 != bitMatrix.get(i10, i4)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i10) > 2) {
                    i10 = i3;
                    break loop0;
                } else {
                    i10 += i9;
                }
            }
            i9 = -i9;
            z2 = !z2;
            i11++;
        }
        int[] iArr = new int[8];
        int i12 = z ? 1 : -1;
        boolean z3 = z;
        int i13 = i10;
        int i14 = 0;
        while (true) {
            if (z) {
                if (i13 >= i2) {
                    break;
                }
            } else if (i13 < i8) {
                break;
            }
            if (i14 >= 8) {
                break;
            } else if (bitMatrix.get(i13, i4) == z3) {
                iArr[i14] = iArr[i14] + 1;
                i13 += i12;
            } else {
                i14++;
                z3 = !z3;
            }
        }
        if (i14 != 8) {
            if (z) {
                i8 = i2;
            }
            if (!(i13 == i8 && i14 == 7)) {
                iArr = null;
            }
        }
        if (iArr == null) {
            return null;
        }
        int sum = MathUtils.sum(iArr);
        if (z) {
            i7 = i10 + sum;
        } else {
            for (int i15 = 0; i15 < iArr.length / 2; i15++) {
                int i16 = iArr[i15];
                iArr[i15] = iArr[(iArr.length - 1) - i15];
                iArr[(iArr.length - 1) - i15] = i16;
            }
            i10 -= sum;
            i7 = i10;
        }
        if (!(i5 + -2 <= sum && sum <= i6 + 2)) {
            return null;
        }
        float[][] fArr = i.a;
        float sum2 = (float) MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < 17; i19++) {
            if (((float) (iArr[i17] + i18)) <= ((((float) i19) * sum2) / 17.0f) + (sum2 / 34.0f)) {
                i18 += iArr[i17];
                i17++;
            }
            iArr2[i17] = iArr2[i17] + 1;
        }
        long j = 0;
        for (int i20 = 0; i20 < 8; i20++) {
            for (int i21 = 0; i21 < iArr2[i20]; i21++) {
                j = (j << 1) | ((long) (i20 % 2 == 0 ? 1 : 0));
            }
        }
        int i22 = (int) j;
        if (PDF417Common.getCodeword(i22) == -1) {
            i22 = -1;
        }
        if (i22 == -1) {
            int sum3 = MathUtils.sum(iArr);
            float[] fArr2 = new float[8];
            if (sum3 > 1) {
                for (int i23 = 0; i23 < 8; i23++) {
                    fArr2[i23] = ((float) iArr[i23]) / ((float) sum3);
                }
            }
            float f = Float.MAX_VALUE;
            int i24 = -1;
            int i25 = 0;
            while (true) {
                float[][] fArr3 = i.a;
                if (i25 >= fArr3.length) {
                    break;
                }
                float f2 = 0.0f;
                float[] fArr4 = fArr3[i25];
                for (int i26 = 0; i26 < 8; i26++) {
                    float f3 = fArr4[i26] - fArr2[i26];
                    f2 += f3 * f3;
                    if (f2 >= f) {
                        break;
                    }
                }
                if (f2 < f) {
                    i24 = PDF417Common.SYMBOL_TABLE[i25];
                    f = f2;
                }
                i25++;
            }
            i22 = i24;
        }
        int codeword = PDF417Common.getCodeword(i22);
        if (codeword == -1) {
            return null;
        }
        int[] iArr3 = new int[8];
        int i27 = i22;
        int i28 = 7;
        int i29 = 0;
        while (true) {
            int i30 = i27 & 1;
            if (i30 != i29) {
                i28--;
                if (i28 < 0) {
                    return new d(i10, i7, ((((iArr3[0] - iArr3[2]) + iArr3[4]) - iArr3[6]) + 9) % 9, codeword);
                }
                i29 = i30;
            }
            iArr3[i28] = iArr3[i28] + 1;
            i27 >>= 1;
        }
    }

    public static h d(BitMatrix bitMatrix, c cVar, ResultPoint resultPoint, boolean z, int i, int i2) {
        int i3;
        h hVar = new h(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= cVar.i && y >= cVar.h) {
                d c = c(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (c != null) {
                    hVar.b[y - hVar.a.h] = c;
                    if (z) {
                        i3 = c.a;
                    } else {
                        i3 = c.b;
                    }
                    x = i3;
                }
                y += i5;
            }
            i4++;
        }
        return hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        if (r5.e != r7.e) goto L_0x0064;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x00b8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix r23, com.google.zxing.ResultPoint r24, com.google.zxing.ResultPoint r25, com.google.zxing.ResultPoint r26, com.google.zxing.ResultPoint r27, int r28, int r29) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        // Method dump skipped, instructions count: 1309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.decode(com.google.zxing.common.BitMatrix, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, com.google.zxing.ResultPoint, int, int):com.google.zxing.common.DecoderResult");
    }

    public static boolean e(f fVar, int i) {
        return i >= 0 && i <= fVar.d + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(a2.j.k.h.a.b[][] r9) {
        /*
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0007:
            int r3 = r9.length     // Catch:{ all -> 0x006d }
            if (r2 >= r3) goto L_0x0065
            java.lang.String r3 = "Row %2d: "
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x006d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x006d }
            r5[r1] = r6     // Catch:{ all -> 0x006d }
            r0.format(r3, r5)     // Catch:{ all -> 0x006d }
            r3 = 0
        L_0x0019:
            r5 = r9[r2]     // Catch:{ all -> 0x006d }
            int r5 = r5.length     // Catch:{ all -> 0x006d }
            if (r3 >= r5) goto L_0x005b
            r5 = r9[r2]     // Catch:{ all -> 0x006d }
            r5 = r5[r3]     // Catch:{ all -> 0x006d }
            int[] r6 = r5.a()     // Catch:{ all -> 0x006d }
            int r6 = r6.length     // Catch:{ all -> 0x006d }
            if (r6 != 0) goto L_0x0030
            java.lang.String r5 = "        "
            r6 = 0
            r0.format(r5, r6)     // Catch:{ all -> 0x006d }
            goto L_0x0058
        L_0x0030:
            java.lang.String r6 = "%4d(%2d)"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x006d }
            int[] r8 = r5.a()     // Catch:{ all -> 0x006d }
            r8 = r8[r1]     // Catch:{ all -> 0x006d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x006d }
            r7[r1] = r8     // Catch:{ all -> 0x006d }
            int[] r8 = r5.a()     // Catch:{ all -> 0x006d }
            r8 = r8[r1]     // Catch:{ all -> 0x006d }
            java.util.Map<java.lang.Integer, java.lang.Integer> r5 = r5.a     // Catch:{ all -> 0x006d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x006d }
            java.lang.Object r5 = r5.get(r8)     // Catch:{ all -> 0x006d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x006d }
            r7[r4] = r5     // Catch:{ all -> 0x006d }
            r0.format(r6, r7)     // Catch:{ all -> 0x006d }
        L_0x0058:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x005b:
            java.lang.String r3 = "%n"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x006d }
            r0.format(r3, r4)     // Catch:{ all -> 0x006d }
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0065:
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x006d }
            r0.close()
            return r9
        L_0x006d:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x006f }
        L_0x006f:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r0 = move-exception
            r9.addSuppressed(r0)
        L_0x0078:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.toString(a2.j.k.h.a.b[][]):java.lang.String");
    }
}
