package com.google.mlkit.vision.common.internal;

import a2.b.a.a.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.vision.common.InputImage;
@KeepForSdk
public class CommonConvertUtils {
    @KeepForSdk
    public static int convertToAndroidImageFormat(@InputImage.ImageFormat int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 35;
            if (i != 35) {
                i2 = InputImage.IMAGE_FORMAT_YV12;
                if (i != 842094169) {
                    return 0;
                }
            }
        }
        return i2;
    }

    @KeepForSdk
    public static int convertToMVRotation(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 90) {
            return 1;
        }
        if (i == 180) {
            return 2;
        }
        if (i == 270) {
            return 3;
        }
        throw new IllegalArgumentException(a.m2(29, "Invalid rotation: ", i));
    }
}
