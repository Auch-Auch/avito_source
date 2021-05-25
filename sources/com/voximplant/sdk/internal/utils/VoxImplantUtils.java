package com.voximplant.sdk.internal.utils;

import a2.b.a.a.a;
import android.os.Build;
import com.voximplant.sdk.internal.Logger;
public final class VoxImplantUtils {
    public static void assertIsTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static String getThreadInfo() {
        StringBuilder L = a.L("@[name=");
        L.append(Thread.currentThread().getName());
        L.append(", id=");
        L.append(Thread.currentThread().getId());
        L.append("]");
        return L.toString();
    }

    public static void logDeviceInfo() {
        StringBuilder L = a.L("Android SDK: ");
        L.append(Build.VERSION.SDK_INT);
        L.append(", Release: ");
        L.append(Build.VERSION.RELEASE);
        L.append(", Brand: ");
        L.append(Build.BRAND);
        L.append(", Device: ");
        L.append(Build.DEVICE);
        L.append(", Id: ");
        L.append(Build.ID);
        L.append(", Hardware: ");
        L.append(Build.HARDWARE);
        L.append(", Manufacturer: ");
        L.append(Build.MANUFACTURER);
        L.append(", Model: ");
        L.append(Build.MODEL);
        L.append(", Product: ");
        L.append(Build.PRODUCT);
        Logger.d(L.toString());
    }

    public static void logLargeString(String str) {
        if (str.length() > 3000) {
            Logger.i(str.substring(0, 3000));
            logLargeString(str.substring(3000));
            return;
        }
        Logger.i(str);
    }

    public static void logLargeStringDebug(String str) {
        if (str.length() > 3000) {
            Logger.d(str.substring(0, 3000));
            logLargeString(str.substring(3000));
            return;
        }
        Logger.d(str);
    }
}
