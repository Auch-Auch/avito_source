package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
public final class tm {
    public static void a(Object obj, String str) {
        if (obj == null) {
            c(str);
        }
    }

    public static Integer b(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static void c(String str) {
        throw new IllegalArgumentException(a.c3(str, " not set!"));
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            c(str2);
        }
    }

    public static Long a(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
            return Long.valueOf(simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse("00:00:00").getTime());
        } catch (ParseException unused) {
            return null;
        }
    }
}
