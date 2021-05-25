package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.common.util.VisibleForTesting;
@VisibleForTesting
@Deprecated
public final class zzch {
    private static volatile Logger zzabk = new zzbr();

    @VisibleForTesting
    public static Logger getLogger() {
        return zzabk;
    }

    private static boolean isLoggable(int i) {
        if (zzabk == null || zzabk.getLogLevel() > i) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    public static void setLogger(Logger logger) {
        zzabk = logger;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzab(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzq(str);
        } else if (isLoggable(0)) {
            zzby.zzzb.get();
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzac(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzt(str);
        } else if (isLoggable(2)) {
            zzby.zzzb.get();
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.warn(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzf(String str, Object obj) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zze(str, obj);
        } else if (isLoggable(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                String.valueOf(str).length();
                valueOf.length();
            }
            zzby.zzzb.get();
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.error(str);
        }
    }
}
