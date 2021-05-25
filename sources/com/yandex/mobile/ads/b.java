package com.yandex.mobile.ads;

import com.facebook.internal.AnalyticsEvents;
public enum b {
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    REWARDED("rewarded"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    VASTVIDEO("vastvideo");
    
    private final String f;

    private b(String str) {
        this.f = str;
    }

    public final String a() {
        return this.f;
    }

    public static b a(String str) {
        b[] values = values();
        for (int i = 0; i < 5; i++) {
            b bVar = values[i];
            if (bVar.f.equals(str)) {
                return bVar;
            }
        }
        return null;
    }
}
