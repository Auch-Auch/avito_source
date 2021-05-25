package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import kotlin.text.Typography;
public final class Code39Writer extends OneDimensionalCodeWriter {
    public static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i)) < 0) {
                    int length2 = str.length();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char charAt = str.charAt(i2);
                        if (charAt != 0) {
                            if (charAt != ' ') {
                                if (charAt == '@') {
                                    sb.append("%V");
                                } else if (charAt == '`') {
                                    sb.append("%W");
                                } else if (!(charAt == '-' || charAt == '.')) {
                                    if (charAt <= 26) {
                                        sb.append(Typography.dollar);
                                        sb.append((char) ((charAt - 1) + 65));
                                    } else if (charAt < ' ') {
                                        sb.append('%');
                                        sb.append((char) ((charAt - 27) + 65));
                                    } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                                        sb.append('/');
                                        sb.append((char) ((charAt - '!') + 65));
                                    } else if (charAt <= '9') {
                                        sb.append((char) ((charAt - '0') + 48));
                                    } else if (charAt <= '?') {
                                        sb.append('%');
                                        sb.append((char) ((charAt - ';') + 70));
                                    } else if (charAt <= 'Z') {
                                        sb.append((char) ((charAt - 'A') + 65));
                                    } else if (charAt <= '_') {
                                        sb.append('%');
                                        sb.append((char) ((charAt - '[') + 75));
                                    } else if (charAt <= 'z') {
                                        sb.append('+');
                                        sb.append((char) ((charAt - 'a') + 65));
                                    } else if (charAt <= 127) {
                                        sb.append('%');
                                        sb.append((char) ((charAt - '{') + 80));
                                    } else {
                                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i2) + "'");
                                    }
                                }
                            }
                            sb.append(charAt);
                        } else {
                            sb.append("%U");
                        }
                    }
                    str = sb.toString();
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i++;
                }
            }
            int[] iArr = new int[9];
            int i3 = length + 25;
            for (int i4 = 0; i4 < length; i4++) {
                a(Code39Reader.e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i4))], iArr);
                for (int i5 = 0; i5 < 9; i5++) {
                    i3 += iArr[i5];
                }
            }
            boolean[] zArr = new boolean[i3];
            a(148, iArr);
            int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int appendPattern2 = OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr2, false) + appendPattern;
            for (int i6 = 0; i6 < length; i6++) {
                a(Code39Reader.e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i6))], iArr);
                int appendPattern3 = OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true) + appendPattern2;
                appendPattern2 = OneDimensionalCodeWriter.appendPattern(zArr, appendPattern3, iArr2, false) + appendPattern3;
            }
            a(148, iArr);
            OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
