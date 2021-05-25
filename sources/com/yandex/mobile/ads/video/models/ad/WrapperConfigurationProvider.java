package com.yandex.mobile.ads.video.models.ad;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tv;
public class WrapperConfigurationProvider {
    @NonNull
    private final VideoAd mWrapperAd;

    public WrapperConfigurationProvider(@NonNull VideoAd videoAd) {
        this.mWrapperAd = videoAd;
    }

    @Nullable
    public tv getWrapperConfiguration() {
        return this.mWrapperAd.getWrapperConfiguration();
    }
}
