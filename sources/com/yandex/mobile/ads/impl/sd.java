package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.util.Log;
import java.util.Locale;
public final class sd {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable("Volley", 2);

    private sd() {
    }

    public static void a(String str) {
        b("Changing log tag to %s", str);
        a = str;
        b = Log.isLoggable(str, 2);
    }

    public static void b(String str, Object... objArr) {
        d(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        d(str, objArr);
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(sd.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder Q = a.Q(substring.substring(substring.lastIndexOf(36) + 1), ".");
                Q.append(stackTrace[i].getMethodName());
                str2 = Q.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            d(str, objArr);
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        d(str, objArr);
    }
}
