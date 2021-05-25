package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.widget.ImageView;
public final class pi {
    @NonNull
    public static String a(@NonNull String str) {
        return b(str, ImageView.ScaleType.CENTER_INSIDE);
    }

    @NonNull
    private static String b(@NonNull String str, @NonNull ImageView.ScaleType scaleType) {
        return "#S" + scaleType.ordinal() + str;
    }

    @NonNull
    public static String a(@NonNull String str, @NonNull ImageView.ScaleType scaleType) {
        return b(str, scaleType);
    }
}
