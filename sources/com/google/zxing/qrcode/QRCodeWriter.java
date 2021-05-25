package com.google.zxing.qrcode;

import a2.b.a.a.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.Map;
public final class QRCodeWriter implements Writer {
    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + VKApiPhotoSize.X + i2);
        } else {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i3 = 4;
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                if (map.containsKey(encodeHintType)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
                }
                EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType2)) {
                    i3 = Integer.parseInt(map.get(encodeHintType2).toString());
                }
            }
            ByteMatrix matrix = Encoder.encode(str, errorCorrectionLevel, map).getMatrix();
            if (matrix != null) {
                int width = matrix.getWidth();
                int height = matrix.getHeight();
                int i4 = i3 << 1;
                int i5 = width + i4;
                int i6 = i4 + height;
                int max = Math.max(i, i5);
                int max2 = Math.max(i2, i6);
                int min = Math.min(max / i5, max2 / i6);
                int n2 = a.n2(width, min, max, 2);
                int n22 = a.n2(height, min, max2, 2);
                BitMatrix bitMatrix = new BitMatrix(max, max2);
                int i7 = 0;
                while (i7 < height) {
                    int i8 = 0;
                    int i9 = n2;
                    while (i8 < width) {
                        if (matrix.get(i8, i7) == 1) {
                            bitMatrix.setRegion(i9, n22, min, min);
                        }
                        i8++;
                        i9 += min;
                    }
                    i7++;
                    n22 += min;
                }
                return bitMatrix;
            }
            throw new IllegalStateException();
        }
    }
}
