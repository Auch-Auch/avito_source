package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.metrica.YandexMetrica;
public final class ar {
    public static boolean a() {
        return a(YandexMetrica.getLibraryVersion(), "2.40");
    }

    public static boolean b() {
        return a(YandexMetrica.getLibraryVersion(), "3.13.1");
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        return new as(str).compareTo(new as(str2)) >= 0;
    }
}
