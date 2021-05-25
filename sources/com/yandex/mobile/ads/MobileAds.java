package com.yandex.mobile.ads;

import com.yandex.mobile.ads.impl.fy;
import com.yandex.mobile.ads.impl.ij;
public final class MobileAds {
    public static void enableDebugErrorIndicator(boolean z) {
        fy.a().a(z);
    }

    public static void enableLogging(boolean z) {
        ij.a(z);
    }

    public static String getLibraryVersion() {
        return "2.150";
    }

    public static void setUserConsent(boolean z) {
        fy.a().b(z);
    }
}
