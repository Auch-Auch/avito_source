package com.facebook.common.logging;

import a2.b.a.a.a;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
    public String a = "unknown";
    public int b = 5;

    public static FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    public final String a(String str) {
        return this.a != null ? a.u(new StringBuilder(), this.a, ":", str) : str;
    }

    public final void b(int i, String str, String str2) {
        Log.println(i, a(str), str2);
    }

    public final void c(int i, String str, String str2, Throwable th) {
        String str3;
        String a3 = a(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('\n');
        if (th == null) {
            str3 = "";
        } else {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            str3 = stringWriter.toString();
        }
        sb.append(str3);
        Log.println(i, a3, sb.toString());
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2) {
        b(3, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2) {
        b(6, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public int getMinimumLoggingLevel() {
        return this.b;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2) {
        b(4, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public boolean isLoggable(int i) {
        return this.b <= i;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void log(int i, String str, String str2) {
        Log.println(i, a(str), str2);
    }

    public void setApplicationTag(String str) {
        this.a = str;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void setMinimumLoggingLevel(int i) {
        this.b = i;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2) {
        b(2, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2) {
        b(5, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2) {
        b(6, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2, Throwable th) {
        c(3, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2, Throwable th) {
        c(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2, Throwable th) {
        c(4, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2, Throwable th) {
        c(2, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2, Throwable th) {
        c(5, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2, Throwable th) {
        c(6, str, str2, th);
    }
}
