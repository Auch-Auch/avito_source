package com.google.zxing.maxicode.decoder;

import a2.j.k.e.a.a;
import a2.j.k.e.a.b;
import com.google.common.base.Ascii;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.text.DecimalFormat;
import java.util.Map;
public final class Decoder {
    public final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) throws ChecksumException {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i5 / i6)];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.a.decode(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        String str;
        byte[] bArr2 = new byte[144];
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        for (int i = 0; i < height; i++) {
            int[] iArr = a.a[i];
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && bitMatrix.get(i2, i)) {
                    int i4 = i3 / 6;
                    bArr2[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr2[i4]);
                }
            }
        }
        a(bArr2, 0, 10, 10, 0);
        int i5 = bArr2[0] & Ascii.SI;
        if (i5 == 2 || i5 == 3 || i5 == 4) {
            a(bArr2, 20, 84, 40, 1);
            a(bArr2, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (i5 == 5) {
            a(bArr2, 20, 68, 56, 1);
            a(bArr2, 20, 68, 56, 2);
            bArr = new byte[78];
        } else {
            throw FormatException.getFormatInstance();
        }
        System.arraycopy(bArr2, 0, bArr, 0, 10);
        System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
        StringBuilder sb = new StringBuilder(144);
        if (i5 == 2 || i5 == 3) {
            if (i5 == 2) {
                str = new DecimalFormat("0000000000".substring(0, b.a(bArr, new byte[]{39, 40, 41, 42, Ascii.US, 32}))).format((long) b.a(bArr, new byte[]{33, 34, 35, 36, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 7, 8, 9, 10, Ascii.VT, Ascii.FF, 1, 2}));
            } else {
                String[] strArr = b.a;
                str = String.valueOf(new char[]{strArr[0].charAt(b.a(bArr, new byte[]{39, 40, 41, 42, Ascii.US, 32})), strArr[0].charAt(b.a(bArr, new byte[]{33, 34, 35, 36, Ascii.EM, Ascii.SUB})), strArr[0].charAt(b.a(bArr, new byte[]{Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, 19, Ascii.DC4})), strArr[0].charAt(b.a(bArr, new byte[]{Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.CR, Ascii.SO})), strArr[0].charAt(b.a(bArr, new byte[]{Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 7, 8})), strArr[0].charAt(b.a(bArr, new byte[]{9, 10, Ascii.VT, Ascii.FF, 1, 2}))});
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String format = decimalFormat.format((long) b.a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38}));
            String format2 = decimalFormat.format((long) b.a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52}));
            sb.append(b.b(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, str + (char) 29 + format + (char) 29 + format2 + (char) 29);
            } else {
                sb.insert(0, str + (char) 29 + format + (char) 29 + format2 + (char) 29);
            }
        } else if (i5 == 4) {
            sb.append(b.b(bArr, 1, 93));
        } else if (i5 == 5) {
            sb.append(b.b(bArr, 1, 77));
        }
        return new DecoderResult(bArr, sb.toString(), null, String.valueOf(i5));
    }
}
