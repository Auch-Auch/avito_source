package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Locale;
public final class ih {
    @NonNull
    public static String a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase(Locale.US);
    }
}
