package eu.davidea.flexibleadapter.utils;

import android.util.Log;
public class Logger {
    public String a;

    public Logger(String str) {
        this.a = str;
        Log.useTag(null);
    }

    public void d(String str, Object... objArr) {
        if (Log.isDebugEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void e(String str, Object... objArr) {
        if (Log.isErrorEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void i(String str, Object... objArr) {
        if (Log.isInfoEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void v(String str, Object... objArr) {
        if (Log.isVerboseEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void w(String str, Object... objArr) {
        if (Log.isWarnEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void wtf(String str, Object... objArr) {
        if (Log.isErrorEnabled()) {
            Log.wtf(this.a, Log.a(str, objArr));
        }
    }

    public void e(Throwable th, String str, Object... objArr) {
        if (Log.isErrorEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void w(Throwable th, String str, Object... objArr) {
        if (Log.isWarnEnabled()) {
            Log.a(str, objArr);
        }
    }

    public void wtf(Throwable th, String str, Object... objArr) {
        if (Log.isErrorEnabled()) {
            Log.wtf(this.a, Log.a(str, objArr), th);
        }
    }
}
