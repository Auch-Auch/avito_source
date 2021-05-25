package com.google.android.gms.internal.vision;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
public class zzas {
    @GuardedBy("DirectBootUtils.class")
    private static UserManager zzfm;
    private static volatile boolean zzfn = (!zzu());
    @GuardedBy("DirectBootUtils.class")
    private static boolean zzfo = false;

    private zzas() {
    }

    public static boolean isUserUnlocked(Context context) {
        return !zzu() || zzd(context);
    }

    @RequiresApi(24)
    @TargetApi(24)
    @GuardedBy("DirectBootUtils.class")
    private static boolean zzc(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (zzfm == null) {
                zzfm = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zzfm;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
                z = z2;
            } catch (NullPointerException unused) {
                zzfm = null;
                i++;
            }
        }
        if (z) {
            zzfm = null;
        }
        return z;
    }

    @RequiresApi(24)
    @TargetApi(24)
    private static boolean zzd(Context context) {
        if (zzfn) {
            return true;
        }
        synchronized (zzas.class) {
            if (zzfn) {
                return true;
            }
            boolean zzc = zzc(context);
            if (zzc) {
                zzfn = zzc;
            }
            return zzc;
        }
    }

    public static boolean zzu() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
