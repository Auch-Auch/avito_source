package com.yandex.mobile.ads.mediation.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
public interface MediatedNativeAdapterListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(@NonNull AdRequestError adRequestError);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdOpened();

    void onAppInstallAdLoaded(@NonNull MediatedNativeAd mediatedNativeAd);

    void onContentAdLoaded(@NonNull MediatedNativeAd mediatedNativeAd);
}
