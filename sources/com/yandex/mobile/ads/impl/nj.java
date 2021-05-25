package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.nativeads.NativeAdUnit;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
public interface nj {
    void a(@NonNull AdRequestError adRequestError);

    void a(@NonNull NativeAdUnit nativeAdUnit);

    void a(@NonNull NativeGenericAd nativeGenericAd);
}
