package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
@KeepForSdk
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @RecentlyNonNull
    @KeepForSdk
    public static int getClientVersion(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo zzb = zzb(context, str);
        if (zzb == null || (applicationInfo = zzb.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isPackageSide() {
        return false;
    }

    @RecentlyNonNull
    public static boolean zza(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((Wrappers.packageManager(context).getApplicationInfo(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @Nullable
    private static PackageInfo zzb(Context context, String str) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
