package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
public final class PDF417Writer implements Writer {
    public static BitMatrix a(byte[][] bArr, int i) {
        int i2 = i * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
        bitMatrix.clear();
        int height = (bitMatrix.getHeight() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    bitMatrix.set(i4 + i, height);
                }
            }
            i3++;
            height--;
        }
        return bitMatrix;
    }

    public static byte[][] b(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i = 0; i < bArr.length; i++) {
            int length2 = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length2] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        boolean z;
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            PDF417 pdf417 = new PDF417();
            int i3 = 30;
            int i4 = 2;
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
                if (map.containsKey(encodeHintType)) {
                    pdf417.setCompact(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
                }
                EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
                if (map.containsKey(encodeHintType2)) {
                    pdf417.setCompaction(Compaction.valueOf(map.get(encodeHintType2).toString()));
                }
                EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
                if (map.containsKey(encodeHintType3)) {
                    Dimensions dimensions = (Dimensions) map.get(encodeHintType3);
                    pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
                }
                EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType4)) {
                    i3 = Integer.parseInt(map.get(encodeHintType4).toString());
                }
                EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
                if (map.containsKey(encodeHintType5)) {
                    i4 = Integer.parseInt(map.get(encodeHintType5).toString());
                }
                EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
                if (map.containsKey(encodeHintType6)) {
                    pdf417.setEncoding(Charset.forName(map.get(encodeHintType6).toString()));
                }
            }
            pdf417.generateBarcodeLogic(str, i4);
            byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
            if ((i2 > i) != (scaledMatrix[0].length < scaledMatrix.length)) {
                scaledMatrix = b(scaledMatrix);
                z = true;
            } else {
                z = false;
            }
            int length = i / scaledMatrix[0].length;
            int length2 = i2 / scaledMatrix.length;
            if (length >= length2) {
                length = length2;
            }
            if (length <= 1) {
                return a(scaledMatrix, i3);
            }
            byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length << 2);
            if (z) {
                scaledMatrix2 = b(scaledMatrix2);
            }
            return a(scaledMatrix2, i3);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }
}
