package com.avito.security;

import a2.b.a.a.a;
import java.util.Arrays;
public class j1 {
    private j1() {
    }

    private static String a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        StringBuilder W = a.W("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
        W.append(str);
        return W.toString();
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, j1.class.getName());
    }

    public static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void a() {
        throw ((NullPointerException) a(new NullPointerException()));
    }

    public static void a(Object obj) {
        if (obj == null) {
            a();
            throw null;
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) a(new NullPointerException(a.c3(str, " must not be null"))));
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            b(str);
            throw null;
        }
    }

    private static void b(String str) {
        throw ((NullPointerException) a(new NullPointerException(a(str))));
    }
}
