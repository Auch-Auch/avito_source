package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class zzaq {
    private static final String CLASS_NAME = zzaq.class.getName();
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static String TAG = "Volley";

    public static class zza {
        public static final boolean zzbw = zzaq.DEBUG;
        private final List<zzas> zzbx = new ArrayList();
        private boolean zzby = false;

        public final void finalize() throws Throwable {
            if (!this.zzby) {
                zzd("Request on the loose");
                zzaq.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public final synchronized void zza(String str, long j) {
            if (!this.zzby) {
                this.zzbx.add(new zzas(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public final synchronized void zzd(String str) {
            long j;
            this.zzby = true;
            if (this.zzbx.size() == 0) {
                j = 0;
            } else {
                long j2 = this.zzbx.get(0).time;
                List<zzas> list = this.zzbx;
                j = list.get(list.size() - 1).time - j2;
            }
            if (j > 0) {
                long j3 = this.zzbx.get(0).time;
                zzaq.d("(%-4d ms) %s", Long.valueOf(j), str);
                for (zzas zzas : this.zzbx) {
                    long j4 = zzas.time;
                    zzaq.d("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(zzas.zzbz), zzas.name);
                    j3 = j4;
                }
            }
        }
    }

    public static void d(String str, Object... objArr) {
        zza(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        zza(str, objArr);
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            zza(str, objArr);
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        zza(str, objArr);
    }

    private static String zza(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                str2 = a.s2(a.q0(methodName, a.q0(substring2, 1)), substring2, ".", methodName);
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
