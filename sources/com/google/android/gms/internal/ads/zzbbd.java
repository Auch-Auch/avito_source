package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.ads.AdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
public class zzbbd {
    public static boolean isLoggable(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void zzb(String str, Throwable th) {
        isLoggable(3);
    }

    public static void zzc(String str, Throwable th) {
        isLoggable(6);
    }

    public static void zzd(String str, Throwable th) {
        isLoggable(5);
    }

    public static void zze(String str, @Nullable Throwable th) {
        if (!isLoggable(5)) {
            return;
        }
        if (th != null) {
            zzd(zzff(str), th);
        } else {
            zzfe(zzff(str));
        }
    }

    public static void zzef(String str) {
        isLoggable(3);
    }

    public static void zzfc(String str) {
        isLoggable(6);
    }

    public static void zzfd(String str) {
        isLoggable(4);
    }

    public static void zzfe(String str) {
        isLoggable(5);
    }

    @VisibleForTesting
    private static String zzff(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zzfg(String str) {
        zze(str, null);
    }
}
