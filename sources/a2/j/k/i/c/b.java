package a2.j.k.i.c;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;
public final class b {
    public static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    public static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    public static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    public static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        byteMatrix.clear((byte) -1);
        int length = a[0].length;
        d(0, 0, byteMatrix);
        d(byteMatrix.getWidth() - length, 0, byteMatrix);
        d(0, byteMatrix.getWidth() - length, byteMatrix);
        c(0, 7, byteMatrix);
        c(byteMatrix.getWidth() - 8, 7, byteMatrix);
        c(0, byteMatrix.getWidth() - 8, byteMatrix);
        e(7, 0, byteMatrix);
        e((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        e(7, byteMatrix.getHeight() - 7, byteMatrix);
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
            byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
            if (version.getVersionNumber() >= 2) {
                int[] iArr = c[version.getVersionNumber() - 1];
                for (int i6 : iArr) {
                    if (i6 >= 0) {
                        for (int i7 : iArr) {
                            if (i7 >= 0 && g(byteMatrix.get(i7, i6))) {
                                int i8 = i7 - 2;
                                int i9 = i6 - 2;
                                for (int i10 = 0; i10 < 5; i10++) {
                                    int[] iArr2 = b[i10];
                                    for (int i11 = 0; i11 < 5; i11++) {
                                        byteMatrix.set(i8 + i11, i9 + i10, iArr2[i11]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int i12 = 8;
            while (i12 < byteMatrix.getWidth() - 8) {
                int i13 = i12 + 1;
                int i14 = i13 % 2;
                if (g(byteMatrix.get(i12, 6))) {
                    byteMatrix.set(i12, 6, i14);
                }
                if (g(byteMatrix.get(6, i12))) {
                    byteMatrix.set(6, i12, i14);
                }
                i12 = i13;
            }
            BitArray bitArray2 = new BitArray();
            if (QRCode.isValidMaskPattern(i)) {
                int bits = (errorCorrectionLevel.getBits() << 3) | i;
                bitArray2.appendBits(bits, 5);
                bitArray2.appendBits(b(bits, 1335), 10);
                BitArray bitArray3 = new BitArray();
                bitArray3.appendBits(21522, 15);
                bitArray2.xor(bitArray3);
                if (bitArray2.getSize() == 15) {
                    for (int i15 = 0; i15 < bitArray2.getSize(); i15++) {
                        boolean z2 = bitArray2.get((bitArray2.getSize() - 1) - i15);
                        int[] iArr3 = d[i15];
                        byteMatrix.set(iArr3[0], iArr3[1], z2);
                        if (i15 < 8) {
                            byteMatrix.set((byteMatrix.getWidth() - i15) - 1, 8, z2);
                        } else {
                            byteMatrix.set(8, (i15 - 8) + (byteMatrix.getHeight() - 7), z2);
                        }
                    }
                    if (version.getVersionNumber() >= 7) {
                        BitArray bitArray4 = new BitArray();
                        bitArray4.appendBits(version.getVersionNumber(), 6);
                        bitArray4.appendBits(b(version.getVersionNumber(), 7973), 12);
                        if (bitArray4.getSize() == 18) {
                            int i16 = 17;
                            for (int i17 = 0; i17 < 6; i17++) {
                                for (int i18 = 0; i18 < 3; i18++) {
                                    boolean z3 = bitArray4.get(i16);
                                    i16--;
                                    byteMatrix.set(i17, (byteMatrix.getHeight() - 11) + i18, z3);
                                    byteMatrix.set((byteMatrix.getHeight() - 11) + i18, i17, z3);
                                }
                            }
                        } else {
                            throw new WriterException("should not happen but we got: " + bitArray4.getSize());
                        }
                    }
                    int width = byteMatrix.getWidth() - 1;
                    int height = byteMatrix.getHeight() - 1;
                    int i19 = 0;
                    int i20 = -1;
                    while (width > 0) {
                        if (width == 6) {
                            width--;
                        }
                        while (height >= 0 && height < byteMatrix.getHeight()) {
                            for (int i21 = 0; i21 < 2; i21++) {
                                int i22 = width - i21;
                                if (g(byteMatrix.get(i22, height))) {
                                    if (i19 < bitArray.getSize()) {
                                        z = bitArray.get(i19);
                                        i19++;
                                    } else {
                                        z = false;
                                    }
                                    if (i != -1) {
                                        switch (i) {
                                            case 0:
                                                i3 = height + i22;
                                                i2 = i3 & 1;
                                                break;
                                            case 1:
                                                i3 = height;
                                                i2 = i3 & 1;
                                                break;
                                            case 2:
                                                i2 = i22 % 3;
                                                break;
                                            case 3:
                                                i2 = (height + i22) % 3;
                                                break;
                                            case 4:
                                                i3 = (i22 / 3) + (height / 2);
                                                i2 = i3 & 1;
                                                break;
                                            case 5:
                                                int i23 = height * i22;
                                                i2 = (i23 % 3) + (i23 & 1);
                                                break;
                                            case 6:
                                                int i24 = height * i22;
                                                i4 = i24 & 1;
                                                i5 = i24 % 3;
                                                i3 = i5 + i4;
                                                i2 = i3 & 1;
                                                break;
                                            case 7:
                                                i5 = (height * i22) % 3;
                                                i4 = (height + i22) & 1;
                                                i3 = i5 + i4;
                                                i2 = i3 & 1;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
                                        }
                                        if (i2 == 0) {
                                            z = !z;
                                        }
                                    }
                                    byteMatrix.set(i22, height, z);
                                }
                            }
                            height += i20;
                        }
                        i20 = -i20;
                        height += i20;
                        width -= 2;
                    }
                    if (i19 != bitArray.getSize()) {
                        throw new WriterException("Not all bits consumed: " + i19 + '/' + bitArray.getSize());
                    }
                    return;
                }
                throw new WriterException("should not happen but we got: " + bitArray2.getSize());
            }
            throw new WriterException("Invalid mask pattern");
        }
        throw new WriterException();
    }

    public static int b(int i, int i2) {
        if (i2 != 0) {
            int f = f(i2);
            int i3 = i << (f - 1);
            while (f(i3) >= f) {
                i3 ^= i2 << (f(i3) - f);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void c(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (g(byteMatrix.get(i4, i2))) {
                byteMatrix.set(i4, i2, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    public static void d(int i, int i2, ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.set(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void e(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (g(byteMatrix.get(i, i4))) {
                byteMatrix.set(i, i4, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    public static int f(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean g(int i) {
        return i == -1;
    }
}
