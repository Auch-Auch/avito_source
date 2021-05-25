package com.voximplant.sdk.internal;

import com.voximplant.sdk.client.ILogListener;
import com.voximplant.sdk.client.LogLevel;
import com.voximplant.sdk.internal.Logger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
public class Logger {
    public static boolean a = false;
    public static ILogListener b;
    public static ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();

    public static synchronized void a(LogLevel logLevel, String str) {
        synchronized (Logger.class) {
            if (b != null) {
                c.execute(new Runnable(str) { // from class: a2.t.a.c.g0
                    public final /* synthetic */ String b;

                    {
                        this.b = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        LogLevel logLevel2 = LogLevel.this;
                        String str2 = this.b;
                        ILogListener iLogListener = Logger.b;
                        if (iLogListener != null) {
                            iLogListener.onLogMessage(logLevel2, str2);
                        }
                    }
                });
            }
        }
    }

    public static void d(String str) {
        boolean z = a;
        LogLevel logLevel = LogLevel.DEBUG;
        a(logLevel, "VOXSDK: " + str);
    }

    public static void e(String str) {
        boolean z = a;
        LogLevel logLevel = LogLevel.ERROR;
        a(logLevel, "VOXSDK: " + str);
    }

    public static void i(String str) {
        boolean z = a;
        LogLevel logLevel = LogLevel.INFO;
        a(logLevel, "VOXSDK: " + str);
    }

    public static synchronized void setLogListener(ILogListener iLogListener) {
        synchronized (Logger.class) {
            b = iLogListener;
        }
    }

    public static void v(String str) {
        boolean z = a;
        LogLevel logLevel = LogLevel.VERBOSE;
        a(logLevel, "VOXSDK: " + str);
    }

    public static void w(String str) {
        boolean z = a;
        LogLevel logLevel = LogLevel.WARNING;
        a(logLevel, "VOXSDK: " + str);
    }
}
