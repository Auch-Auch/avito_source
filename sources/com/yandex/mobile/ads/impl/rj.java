package com.yandex.mobile.ads.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
public final class rj {
    public static ri a(@NonNull Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return new rk();
        }
        return new rm();
    }
}
