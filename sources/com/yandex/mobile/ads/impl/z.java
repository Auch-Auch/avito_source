package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import com.yandex.metrica.YandexMetrica;
public final class z {
    @Nullable
    public static String a() {
        try {
            return YandexMetrica.getLibraryVersion();
        } catch (Exception unused) {
            return null;
        }
    }
}
