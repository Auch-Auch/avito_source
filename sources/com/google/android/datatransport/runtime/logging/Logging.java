package com.google.android.datatransport.runtime.logging;

import a2.b.a.a.a;
public final class Logging {
    public static String a(String str) {
        return a.c3("TransportRuntime.", str);
    }

    public static void d(String str, String str2) {
        a(str);
    }

    public static void e(String str, String str2, Throwable th) {
        a(str);
    }

    public static void i(String str, String str2) {
        a(str);
    }

    public static void w(String str, String str2, Object obj) {
        a(str);
        String.format(str2, obj);
    }

    public static void d(String str, String str2, Object obj) {
        a(str);
        String.format(str2, obj);
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        a(str);
        String.format(str2, obj, obj2);
    }

    public static void d(String str, String str2, Object... objArr) {
        a(str);
        String.format(str2, objArr);
    }
}
