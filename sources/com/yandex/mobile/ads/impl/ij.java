package com.yandex.mobile.ads.impl;

import java.util.Locale;
public final class ij extends ii {
    private static boolean a;

    public static void a(boolean z) {
        a = z;
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            String.format(Locale.US, str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (a) {
            String.format(Locale.US, str, objArr);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a) {
            String.format(Locale.US, str, objArr);
        }
    }
}
