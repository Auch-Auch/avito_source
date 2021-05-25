package com.yandex.mobile.ads.nativeads;

import android.support.annotation.Nullable;
import java.util.List;
public interface NativeAdUnit {
    void bindAdUnit(@Nullable NativeAdUnitView nativeAdUnitView) throws NativeAdException;

    List<? extends NativeGenericAd> getNativeAds();

    String getSponsored();

    void setAdEventListener(NativeAdEventListener nativeAdEventListener);

    void shouldOpenLinksInApp(boolean z);
}
