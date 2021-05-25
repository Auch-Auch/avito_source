package com.facebook.internal;

import a2.b.a.a.a;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map;
public class Logger {
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    public static final HashMap<String, String> e = new HashMap<>();
    public final LoggingBehavior a;
    public final String b;
    public StringBuilder c;
    public int d = 3;

    public Logger(LoggingBehavior loggingBehavior, String str) {
        Validate.notNullOrEmpty(str, "tag");
        this.a = loggingBehavior;
        this.b = a.c3(LOG_TAG_BASE, str);
        this.c = new StringBuilder();
    }

    public static synchronized String a(String str) {
        synchronized (Logger.class) {
            for (Map.Entry<String, String> entry : e.entrySet()) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }

    public static void log(LoggingBehavior loggingBehavior, String str, String str2) {
        log(loggingBehavior, 3, str, str2);
    }

    public static synchronized void registerAccessToken(String str) {
        synchronized (Logger.class) {
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(str, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    public static synchronized void registerStringToReplace(String str, String str2) {
        synchronized (Logger.class) {
            e.put(str, str2);
        }
    }

    public void append(StringBuilder sb) {
        if (b()) {
            this.c.append((CharSequence) sb);
        }
    }

    public void appendKeyValue(String str, Object obj) {
        append("  %s:\t%s\n", str, obj);
    }

    public final boolean b() {
        return FacebookSdk.isLoggingBehaviorEnabled(this.a);
    }

    public String getContents() {
        return a(this.c.toString());
    }

    public int getPriority() {
        return this.d;
    }

    public void logString(String str) {
        log(this.a, this.d, this.b, str);
    }

    public void setPriority(int i) {
        Validate.oneOf(Integer.valueOf(i), "value", 7, 3, 6, 4, 2, 5);
        this.d = i;
    }

    public static void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, 3, str, String.format(str2, objArr));
        }
    }

    public void append(String str) {
        if (b()) {
            this.c.append(str);
        }
    }

    public static void log(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, i, str, String.format(str2, objArr));
        }
    }

    public void append(String str, Object... objArr) {
        if (b()) {
            this.c.append(String.format(str, objArr));
        }
    }

    public static void log(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            String a3 = a(str2);
            if (!str.startsWith(LOG_TAG_BASE)) {
                str = a.c3(LOG_TAG_BASE, str);
            }
            Log.println(i, str, a3);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    public void log() {
        logString(this.c.toString());
        this.c = new StringBuilder();
    }
}
