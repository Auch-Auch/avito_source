package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    public BitMatrix e;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        BitMatrix bitMatrix = this.e;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.e = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i5 = width >> 3;
            if ((width & 7) != 0) {
                i5++;
            }
            int i6 = height >> 3;
            if ((height & 7) != 0) {
                i6++;
            }
            int i7 = height - 8;
            int i8 = width - 8;
            int[] iArr = new int[2];
            iArr[1] = i5;
            int i9 = 0;
            iArr[0] = i6;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            int i10 = 0;
            while (true) {
                int i11 = 8;
                if (i10 >= i6) {
                    break;
                }
                int i12 = i10 << 3;
                if (i12 > i7) {
                    i12 = i7;
                }
                while (i9 < i5) {
                    int i13 = i9 << 3;
                    if (i13 > i8) {
                        i13 = i8;
                    }
                    int i14 = (i12 * width) + i13;
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    int i18 = 255;
                    while (i15 < i11) {
                        int i19 = i17;
                        int i20 = i18;
                        int i21 = 0;
                        while (i21 < i11) {
                            int i22 = matrix[i14 + i21] & 255;
                            i16 += i22;
                            i20 = i22 < i20 ? i22 : i20;
                            if (i22 > i19) {
                                i19 = i22;
                            }
                            i21++;
                            i15 = i15;
                            i11 = 8;
                        }
                        int i23 = i15;
                        int i24 = i20;
                        if (i19 - i24 > 24) {
                            while (true) {
                                i4 = i23 + 1;
                                i14 += width;
                                i2 = i24;
                                if (i4 >= 8) {
                                    break;
                                }
                                int i25 = 0;
                                for (int i26 = 8; i25 < i26; i26 = 8) {
                                    i16 += matrix[i14 + i25] & 255;
                                    i25++;
                                    i19 = i19;
                                }
                                i23 = i4;
                                i24 = i2;
                            }
                            i = i19;
                            i3 = i4;
                        } else {
                            i2 = i24;
                            i = i19;
                            i3 = i23;
                        }
                        i15 = i3 + 1;
                        i14 += width;
                        i11 = 8;
                        i18 = i2;
                        i17 = i;
                    }
                    int i27 = i16 >> 6;
                    if (i17 - i18 <= 24) {
                        i27 = i18 / 2;
                        if (i10 > 0 && i9 > 0) {
                            int i28 = i10 - 1;
                            int i29 = i9 - 1;
                            int i30 = (((iArr2[i10][i29] * 2) + iArr2[i28][i9]) + iArr2[i28][i29]) / 4;
                            if (i18 < i30) {
                                i27 = i30;
                            }
                        }
                    }
                    iArr2[i10][i9] = i27;
                    i9++;
                    i11 = 8;
                }
                i10++;
                i9 = 0;
            }
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            for (int i31 = 0; i31 < i6; i31++) {
                int i32 = i31 << 3;
                if (i32 > i7) {
                    i32 = i7;
                }
                int i33 = i6 - 3;
                if (i31 < 2) {
                    i33 = 2;
                } else if (i31 <= i33) {
                    i33 = i31;
                }
                int i34 = 0;
                while (i34 < i5) {
                    int i35 = i34 << 3;
                    if (i35 > i8) {
                        i35 = i8;
                    }
                    int i36 = i5 - 3;
                    if (i34 < 2) {
                        i36 = 2;
                    } else if (i34 <= i36) {
                        i36 = i34;
                    }
                    int i37 = -2;
                    int i38 = 0;
                    for (int i39 = 2; i37 <= i39; i39 = 2) {
                        int[] iArr3 = iArr2[i33 + i37];
                        i38 = iArr3[i36 - 2] + iArr3[i36 - 1] + iArr3[i36] + iArr3[i36 + 1] + iArr3[i36 + 2] + i38;
                        i37++;
                    }
                    int i40 = i38 / 25;
                    int i41 = (i32 * width) + i35;
                    int i42 = 8;
                    int i43 = 0;
                    while (i43 < i42) {
                        int i44 = 0;
                        while (i44 < i42) {
                            if ((matrix[i41 + i44] & 255) <= i40) {
                                bitMatrix2.set(i35 + i44, i32 + i43);
                            }
                            i44++;
                            matrix = matrix;
                            i42 = 8;
                        }
                        i43++;
                        i41 += width;
                        i7 = i7;
                        i42 = 8;
                    }
                    i34++;
                    i5 = i5;
                    i6 = i6;
                }
            }
            this.e = bitMatrix2;
        }
        return this.e;
    }
}
