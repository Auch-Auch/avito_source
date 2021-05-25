package com.google.androidbrowserhelper.trusted;

import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
public class ChromeLegacyUtils {
    public static final List<String> a = Arrays.asList("com.google.android.apps.chrome", "org.chromium.chrome", "com.chrome.canary", "com.chrome.dev", "com.chrome.beta", "com.android.chrome");
    public static final List<String> b = Arrays.asList("com.chrome.beta", "com.android.chrome");
    public static final List<String> c = Arrays.asList("com.google.android.apps.chrome", "org.chromium.chrome");

    public static boolean a(PackageManager packageManager, String str, int i) {
        if (!c.contains(str) && b(packageManager, str) < i) {
            return false;
        }
        return true;
    }

    public static int b(PackageManager packageManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return (int) packageManager.getPackageInfo(str, 0).getLongVersionCode();
            }
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean supportsLaunchWithoutWarmup(PackageManager packageManager, String str) {
        if (!a.contains(str)) {
            return true;
        }
        return a(packageManager, str, 368300000);
    }

    public static boolean supportsManageSpaceWithoutWarmupAndValidation(PackageManager packageManager, String str) {
        if (!a.contains(str)) {
            return false;
        }
        return a(packageManager, str, 389000000);
    }

    public static boolean supportsNavbarAndColorCustomization(PackageManager packageManager, String str) {
        if (!a.contains(str)) {
            return false;
        }
        return a(packageManager, str, 380900000);
    }

    public static boolean supportsTrustedWebActivities(PackageManager packageManager, String str) {
        if (!a.contains(str)) {
            return false;
        }
        return a(packageManager, str, 362600000);
    }

    public static boolean usesWhiteNavbar(String str) {
        return a.contains(str);
    }
}
