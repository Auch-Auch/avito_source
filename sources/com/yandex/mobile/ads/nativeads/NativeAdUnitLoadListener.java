package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
public interface NativeAdUnitLoadListener {
    void onNativeAdUnitFailedToLoad(@NonNull AdRequestError adRequestError);

    void onNativeAdUnitLoaded(@NonNull NativeAdUnit nativeAdUnit);
}
