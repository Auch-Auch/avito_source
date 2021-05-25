package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeAdViewBinder;
public interface MediatedNativeAd {
    void bindNativeAd(@NonNull NativeAdViewBinder nativeAdViewBinder);

    void destroy();

    @NonNull
    MediatedNativeAdAssets getMediatedNativeAdAssets();

    void unbindNativeAd(@NonNull NativeAdViewBinder nativeAdViewBinder);
}
