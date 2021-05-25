package com.sumsub.sns.core.common;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/common/FastBlur;", "", "Landroid/graphics/Bitmap;", "sentBitmap", "", "radius", "", "canReuseInBitmap", "doBlur", "(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class FastBlur {
    @NotNull
    public static final FastBlur INSTANCE = new FastBlur();

    @Nullable
    public final Bitmap doBlur(@NotNull Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        Bitmap bitmap2 = bitmap;
        int i2 = i;
        Intrinsics.checkNotNullParameter(bitmap2, "sentBitmap");
        if (!z) {
            bitmap2 = bitmap2.copy(bitmap.getConfig(), true);
            Intrinsics.checkNotNullExpressionValue(bitmap2, "sentBitmap.copy(sentBitmap.config, true)");
        }
        if (i2 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = new int[i6][];
        for (int i11 = 0; i11 < i6; i11++) {
            iArr8[i11] = new int[3];
        }
        int i12 = i2 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = iArr2[Math.min(i4, Math.max(i24, 0)) + i14];
                int[] iArr9 = iArr8[i24 + i2];
                iArr9[0] = (i26 & 16711680) >> 16;
                iArr9[1] = (i26 & 65280) >> 8;
                iArr9[2] = i26 & 255;
                int abs = i12 - Math.abs(i24);
                i25 = (iArr9[0] * abs) + i25;
                i16 = (iArr9[1] * abs) + i16;
                i17 = (iArr9[2] * abs) + i17;
                if (i24 > 0) {
                    i21 += iArr9[0];
                    i22 += iArr9[1];
                    i23 += iArr9[2];
                } else {
                    i18 += iArr9[0];
                    i19 += iArr9[1];
                    i20 += iArr9[2];
                }
                i24++;
                i5 = i5;
                iArr6 = iArr6;
            }
            int i27 = i25;
            int i28 = i2;
            int i29 = 0;
            while (i29 < width) {
                iArr3[i14] = iArr7[i27];
                iArr4[i14] = iArr7[i16];
                iArr5[i14] = iArr7[i17];
                int i30 = i27 - i18;
                int i31 = i16 - i19;
                int i32 = i17 - i20;
                int[] iArr10 = iArr8[((i28 - i2) + i6) % i6];
                int i33 = i18 - iArr10[0];
                int i34 = i19 - iArr10[1];
                int i35 = i20 - iArr10[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr6[i29] = Math.min(i29 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i36 = iArr2[i15 + iArr6[i29]];
                iArr10[0] = (i36 & 16711680) >> 16;
                iArr10[1] = (i36 & 65280) >> 8;
                iArr10[2] = i36 & 255;
                int i37 = i21 + iArr10[0];
                int i38 = i22 + iArr10[1];
                int i39 = i23 + iArr10[2];
                i27 = i30 + i37;
                i16 = i31 + i38;
                i17 = i32 + i39;
                i28 = (i28 + 1) % i6;
                int[] iArr11 = iArr8[i28 % i6];
                i18 = i33 + iArr11[0];
                i19 = i34 + iArr11[1];
                i20 = i35 + iArr11[2];
                i21 = i37 - iArr11[0];
                i22 = i38 - iArr11[1];
                i23 = i39 - iArr11[2];
                i14++;
                i29++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            bitmap2 = bitmap2;
            height = height;
            i5 = i5;
            iArr6 = iArr6;
        }
        int i40 = i5;
        int i41 = height;
        int i42 = 0;
        while (i42 < width) {
            int i43 = -i2;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = i43;
            int i52 = i43 * width;
            int i53 = 0;
            int i54 = 0;
            while (i51 <= i2) {
                int max = Math.max(0, i52) + i42;
                int[] iArr12 = iArr8[i51 + i2];
                iArr12[0] = iArr3[max];
                iArr12[1] = iArr4[max];
                iArr12[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i51);
                i53 = (iArr3[max] * abs2) + i53;
                i54 = (iArr4[max] * abs2) + i54;
                i44 = (iArr5[max] * abs2) + i44;
                if (i51 > 0) {
                    i48 += iArr12[0];
                    i49 += iArr12[1];
                    i50 += iArr12[2];
                } else {
                    i45 += iArr12[0];
                    i46 += iArr12[1];
                    i47 += iArr12[2];
                }
                if (i51 < i40) {
                    i52 += width;
                }
                i51++;
                i40 = i40;
                width = width;
            }
            int i55 = i2;
            int i56 = i42;
            int i57 = 0;
            while (i57 < i41) {
                iArr2[i56] = (iArr2[i56] & ViewCompat.MEASURED_STATE_MASK) | (iArr7[i53] << 16) | (iArr7[i54] << 8) | iArr7[i44];
                int i58 = i53 - i45;
                int i59 = i54 - i46;
                int i60 = i44 - i47;
                int[] iArr13 = iArr8[((i55 - i2) + i6) % i6];
                int i61 = i45 - iArr13[0];
                int i62 = i46 - iArr13[1];
                int i63 = i47 - iArr13[2];
                if (i42 == 0) {
                    iArr6[i57] = Math.min(i57 + i12, i40) * width;
                }
                int i64 = iArr6[i57] + i42;
                iArr13[0] = iArr3[i64];
                iArr13[1] = iArr4[i64];
                iArr13[2] = iArr5[i64];
                int i65 = i48 + iArr13[0];
                int i66 = i49 + iArr13[1];
                int i67 = i50 + iArr13[2];
                i53 = i58 + i65;
                i54 = i59 + i66;
                i44 = i60 + i67;
                i55 = (i55 + 1) % i6;
                int[] iArr14 = iArr8[i55];
                i45 = i61 + iArr14[0];
                i46 = i62 + iArr14[1];
                i47 = i63 + iArr14[2];
                i48 = i65 - iArr14[0];
                i49 = i66 - iArr14[1];
                i50 = i67 - iArr14[2];
                i56 += width;
                i57++;
                i2 = i;
            }
            i42++;
            i2 = i;
            i40 = i40;
            i41 = i41;
            i6 = i6;
            iArr2 = iArr2;
            width = width;
        }
        bitmap2.setPixels(iArr2, 0, width, 0, 0, width, i41);
        return bitmap2;
    }
}
