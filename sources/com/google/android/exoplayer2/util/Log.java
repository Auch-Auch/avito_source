package com.google.android.exoplayer2.util;

import a2.b.a.a.a;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    public static int a = 0;
    public static boolean b = true;

    public static String a(String str, @Nullable Throwable th) {
        String throwableString = getThrowableString(th);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        StringBuilder Q = a.Q(str, "\n  ");
        Q.append(throwableString.replace("\n", "\n  "));
        Q.append('\n');
        return Q.toString();
    }

    public static void d(String str, String str2) {
        int i = a;
    }

    public static void e(String str, String str2) {
        int i = a;
    }

    public static int getLogLevel() {
        return a;
    }

    @Nullable
    public static String getThrowableString(@Nullable Throwable th) {
        boolean z;
        if (th == null) {
            return null;
        }
        Throwable th2 = th;
        while (true) {
            if (th2 == null) {
                z = false;
                break;
            } else if (th2 instanceof UnknownHostException) {
                z = true;
                break;
            } else {
                th2 = th2.getCause();
            }
        }
        if (z) {
            return "UnknownHostException (no network)";
        }
        if (!b) {
            return th.getMessage();
        }
        return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    public static void i(String str, String str2) {
        int i = a;
    }

    public static void setLogLevel(int i) {
        a = i;
    }

    public static void setLogStackTraces(boolean z) {
        b = z;
    }

    public static void w(String str, String str2) {
        int i = a;
    }

    public boolean getLogStackTraces() {
        return b;
    }

    public static void d(String str, String str2, @Nullable Throwable th) {
        d(str, a(str2, th));
    }

    public static void e(String str, String str2, @Nullable Throwable th) {
        e(str, a(str2, th));
    }

    public static void i(String str, String str2, @Nullable Throwable th) {
        i(str, a(str2, th));
    }

    public static void w(String str, String str2, @Nullable Throwable th) {
        w(str, a(str2, th));
    }
}
