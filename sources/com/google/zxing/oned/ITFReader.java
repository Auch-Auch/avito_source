package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;
public final class ITFReader extends OneDReader {
    public static final int[] b = {6, 8, 10, 12, 14};
    public static final int[] c = {1, 1, 1, 1};
    public static final int[][] d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    public int a = -1;

    public static int b(int[] iArr) throws NotFoundException {
        int length = e.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, e[i2], 0.5f);
            if (patternMatchVariance < f) {
                i = i2;
                f = patternMatchVariance;
            } else if (patternMatchVariance == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] c(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3 = i4;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void d(BitArray bitArray, int i) throws NotFoundException {
        int i2 = this.a * 10;
        if (i2 >= i) {
            i2 = i;
        }
        while (true) {
            i--;
            if (i2 <= 0 || i < 0 || bitArray.get(i)) {
                break;
            }
            i2--;
        }
        if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        int[] iArr;
        boolean z;
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            int[] c2 = c(bitArray, nextSet, c);
            this.a = (c2[1] - c2[0]) / 4;
            d(bitArray, c2[0]);
            bitArray.reverse();
            try {
                int size2 = bitArray.getSize();
                int nextSet2 = bitArray.getNextSet(0);
                if (nextSet2 != size2) {
                    try {
                        iArr = c(bitArray, nextSet2, d[0]);
                    } catch (NotFoundException unused) {
                        iArr = c(bitArray, nextSet2, d[1]);
                    }
                    d(bitArray, iArr[0]);
                    int i2 = iArr[0];
                    iArr[0] = bitArray.getSize() - iArr[1];
                    iArr[1] = bitArray.getSize() - i2;
                    bitArray.reverse();
                    StringBuilder sb = new StringBuilder(20);
                    int i3 = c2[1];
                    int i4 = iArr[0];
                    int[] iArr2 = new int[10];
                    int[] iArr3 = new int[5];
                    int[] iArr4 = new int[5];
                    while (i3 < i4) {
                        OneDReader.recordPattern(bitArray, i3, iArr2);
                        for (int i5 = 0; i5 < 5; i5++) {
                            int i6 = i5 * 2;
                            iArr3[i5] = iArr2[i6];
                            iArr4[i5] = iArr2[i6 + 1];
                        }
                        sb.append((char) (b(iArr3) + 48));
                        sb.append((char) (b(iArr4) + 48));
                        for (int i7 = 0; i7 < 10; i7++) {
                            i3 += iArr2[i7];
                        }
                    }
                    String sb2 = sb.toString();
                    int[] iArr5 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
                    if (iArr5 == null) {
                        iArr5 = b;
                    }
                    int length = sb2.length();
                    int length2 = iArr5.length;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            z = false;
                            break;
                        }
                        int i10 = iArr5[i8];
                        if (length == i10) {
                            z = true;
                            break;
                        }
                        if (i10 > i9) {
                            i9 = i10;
                        }
                        i8++;
                    }
                    if (!z && length > i9) {
                        z = true;
                    }
                    if (z) {
                        float f = (float) i;
                        return new Result(sb2, null, new ResultPoint[]{new ResultPoint((float) c2[1], f), new ResultPoint((float) iArr[0], f)}, BarcodeFormat.ITF);
                    }
                    throw FormatException.getFormatInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            } catch (Throwable th) {
                bitArray.reverse();
                throw th;
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
