package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.VideoAdRequest;
public final class uc {
    @NonNull
    public static ub a(@NonNull VideoAdRequest videoAdRequest) {
        return new ub(videoAdRequest, new vm(videoAdRequest));
    }
}
