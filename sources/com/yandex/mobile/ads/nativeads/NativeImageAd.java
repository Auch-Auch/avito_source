package com.yandex.mobile.ads.nativeads;

import android.support.annotation.Nullable;
public interface NativeImageAd extends NativeGenericAd {
    void bindImageAd(@Nullable NativeImageAdView nativeImageAdView) throws NativeAdException;
}
