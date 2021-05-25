package eu.davidea.flexibleadapter.utils;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class Log {
    public static int a = 10;
    public static boolean b;
    public static boolean c;
    public static String customTag;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
        public static final int DEBUG = 3;
        public static final int ERROR = 6;
        public static final int INFO = 4;
        public static final int SUPPRESS = 10;
        public static final int VERBOSE = 2;
        public static final int WARN = 5;
    }

    public static String a(String str, Object... objArr) {
        if (objArr == null || objArr.length != 0) {
            str = String.format(str, objArr);
        }
        if (!b) {
            return str;
        }
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[3];
        if (c) {
            return String.format("[%s:%s] %s", stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()), str);
        }
        return String.format("[%s] %s", stackTraceElement.getMethodName(), str);
    }

    public static String b() {
        String str = customTag;
        if (str != null) {
            return str;
        }
        String fileName = new Throwable().getStackTrace()[2].getFileName();
        if (fileName == null) {
            return "SourceFile";
        }
        return fileName.split("[.]")[0];
    }

    public static void d(String str, Object... objArr) {
        if (isDebugEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        if (isErrorEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void i(String str, Object... objArr) {
        if (isInfoEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void iTag(String str, String str2, Object... objArr) {
        if (isInfoEnabled()) {
            a(str2, objArr);
        }
    }

    public static boolean isDebugEnabled() {
        return a <= 3;
    }

    public static boolean isErrorEnabled() {
        return a <= 6;
    }

    public static boolean isInfoEnabled() {
        return a <= 4;
    }

    public static boolean isVerboseEnabled() {
        return a <= 2;
    }

    public static boolean isWarnEnabled() {
        return a <= 5;
    }

    public static void logMethodName(boolean z, boolean z2) {
        b = z;
        c = z2;
    }

    public static void setLevel(int i) {
        a = i;
    }

    public static void useTag(@Nullable String str) {
        customTag = str;
    }

    public static void v(String str, Object... objArr) {
        if (isVerboseEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (isWarnEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        if (isErrorEnabled()) {
            android.util.Log.wtf(b(), a(str, objArr));
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        if (isErrorEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void w(Throwable th, String str, Object... objArr) {
        if (isWarnEnabled()) {
            b();
            a(str, objArr);
        }
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        if (isErrorEnabled()) {
            android.util.Log.wtf(b(), a(str, objArr), th);
        }
    }
}
