package com.yandex.mobile.ads.nativeads;

import android.support.annotation.Nullable;
public interface NativeAppInstallAd extends NativeGenericAd {
    void bindAppInstallAd(@Nullable NativeAppInstallAdView nativeAppInstallAdView) throws NativeAdException;
}
