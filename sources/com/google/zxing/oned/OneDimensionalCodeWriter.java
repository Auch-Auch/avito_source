package com.google.zxing.oned;

import a2.b.a.a.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.Map;
public abstract class OneDimensionalCodeWriter implements Writer {
    public static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + VKApiPhotoSize.X + i2);
        } else {
            int defaultMargin = getDefaultMargin();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    defaultMargin = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            boolean[] encode = encode(str);
            int length = encode.length;
            int i3 = defaultMargin + length;
            int max = Math.max(i, i3);
            int max2 = Math.max(1, i2);
            int i4 = max / i3;
            int n2 = a.n2(length, i4, max, 2);
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i5 = 0;
            while (i5 < length) {
                if (encode[i5]) {
                    bitMatrix.setRegion(n2, 0, i4, max2);
                }
                i5++;
                n2 += i4;
            }
            return bitMatrix;
        }
    }
}
