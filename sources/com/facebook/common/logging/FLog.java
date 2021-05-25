package com.facebook.common.logging;
public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static LoggingDelegate a = FLogDefaultLoggingDelegate.getInstance();

    public static String a(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static void d(String str, String str2) {
        if (a.isLoggable(3)) {
            a.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (a.isLoggable(6)) {
            a.e(str, str2);
        }
    }

    public static int getMinimumLoggingLevel() {
        return a.getMinimumLoggingLevel();
    }

    public static void i(String str, String str2) {
        if (a.isLoggable(4)) {
            a.i(str, str2);
        }
    }

    public static boolean isLoggable(int i) {
        return a.isLoggable(i);
    }

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            a = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void setMinimumLoggingLevel(int i) {
        a.setMinimumLoggingLevel(i);
    }

    public static void v(String str, String str2) {
        if (a.isLoggable(2)) {
            a.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (a.isLoggable(5)) {
            a.w(str, str2);
        }
    }

    public static void wtf(String str, String str2) {
        if (a.isLoggable(6)) {
            a.wtf(str, str2);
        }
    }

    public static void d(String str, String str2, Object obj) {
        if (a.isLoggable(3)) {
            a.d(str, a(str2, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        if (a.isLoggable(6)) {
            a.e(cls.getSimpleName(), str);
        }
    }

    public static void i(String str, String str2, Object obj) {
        if (a.isLoggable(4)) {
            a.i(str, a(str2, obj));
        }
    }

    public static void v(String str, String str2, Object obj) {
        if (a.isLoggable(2)) {
            a.v(str, a(str2, obj));
        }
    }

    public static void w(Class<?> cls, String str) {
        if (a.isLoggable(5)) {
            a.w(cls.getSimpleName(), str);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (a.isLoggable(6)) {
            a.wtf(cls.getSimpleName(), str);
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        if (a.isLoggable(3)) {
            a.d(str, a(str2, obj, obj2));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2) {
        if (a.isLoggable(4)) {
            a.i(str, a(str2, obj, obj2));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        if (a.isLoggable(2)) {
            a.v(str, a(str2, obj, obj2));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (a.isLoggable(3)) {
            a.d(str, a(str2, obj, obj2, obj3));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (a.isLoggable(6)) {
            a.e(str, a(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (a.isLoggable(4)) {
            a.i(str, a(str2, obj, obj2, obj3));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (a.isLoggable(2)) {
            a.v(str, a(str2, obj, obj2, obj3));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (a.isLoggable(5)) {
            a.w(str, a(str2, objArr));
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (a.isLoggable(6)) {
            a.wtf(str, a(str2, objArr));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.isLoggable(3)) {
            a.d(str, a(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        if (a.isLoggable(6)) {
            a.e(str, a(str2, objArr), th);
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.isLoggable(4)) {
            a.i(str, a(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.isLoggable(2)) {
            a.v(str, a(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        if (a.isLoggable(5)) {
            a.w(str, a(str2, objArr), th);
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (a.isLoggable(6)) {
            a.wtf(str, a(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), str);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (a.isLoggable(6)) {
            a.e(cls.getSimpleName(), a(str, objArr));
        }
    }

    public static void i(Class<?> cls, String str) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), str);
        }
    }

    public static void v(Class<?> cls, String str) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), str);
        }
    }

    public static void w(Class<?> cls, String str, Object... objArr) {
        if (a.isLoggable(5)) {
            a.w(cls.getSimpleName(), a(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (a.isLoggable(6)) {
            a.wtf(cls.getSimpleName(), a(str, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object obj) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), a(str, obj));
        }
    }

    public static void e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (a.isLoggable(6)) {
            a.e(cls.getSimpleName(), a(str, objArr), th);
        }
    }

    public static void i(Class<?> cls, String str, Object obj) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), a(str, obj));
        }
    }

    public static void v(Class<?> cls, String str, Object obj) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), a(str, obj));
        }
    }

    public static void w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            w(cls, a(str, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (a.isLoggable(6)) {
            a.wtf(cls.getSimpleName(), a(str, objArr), th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (a.isLoggable(5)) {
            a.w(str, str2, th);
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), a(str, obj, obj2));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (a.isLoggable(6)) {
            a.e(str, str2, th);
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), a(str, obj, obj2));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), a(str, obj, obj2));
        }
    }

    public static void w(Class<?> cls, String str, Throwable th) {
        if (a.isLoggable(5)) {
            a.w(cls.getSimpleName(), str, th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (a.isLoggable(6)) {
            a.wtf(str, str2, th);
        }
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        if (a.isLoggable(6)) {
            a.e(cls.getSimpleName(), str, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (a.isLoggable(6)) {
            a.wtf(cls.getSimpleName(), str, th);
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), a(str, obj, obj2, obj3));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), a(str, obj, obj2, obj3));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            v(cls, a(str, obj, obj2, obj3));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), a(str, obj, obj2, obj3, obj4));
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), a(str, obj, obj2, obj3, obj4));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), a(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (a.isLoggable(2)) {
            a.v(str, a(str2, objArr));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (a.isLoggable(3)) {
            d(str, a(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (a.isLoggable(4)) {
            a.i(str, a(str2, objArr));
        }
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        if (a.isLoggable(2)) {
            a.v(str, a(str2, objArr), th);
        }
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        if (a.isLoggable(3)) {
            d(str, a(str2, objArr), th);
        }
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        if (a.isLoggable(4)) {
            a.i(str, a(str2, objArr), th);
        }
    }

    public static void v(Class<?> cls, String str, Object... objArr) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), a(str, objArr));
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), a(str, objArr));
        }
    }

    public static void i(Class<?> cls, String str, Object... objArr) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), a(str, objArr));
        }
    }

    public static void v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), a(str, objArr), th);
        }
    }

    public static void d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), a(str, objArr), th);
        }
    }

    public static void i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            a.i(cls.getSimpleName(), a(str, objArr), th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (a.isLoggable(2)) {
            a.v(str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (a.isLoggable(3)) {
            a.d(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (a.isLoggable(4)) {
            a.i(str, str2, th);
        }
    }

    public static void v(Class<?> cls, String str, Throwable th) {
        if (a.isLoggable(2)) {
            a.v(cls.getSimpleName(), str, th);
        }
    }

    public static void d(Class<?> cls, String str, Throwable th) {
        if (a.isLoggable(3)) {
            a.d(cls.getSimpleName(), str, th);
        }
    }

    public static void i(Class<?> cls, String str, Throwable th) {
        if (a.isLoggable(4)) {
            a.i(cls.getSimpleName(), str, th);
        }
    }
}
