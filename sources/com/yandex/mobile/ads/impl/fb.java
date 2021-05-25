package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public enum fb {
    AD_VIDEO_COMPLETE("advideocomplete"),
    IMPRESSION_TRACKING_START("impressionTrackingStart"),
    IMPRESSION_TRACKING_SUCCESS("impressionTrackingSuccess"),
    CLOSE("close"),
    OPEN("open"),
    REWARDED_AD_COMPLETE("rewardedAdComplete"),
    USE_CUSTOM_CLOSE("usecustomclose"),
    UNSPECIFIED("");
    
    @NonNull
    private final String i;

    private fb(String str) {
        this.i = str;
    }

    public static fb a(@NonNull String str) {
        fb[] values = values();
        for (int i2 = 0; i2 < 8; i2++) {
            fb fbVar = values[i2];
            if (fbVar.i.equals(str)) {
                return fbVar;
            }
        }
        return UNSPECIFIED;
    }

    @NonNull
    public final String a() {
        return this.i;
    }
}
