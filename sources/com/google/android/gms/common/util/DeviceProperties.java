package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public final class DeviceProperties {
    @Nullable
    private static Boolean zza;
    @Nullable
    private static Boolean zzb;
    @Nullable
    private static Boolean zzc;
    @Nullable
    private static Boolean zzd;
    @Nullable
    private static Boolean zze;
    @Nullable
    private static Boolean zzf;
    @Nullable
    private static Boolean zzg;
    @Nullable
    private static Boolean zzh;

    private DeviceProperties() {
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAuto(@RecentlyNonNull Context context) {
        return isAuto(context.getPackageManager());
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static boolean isFeaturePhone(@RecentlyNonNull Context context) {
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isLatchsky(@RecentlyNonNull Context context) {
        if (zze == null) {
            PackageManager packageManager = context.getPackageManager();
            zze = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return zze.booleanValue();
    }

    @RecentlyNonNull
    @KeepForSdk
    @TargetApi(21)
    public static boolean isSidewinder(@RecentlyNonNull Context context) {
        return zzb(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (com.google.android.gms.common.util.DeviceProperties.zzb.booleanValue() != false) goto L_0x003e;
     */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTablet(@androidx.annotation.RecentlyNonNull android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Boolean r1 = com.google.android.gms.common.util.DeviceProperties.zza
            if (r1 != 0) goto L_0x0045
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 != 0) goto L_0x003e
            java.lang.Boolean r1 = com.google.android.gms.common.util.DeviceProperties.zzb
            if (r1 != 0) goto L_0x0036
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L_0x002f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.common.util.DeviceProperties.zzb = r4
        L_0x0036:
            java.lang.Boolean r4 = com.google.android.gms.common.util.DeviceProperties.zzb
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x003f
        L_0x003e:
            r0 = 1
        L_0x003f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zza = r4
        L_0x0045:
            java.lang.Boolean r4 = com.google.android.gms.common.util.DeviceProperties.zza
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isTv(@RecentlyNonNull Context context) {
        return isTv(context.getPackageManager());
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }

    @RecentlyNonNull
    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(@RecentlyNonNull Context context) {
        return isWearable(context.getPackageManager());
    }

    @RecentlyNonNull
    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(@RecentlyNonNull Context context) {
        if (!isWearable(context)) {
            return false;
        }
        if (PlatformVersion.isAtLeastN()) {
            return zzb(context) && !PlatformVersion.isAtLeastO();
        }
        return true;
    }

    @RecentlyNonNull
    public static boolean zza(@RecentlyNonNull Context context) {
        if (zzf == null) {
            zzf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzf.booleanValue();
    }

    @TargetApi(21)
    private static boolean zzb(Context context) {
        if (zzd == null) {
            zzd = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzd.booleanValue();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isAuto(@RecentlyNonNull PackageManager packageManager) {
        if (zzg == null) {
            zzg = Boolean.valueOf(PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return zzg.booleanValue();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isTv(@RecentlyNonNull PackageManager packageManager) {
        if (zzh == null) {
            zzh = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return zzh.booleanValue();
    }

    @RecentlyNonNull
    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(@RecentlyNonNull PackageManager packageManager) {
        if (zzc == null) {
            zzc = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return zzc.booleanValue();
    }
}
