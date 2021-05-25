package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
public final class Encoder {
    public static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    public static int a(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray2.getSize() + mode.getCharacterCountBits(version) + bitArray.getSize();
    }

    public static Mode b(String str, String str2) {
        boolean z;
        if ("Shift_JIS".equals(str2)) {
            try {
                byte[] bytes = str.getBytes("Shift_JIS");
                int length = bytes.length;
                if (length % 2 == 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = true;
                            break;
                        }
                        int i2 = bytes[i] & 255;
                        if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                            break;
                        }
                        i += 2;
                    }
                }
            } catch (UnsupportedEncodingException unused) {
            }
            z = false;
            if (z) {
                return Mode.KANJI;
            }
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                z3 = true;
            } else if (d(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            return Mode.ALPHANUMERIC;
        }
        if (z3) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    public static Version c(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            if (e(i, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static Mode chooseMode(String str) {
        return b(str, null);
    }

    public static int d(int i) {
        int[] iArr = a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static boolean e(int i, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8;
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0567  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x00db A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb A[LOOP:0: B:34:0x009d->B:48:0x00cb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String r23, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r24, java.util.Map<com.google.zxing.EncodeHintType, ?> r25) throws com.google.zxing.WriterException {
        /*
        // Method dump skipped, instructions count: 1411
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.encode(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.QRCode");
    }
}
