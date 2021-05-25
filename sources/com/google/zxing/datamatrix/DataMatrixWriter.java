package com.google.zxing.datamatrix;

import a2.b.a.a.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.Map;
public final class DataMatrixWriter implements Writer {
    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        BitMatrix bitMatrix;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + VKApiPhotoSize.X + i2);
        } else {
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                if (dimension3 == null) {
                    dimension3 = null;
                }
                Dimension dimension4 = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                if (dimension4 != null) {
                    dimension2 = dimension4;
                }
                dimension = dimension2;
                dimension2 = dimension3;
            } else {
                dimension = null;
            }
            String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
            SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            defaultPlacement.place();
            int symbolDataWidth = lookup.getSymbolDataWidth();
            int symbolDataHeight = lookup.getSymbolDataHeight();
            ByteMatrix byteMatrix = new ByteMatrix(lookup.getSymbolWidth(), lookup.getSymbolHeight());
            int i3 = 0;
            for (int i4 = 0; i4 < symbolDataHeight; i4++) {
                if (i4 % lookup.matrixHeight == 0) {
                    int i5 = 0;
                    for (int i6 = 0; i6 < lookup.getSymbolWidth(); i6++) {
                        byteMatrix.set(i5, i3, i6 % 2 == 0);
                        i5++;
                    }
                    i3++;
                }
                int i7 = 0;
                for (int i8 = 0; i8 < symbolDataWidth; i8++) {
                    if (i8 % lookup.matrixWidth == 0) {
                        byteMatrix.set(i7, i3, true);
                        i7++;
                    }
                    byteMatrix.set(i7, i3, defaultPlacement.getBit(i8, i4));
                    i7++;
                    int i9 = lookup.matrixWidth;
                    if (i8 % i9 == i9 - 1) {
                        byteMatrix.set(i7, i3, i4 % 2 == 0);
                        i7++;
                    }
                }
                i3++;
                int i10 = lookup.matrixHeight;
                if (i4 % i10 == i10 - 1) {
                    int i11 = 0;
                    for (int i12 = 0; i12 < lookup.getSymbolWidth(); i12++) {
                        byteMatrix.set(i11, i3, true);
                        i11++;
                    }
                    i3++;
                }
            }
            int width = byteMatrix.getWidth();
            int height = byteMatrix.getHeight();
            int max = Math.max(i, width);
            int max2 = Math.max(i2, height);
            int min = Math.min(max / width, max2 / height);
            int n2 = a.n2(width, min, max, 2);
            int n22 = a.n2(height, min, max2, 2);
            if (i2 < height || i < width) {
                bitMatrix = new BitMatrix(width, height);
                n2 = 0;
                n22 = 0;
            } else {
                bitMatrix = new BitMatrix(i, i2);
            }
            bitMatrix.clear();
            int i13 = 0;
            while (i13 < height) {
                int i14 = 0;
                int i15 = n2;
                while (i14 < width) {
                    if (byteMatrix.get(i14, i13) == 1) {
                        bitMatrix.setRegion(i15, n22, min, min);
                    }
                    i14++;
                    i15 += min;
                }
                i13++;
                n22 += min;
            }
            return bitMatrix;
        }
    }
}
