package com.yandex.mobile.ads.video;

import android.support.annotation.Nullable;
public interface VmapError {
    int getCode();

    @Nullable
    String getDescription();
}
