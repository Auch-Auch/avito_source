package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
public final class CodaBarReader extends OneDReader {
    public static final char[] d = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    public static final char[] f = {'A', 'B', 'C', 'D'};
    public final StringBuilder a = new StringBuilder(20);
    public int[] b = new int[80];
    public int c = 0;

    public static boolean b(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void c(int i) {
        int[] iArr = this.b;
        int i2 = this.c;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(i3 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.b = iArr2;
        }
    }

    public final int d(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.b, 0);
        this.c = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset < size) {
            int i2 = 0;
            boolean z = true;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) != z) {
                    i2++;
                } else {
                    c(i2);
                    z = !z;
                    i2 = 1;
                }
                nextUnset++;
            }
            c(i2);
            int i3 = 1;
            while (i3 < this.c) {
                int d2 = d(i3);
                if (d2 != -1 && b(f, d[d2])) {
                    int i4 = 0;
                    for (int i5 = i3; i5 < i3 + 7; i5++) {
                        i4 += this.b[i5];
                    }
                    if (i3 == 1 || this.b[i3 - 1] >= i4 / 2) {
                        this.a.setLength(0);
                        int i6 = i3;
                        while (true) {
                            int d3 = d(i6);
                            if (d3 != -1) {
                                this.a.append((char) d3);
                                i6 += 8;
                                if ((this.a.length() <= 1 || !b(f, d[d3])) && i6 < this.c) {
                                }
                            } else {
                                throw NotFoundException.getNotFoundInstance();
                            }
                        }
                        int i7 = i6 - 1;
                        int i8 = this.b[i7];
                        int i9 = 0;
                        for (int i10 = -8; i10 < -1; i10++) {
                            i9 += this.b[i6 + i10];
                        }
                        if (i6 >= this.c || i8 >= i9 / 2) {
                            int[] iArr = {0, 0, 0, 0};
                            int[] iArr2 = {0, 0, 0, 0};
                            int length = this.a.length() - 1;
                            int i11 = i3;
                            int i12 = 0;
                            while (true) {
                                int i13 = e[this.a.charAt(i12)];
                                for (int i14 = 6; i14 >= 0; i14--) {
                                    int i15 = (i14 & 1) + ((i13 & 1) << 1);
                                    iArr[i15] = iArr[i15] + this.b[i11 + i14];
                                    iArr2[i15] = iArr2[i15] + 1;
                                    i13 >>= 1;
                                }
                                if (i12 >= length) {
                                    break;
                                }
                                i11 += 8;
                                i12++;
                            }
                            float[] fArr = new float[4];
                            float[] fArr2 = new float[4];
                            int i16 = 0;
                            for (int i17 = 2; i16 < i17; i17 = 2) {
                                fArr2[i16] = 0.0f;
                                int i18 = i16 + 2;
                                fArr2[i18] = ((((float) iArr[i18]) / ((float) iArr2[i18])) + (((float) iArr[i16]) / ((float) iArr2[i16]))) / 2.0f;
                                fArr[i16] = fArr2[i18];
                                fArr[i18] = ((((float) iArr[i18]) * 2.0f) + 1.5f) / ((float) iArr2[i18]);
                                i16++;
                            }
                            int i19 = i3;
                            int i20 = 0;
                            loop8:
                            while (true) {
                                int i21 = e[this.a.charAt(i20)];
                                for (int i22 = 6; i22 >= 0; i22--) {
                                    int i23 = (i22 & 1) + ((i21 & 1) << 1);
                                    float f2 = (float) this.b[i19 + i22];
                                    if (f2 < fArr2[i23] || f2 > fArr[i23]) {
                                        break loop8;
                                    }
                                    i21 >>= 1;
                                }
                                if (i20 < length) {
                                    i19 += 8;
                                    i20++;
                                } else {
                                    for (int i24 = 0; i24 < this.a.length(); i24++) {
                                        StringBuilder sb = this.a;
                                        sb.setCharAt(i24, d[sb.charAt(i24)]);
                                    }
                                    char charAt = this.a.charAt(0);
                                    char[] cArr = f;
                                    if (b(cArr, charAt)) {
                                        StringBuilder sb2 = this.a;
                                        if (!b(cArr, sb2.charAt(sb2.length() - 1))) {
                                            throw NotFoundException.getNotFoundInstance();
                                        } else if (this.a.length() > 3) {
                                            if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                                                StringBuilder sb3 = this.a;
                                                sb3.deleteCharAt(sb3.length() - 1);
                                                this.a.deleteCharAt(0);
                                            }
                                            int i25 = 0;
                                            for (int i26 = 0; i26 < i3; i26++) {
                                                i25 += this.b[i26];
                                            }
                                            float f3 = (float) i25;
                                            while (i3 < i7) {
                                                i25 += this.b[i3];
                                                i3++;
                                            }
                                            float f4 = (float) i;
                                            return new Result(this.a.toString(), null, new ResultPoint[]{new ResultPoint(f3, f4), new ResultPoint((float) i25, f4)}, BarcodeFormat.CODABAR);
                                        } else {
                                            throw NotFoundException.getNotFoundInstance();
                                        }
                                    } else {
                                        throw NotFoundException.getNotFoundInstance();
                                    }
                                }
                            }
                            throw NotFoundException.getNotFoundInstance();
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                i3 += 2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
