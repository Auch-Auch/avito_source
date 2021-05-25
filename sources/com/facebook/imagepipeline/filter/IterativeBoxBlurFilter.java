package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
public abstract class IterativeBoxBlurFilter {
    public static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static void b(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = i2 + 1;
        int i4 = i3 + i2;
        int[] iArr2 = new int[(i4 * 256)];
        for (int i5 = 1; i5 <= 255; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                iArr2[i3] = i5;
                i3++;
            }
        }
        int[] iArr3 = new int[Math.max(width, height)];
        int i7 = i;
        int i8 = 0;
        while (i8 < i7) {
            int i9 = 0;
            while (i9 < height) {
                int i10 = width * i9;
                i9++;
                int i11 = (i9 * width) - 1;
                int i12 = i4 >> 1;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                for (int i17 = -i12; i17 < width + i12; i17++) {
                    int i18 = iArr[a(i10 + i17, i10, i11)];
                    i13 += (i18 >> 16) & 255;
                    i14 += (i18 >> 8) & 255;
                    i15 += i18 & 255;
                    i16 += i18 >>> 24;
                    if (i17 >= i12) {
                        iArr3[i17 - i12] = (iArr2[i16] << 24) | (iArr2[i13] << 16) | (iArr2[i14] << 8) | iArr2[i15];
                        int i19 = iArr[a((i17 - (i4 - 1)) + i10, i10, i11)];
                        i13 -= (i19 >> 16) & 255;
                        i14 -= (i19 >> 8) & 255;
                        i15 -= i19 & 255;
                        i16 -= i19 >>> 24;
                    }
                }
                System.arraycopy(iArr3, 0, iArr, i10, width);
            }
            int i20 = 0;
            while (i20 < width) {
                int i21 = ((height - 1) * width) + i20;
                int i22 = (i4 >> 1) * width;
                int i23 = (i4 - 1) * width;
                int i24 = i20 - i22;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                while (i24 <= i21 + i22) {
                    int i30 = iArr[a(i24, i20, i21)];
                    i25 += (i30 >> 16) & 255;
                    i26 += (i30 >> 8) & 255;
                    i27 += i30 & 255;
                    i28 += i30 >>> 24;
                    if (i24 - i22 >= i20) {
                        iArr3[i29] = (iArr2[i28] << 24) | (iArr2[i25] << 16) | (iArr2[i26] << 8) | iArr2[i27];
                        i29++;
                        int i31 = iArr[a(i24 - i23, i20, i21)];
                        i25 -= (i31 >> 16) & 255;
                        i26 -= (i31 >> 8) & 255;
                        i27 -= i31 & 255;
                        i28 -= i31 >>> 24;
                    }
                    i24 += width;
                    i4 = i4;
                }
                int i32 = i20;
                for (int i33 = 0; i33 < height; i33++) {
                    iArr[i32] = iArr3[i33];
                    i32 += width;
                }
                i20++;
                i4 = i4;
            }
            i8++;
            i7 = i;
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    public static void boxBlurBitmapInPlace(Bitmap bitmap, int i, int i2) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkArgument(bitmap.isMutable());
        Preconditions.checkArgument(((float) bitmap.getHeight()) <= 2048.0f);
        Preconditions.checkArgument(((float) bitmap.getWidth()) <= 2048.0f);
        Preconditions.checkArgument(i2 > 0 && i2 <= 25);
        Preconditions.checkArgument(i > 0);
        try {
            b(bitmap, i, i2);
        } catch (OutOfMemoryError e) {
            FLog.e("IterativeBoxBlurFilter", String.format(null, "OOM: %d iterations on %dx%d with %d radius", Integer.valueOf(i), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2)));
            throw e;
        }
    }
}
