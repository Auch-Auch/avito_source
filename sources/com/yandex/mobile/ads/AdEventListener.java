package com.yandex.mobile.ads;

import android.support.annotation.NonNull;
public interface AdEventListener {

    public static class SimpleAdEventListener implements AdEventListener {
        @Override // com.yandex.mobile.ads.AdEventListener
        public void onAdClosed() {
        }

        @Override // com.yandex.mobile.ads.AdEventListener
        public void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        }

        @Override // com.yandex.mobile.ads.AdEventListener
        public void onAdLeftApplication() {
        }

        @Override // com.yandex.mobile.ads.AdEventListener
        public void onAdLoaded() {
        }

        @Override // com.yandex.mobile.ads.AdEventListener
        public void onAdOpened() {
        }
    }

    void onAdClosed();

    void onAdFailedToLoad(@NonNull AdRequestError adRequestError);

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();
}
