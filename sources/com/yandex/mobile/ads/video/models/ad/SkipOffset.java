package com.yandex.mobile.ads.video.models.ad;

import android.support.annotation.NonNull;
public class SkipOffset {
    @NonNull
    private final String mValue;

    private SkipOffset(@NonNull String str) {
        this.mValue = str;
    }

    @NonNull
    public String getRawValue() {
        return this.mValue;
    }
}
