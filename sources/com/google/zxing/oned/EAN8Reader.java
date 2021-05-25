package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public final class EAN8Reader extends UPCEANReader {
    public final int[] i = new int[4];

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < size; i3++) {
            sb.append((char) (UPCEANReader.c(bitArray, iArr2, i2, UPCEANReader.g) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int[] iArr3 = UPCEANReader.e;
        int i5 = UPCEANReader.d(bitArray, i2, true, iArr3, new int[iArr3.length])[1];
        for (int i6 = 0; i6 < 4 && i5 < size; i6++) {
            sb.append((char) (UPCEANReader.c(bitArray, iArr2, i5, UPCEANReader.g) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat f() {
        return BarcodeFormat.EAN_8;
    }
}
