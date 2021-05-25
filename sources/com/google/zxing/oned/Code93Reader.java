package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
public final class Code93Reader extends OneDReader {
    public static final char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    public static final int[] d;
    public static final int e;
    public final StringBuilder a = new StringBuilder(20);
    public final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        d = iArr;
        e = iArr[47];
    }

    public static void b(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != c[i3 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public static int c(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < round; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        r8 = com.google.zxing.oned.Code93Reader.c[r9];
        r7.append(r8);
        r9 = r6.length;
        r12 = r4;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        if (r10 >= r9) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        r9 = r18.getNextSet(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007c, code lost:
        if (r8 != '*') goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r7.deleteCharAt(r7.length() - 1);
        r8 = r6.length;
        r10 = 0;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        if (r10 >= r8) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
        if (r9 == r5) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        if (r18.get(r9) == false) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        if (r7.length() < 2) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        r1 = r7.length();
        b(r7, r1 - 2, 20);
        b(r7, r1 - 1, 15);
        r7.setLength(r7.length() - 2);
        r1 = r7.length();
        r5 = new java.lang.StringBuilder(r1);
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c3, code lost:
        if (r6 >= r1) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        r8 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cb, code lost:
        if (r8 < 'a') goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r8 > 'd') goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d3, code lost:
        if (r6 >= (r1 - 1)) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d5, code lost:
        r6 = r6 + 1;
        r9 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        switch(r8) {
            case 97: goto L_0x013a;
            case 98: goto L_0x0104;
            case 99: goto L_0x00f3;
            case 100: goto L_0x00e7;
            default: goto L_0x00e4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e4, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        if (r9 < 'A') goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e9, code lost:
        if (r9 > 'Z') goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00eb, code lost:
        r9 = r9 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f2, code lost:
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r9 < 'A') goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f5, code lost:
        if (r9 > 'O') goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f7, code lost:
        r9 = r9 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fa, code lost:
        if (r9 != 'Z') goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fc, code lost:
        r8 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0103, code lost:
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0104, code lost:
        if (r9 < 'A') goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0108, code lost:
        if (r9 > 'E') goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010a, code lost:
        r9 = r9 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010f, code lost:
        if (r9 < 'F') goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0113, code lost:
        if (r9 > 'J') goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0115, code lost:
        r9 = r9 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011a, code lost:
        if (r9 < 'K') goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011c, code lost:
        if (r9 > 'O') goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011e, code lost:
        r9 = r9 + 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0123, code lost:
        if (r9 < 'P') goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0127, code lost:
        if (r9 > 'S') goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0129, code lost:
        r9 = r9 + '+';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012e, code lost:
        if (r9 < 'T') goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0130, code lost:
        if (r9 > 'Z') goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0132, code lost:
        r8 = com.google.common.base.Ascii.MAX;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0139, code lost:
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013a, code lost:
        if (r9 < 'A') goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013c, code lost:
        if (r9 > 'Z') goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013e, code lost:
        r9 = r9 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0140, code lost:
        r8 = (char) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0146, code lost:
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0147, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014f, code lost:
        throw com.google.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0150, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0153, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0156, code lost:
        r9 = (float) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0182, code lost:
        return new com.google.zxing.Result(r5.toString(), null, new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint(((float) (r2[1] + r2[0])) / 2.0f, r9), new com.google.zxing.ResultPoint((((float) r12) / 2.0f) + ((float) r4), r9)}, com.google.zxing.BarcodeFormat.CODE_93);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0187, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x018c, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    @Override // com.google.zxing.oned.OneDReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r17, com.google.zxing.common.BitArray r18, java.util.Map<com.google.zxing.DecodeHintType, ?> r19) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        /*
        // Method dump skipped, instructions count: 466
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code93Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
