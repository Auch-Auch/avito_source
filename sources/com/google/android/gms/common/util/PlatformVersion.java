package com.google.android.gms.common.util;

import android.os.Build;
import androidx.annotation.RecentlyNonNull;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.annotation.KeepForSdk;
@VisibleForTesting
@KeepForSdk
public final class PlatformVersion {
    private static Boolean zza;

    private PlatformVersion() {
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastJellyBean() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastKitKat() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastLollipop() {
        return true;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastLollipopMR1() {
        return Build.VERSION.SDK_INT >= 22;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAtLeastR() {
        boolean z = false;
        if (!isAtLeastQ()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.equals("REL")) {
            return true;
        }
        String str = Build.VERSION.CODENAME;
        if (!(str.length() == 1 && str.charAt(0) >= 'R' && str.charAt(0) <= 'Z')) {
            return false;
        }
        Boolean bool = zza;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if (Constants.REFERRER_API_GOOGLE.equals(Build.BRAND) && !Build.ID.startsWith("RPP1") && !Build.ID.startsWith("RPP2") && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 6301457) {
                z = true;
            }
            zza = Boolean.valueOf(z);
        } catch (NumberFormatException unused) {
            zza = Boolean.TRUE;
        }
        zza.booleanValue();
        return zza.booleanValue();
    }
}
