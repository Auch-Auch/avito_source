package com.yandex.mobile.ads.nativeads;

import android.support.annotation.Nullable;
public interface NativeContentAd extends NativeGenericAd {
    void bindContentAd(@Nullable NativeContentAdView nativeContentAdView) throws NativeAdException;
}
