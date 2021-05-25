package com.google.firebase.crashlytics.internal;

import android.util.Log;
public class Logger {
    public static final String TAG = "FirebaseCrashlytics";
    public static final Logger c = new Logger(TAG);
    public final String a;
    public int b = 4;

    public Logger(String str) {
        this.a = str;
    }

    public static Logger getLogger() {
        return c;
    }

    public final boolean a(int i) {
        return this.b <= i || Log.isLoggable(this.a, i);
    }

    public void d(String str, Throwable th) {
        a(3);
    }

    public void e(String str, Throwable th) {
        a(6);
    }

    public void i(String str, Throwable th) {
        a(4);
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    public void v(String str, Throwable th) {
        a(2);
    }

    public void w(String str, Throwable th) {
        a(5);
    }

    public void d(String str) {
        d(str, null);
    }

    public void e(String str) {
        e(str, null);
    }

    public void i(String str) {
        i(str, null);
    }

    public void log(int i, String str, boolean z) {
        if (z || a(i)) {
            Log.println(i, this.a, str);
        }
    }

    public void v(String str) {
        v(str, null);
    }

    public void w(String str) {
        w(str, null);
    }
}
