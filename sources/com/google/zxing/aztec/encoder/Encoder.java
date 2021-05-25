package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    public static final int[] a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static void a(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bitMatrix.set(i5, i4);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i4, i5);
                bitMatrix.set(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    public static BitArray b(BitArray bitArray, int i, int i2) {
        GenericGF genericGF;
        int size = bitArray.getSize() / i2;
        if (i2 == 4) {
            genericGF = GenericGF.AZTEC_PARAM;
        } else if (i2 == 6) {
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (i2 == 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (i2 == 10) {
            genericGF = GenericGF.AZTEC_DATA_10;
        } else if (i2 == 12) {
            genericGF = GenericGF.AZTEC_DATA_12;
        } else {
            throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
        }
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(genericGF);
        int i3 = i / i2;
        int[] iArr = new int[i3];
        int size2 = bitArray.getSize() / i2;
        for (int i4 = 0; i4 < size2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= bitArray.get((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        reedSolomonEncoder.encode(iArr, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i7 = 0; i7 < i3; i7++) {
            bitArray2.appendBits(iArr[i7], i2);
        }
        return bitArray2;
    }

    public static BitArray c(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
            } else {
                bitArray2.appendBits(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        BitArray bitArray;
        BitArray bitArray2;
        int i6;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int i8 = 11;
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i9 = 32;
        int i10 = 0;
        int i11 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            i3 = Math.abs(i2);
            if (z) {
                i9 = 4;
            }
            if (i3 <= i9) {
                i5 = ((z ? 88 : 112) + (i3 << 4)) * i3;
                i4 = a[i3];
                int i12 = i5 - (i5 % i4);
                bitArray = c(encode, i4);
                if (bitArray.getSize() + size > i12) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z && bitArray.getSize() > (i4 << 6)) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
        } else {
            BitArray bitArray3 = null;
            int i13 = 0;
            int i14 = 0;
            while (i13 <= i9) {
                boolean z2 = i13 <= 3;
                int i15 = z2 ? i13 + 1 : i13;
                int i16 = ((z2 ? 88 : 112) + (i15 << 4)) * i15;
                if (size2 <= i16) {
                    if (bitArray3 == null || i14 != a[i15]) {
                        i7 = a[i15];
                        bitArray3 = c(encode, i7);
                    } else {
                        i7 = i14;
                    }
                    int i17 = i16 - (i16 % i7);
                    if ((!z2 || bitArray3.getSize() <= (i7 << 6)) && bitArray3.getSize() + size <= i17) {
                        i4 = i7;
                        bitArray = bitArray3;
                        z = z2;
                        i3 = i15;
                        i5 = i16;
                    } else {
                        i14 = i7;
                    }
                }
                i13++;
                i9 = 32;
                i10 = 0;
                i11 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray b = b(bitArray, i5, i4);
        int size3 = bitArray.getSize() / i4;
        BitArray bitArray4 = new BitArray();
        int i18 = 2;
        if (z) {
            bitArray4.appendBits(i3 - 1, 2);
            bitArray4.appendBits(size3 - 1, 6);
            bitArray2 = b(bitArray4, 28, 4);
        } else {
            bitArray4.appendBits(i3 - 1, 5);
            bitArray4.appendBits(size3 - 1, 11);
            bitArray2 = b(bitArray4, 40, 4);
        }
        if (!z) {
            i8 = 14;
        }
        int i19 = i8 + (i3 << 2);
        int[] iArr = new int[i19];
        if (z) {
            for (int i20 = 0; i20 < i19; i20++) {
                iArr[i20] = i20;
            }
            i6 = i19;
        } else {
            int i21 = i19 / 2;
            i6 = (((i21 - 1) / 15) * 2) + i19 + 1;
            int i22 = i6 / 2;
            for (int i23 = 0; i23 < i21; i23++) {
                int i24 = (i23 / 15) + i23;
                iArr[(i21 - i23) - 1] = (i22 - i24) - 1;
                iArr[i21 + i23] = i24 + i22 + i11;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i25 = 0;
        int i26 = 0;
        while (i25 < i3) {
            int i27 = ((i3 - i25) << i18) + (z ? 9 : 12);
            while (i10 < i27) {
                int i28 = i10 << 1;
                int i29 = 0;
                while (i29 < i18) {
                    if (b.get(i26 + i28 + i29)) {
                        int i30 = i25 << 1;
                        bitMatrix.set(iArr[i30 + i29], iArr[i30 + i10]);
                    }
                    if (b.get((i27 << 1) + i26 + i28 + i29)) {
                        int i31 = i25 << 1;
                        bitMatrix.set(iArr[i31 + i10], iArr[((i19 - 1) - i31) - i29]);
                    }
                    if (b.get((i27 << 2) + i26 + i28 + i29)) {
                        int i32 = (i19 - 1) - (i25 << 1);
                        bitMatrix.set(iArr[i32 - i29], iArr[i32 - i10]);
                    }
                    if (b.get((i27 * 6) + i26 + i28 + i29)) {
                        int i33 = i25 << 1;
                        bitMatrix.set(iArr[((i19 - 1) - i33) - i10], iArr[i33 + i29]);
                    }
                    i29++;
                    i18 = 2;
                }
                i10++;
                i18 = 2;
            }
            i26 += i27 << 3;
            i25++;
            i18 = 2;
            i10 = 0;
        }
        int i34 = i6 / 2;
        int i35 = 0;
        if (z) {
            while (i35 < 7) {
                int i36 = (i34 - 3) + i35;
                if (bitArray2.get(i35)) {
                    bitMatrix.set(i36, i34 - 5);
                }
                if (bitArray2.get(i35 + 7)) {
                    bitMatrix.set(i34 + 5, i36);
                }
                if (bitArray2.get(20 - i35)) {
                    bitMatrix.set(i36, i34 + 5);
                }
                if (bitArray2.get(27 - i35)) {
                    bitMatrix.set(i34 - 5, i36);
                }
                i35++;
            }
        } else {
            while (i35 < 10) {
                int i37 = (i35 / 5) + (i34 - 5) + i35;
                if (bitArray2.get(i35)) {
                    bitMatrix.set(i37, i34 - 7);
                }
                if (bitArray2.get(i35 + 10)) {
                    bitMatrix.set(i34 + 7, i37);
                }
                if (bitArray2.get(29 - i35)) {
                    bitMatrix.set(i37, i34 + 7);
                }
                if (bitArray2.get(39 - i35)) {
                    bitMatrix.set(i34 - 7, i37);
                }
                i35++;
            }
        }
        if (z) {
            a(bitMatrix, i34, 5);
        } else {
            a(bitMatrix, i34, 7);
            int i38 = 0;
            int i39 = 0;
            while (i38 < (i19 / 2) - 1) {
                for (int i40 = i34 & 1; i40 < i6; i40 += 2) {
                    int i41 = i34 - i39;
                    bitMatrix.set(i41, i40);
                    int i42 = i34 + i39;
                    bitMatrix.set(i42, i40);
                    bitMatrix.set(i40, i41);
                    bitMatrix.set(i40, i42);
                }
                i38 += 15;
                i39 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i3);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
