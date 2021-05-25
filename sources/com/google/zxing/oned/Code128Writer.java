package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
public final class Code128Writer extends OneDimensionalCodeWriter {

    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static a a(CharSequence charSequence, int i) {
        char charAt;
        a aVar = a.ONE_DIGIT;
        a aVar2 = a.UNCODABLE;
        int length = charSequence.length();
        if (i >= length) {
            return aVar2;
        }
        char charAt2 = charSequence.charAt(i);
        if (charAt2 == 241) {
            return a.FNC_1;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            return aVar2;
        }
        int i2 = i + 1;
        return (i2 < length && (charAt = charSequence.charAt(i2)) >= '0' && charAt <= '9') ? a.TWO_DIGITS : aVar;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        if (a(r17, r5 + 3) == r12) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        if (r10 == r11) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r13 == r12) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0100 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0036 A[SYNTHETIC] */
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r17) {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.encode(java.lang.String):boolean[]");
    }
}
