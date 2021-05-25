package com.google.zxing.oned;

import com.google.common.base.Ascii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
public final class Code39Reader extends OneDReader {
    public static final int[] e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};
    public final boolean a;
    public final boolean b;
    public final StringBuilder c;
    public final int[] d;

    public Code39Reader() {
        this(false);
    }

    public static int b(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        char c2;
        String str;
        char c3;
        int i2;
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        int i3 = nextSet;
        boolean z = false;
        int i4 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (b(iArr) != 148 || !bitArray.isRange(Math.max(0, i3 - ((nextSet - i3) / 2)), i3, false)) {
                    i3 += iArr[0] + iArr[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i4 = i5;
                } else {
                    int[] iArr2 = {i3, nextSet};
                    int nextSet2 = bitArray.getNextSet(iArr2[1]);
                    int size2 = bitArray.getSize();
                    while (true) {
                        OneDReader.recordPattern(bitArray, nextSet2, iArr);
                        int b2 = b(iArr);
                        if (b2 >= 0) {
                            int i6 = 0;
                            while (true) {
                                int[] iArr3 = e;
                                if (i6 < iArr3.length) {
                                    if (iArr3[i6] == b2) {
                                        c2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i6);
                                        break;
                                    }
                                    i6++;
                                } else if (b2 == 148) {
                                    c2 = '*';
                                } else {
                                    throw NotFoundException.getNotFoundInstance();
                                }
                            }
                            sb.append(c2);
                            int i7 = nextSet2;
                            for (int i8 : iArr) {
                                i7 += i8;
                            }
                            int nextSet3 = bitArray.getNextSet(i7);
                            if (c2 == '*') {
                                sb.setLength(sb.length() - 1);
                                int i9 = 0;
                                for (int i10 : iArr) {
                                    i9 += i10;
                                }
                                int i11 = (nextSet3 - nextSet2) - i9;
                                if (nextSet3 == size2 || (i11 << 1) >= i9) {
                                    if (this.a) {
                                        int length2 = sb.length() - 1;
                                        int i12 = 0;
                                        for (int i13 = 0; i13 < length2; i13++) {
                                            i12 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i13));
                                        }
                                        if (sb.charAt(length2) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i12 % 43)) {
                                            sb.setLength(length2);
                                        } else {
                                            throw ChecksumException.getChecksumInstance();
                                        }
                                    }
                                    if (sb.length() != 0) {
                                        if (this.b) {
                                            int length3 = sb.length();
                                            StringBuilder sb2 = new StringBuilder(length3);
                                            int i14 = 0;
                                            while (i14 < length3) {
                                                char charAt = sb.charAt(i14);
                                                if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                                                    i14++;
                                                    char charAt2 = sb.charAt(i14);
                                                    if (charAt != '$') {
                                                        if (charAt != '%') {
                                                            if (charAt != '+') {
                                                                if (charAt == '/') {
                                                                    if (charAt2 >= 'A' && charAt2 <= 'O') {
                                                                        i2 = charAt2 - ' ';
                                                                    } else if (charAt2 == 'Z') {
                                                                        c3 = ':';
                                                                        sb2.append(c3);
                                                                    } else {
                                                                        throw FormatException.getFormatInstance();
                                                                    }
                                                                }
                                                            } else if (charAt2 < 'A' || charAt2 > 'Z') {
                                                                throw FormatException.getFormatInstance();
                                                            } else {
                                                                i2 = charAt2 + ' ';
                                                            }
                                                        } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                                                            i2 = charAt2 - '&';
                                                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                                                            i2 = charAt2 - 11;
                                                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                                                            i2 = charAt2 + 16;
                                                        } else if (charAt2 >= 'P' && charAt2 <= 'T') {
                                                            i2 = charAt2 + '+';
                                                        } else if (charAt2 != 'U') {
                                                            if (charAt2 == 'V') {
                                                                c3 = '@';
                                                            } else if (charAt2 == 'W') {
                                                                c3 = '`';
                                                            } else if (charAt2 == 'X' || charAt2 == 'Y' || charAt2 == 'Z') {
                                                                c3 = Ascii.MAX;
                                                            } else {
                                                                throw FormatException.getFormatInstance();
                                                            }
                                                            sb2.append(c3);
                                                        }
                                                        c3 = 0;
                                                        sb2.append(c3);
                                                    } else if (charAt2 < 'A' || charAt2 > 'Z') {
                                                        throw FormatException.getFormatInstance();
                                                    } else {
                                                        i2 = charAt2 - '@';
                                                    }
                                                    c3 = (char) i2;
                                                    sb2.append(c3);
                                                } else {
                                                    sb2.append(charAt);
                                                }
                                                i14++;
                                            }
                                            str = sb2.toString();
                                        } else {
                                            str = sb.toString();
                                        }
                                        float f = (float) i;
                                        return new Result(str, null, new ResultPoint[]{new ResultPoint(((float) (iArr2[1] + iArr2[0])) / 2.0f, f), new ResultPoint((((float) i9) / 2.0f) + ((float) nextSet2), f)}, BarcodeFormat.CODE_39);
                                    }
                                    throw NotFoundException.getNotFoundInstance();
                                }
                                throw NotFoundException.getNotFoundInstance();
                            }
                            nextSet2 = nextSet3;
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                }
                iArr[i4] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Code39Reader(boolean z) {
        this(z, false);
    }

    public Code39Reader(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = new StringBuilder(20);
        this.d = new int[9];
    }
}
