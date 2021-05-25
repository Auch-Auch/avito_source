package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class ef {
    @NonNull
    public static String a(@NonNull String str) {
        String trim = str.trim();
        return !trim.isEmpty() ? "yma_".concat(trim) : "";
    }
}
