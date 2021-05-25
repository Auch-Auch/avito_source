package com.github.pwittchen.reactivenetwork.library.rx2;

import android.os.Build;
public class Preconditions {
    public static void checkGreaterOrEqualToZero(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkGreaterThanZero(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkNotNullOrEmpty(String str, String str2) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static boolean isAtLeastAndroidLollipop() {
        return true;
    }

    public static boolean isAtLeastAndroidMarshmallow() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
