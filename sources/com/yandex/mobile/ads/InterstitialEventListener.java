package com.yandex.mobile.ads;
public interface InterstitialEventListener {

    public static class SimpleInterstitialEventListener implements InterstitialEventListener {
        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onAdClosed() {
        }

        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onAdLeftApplication() {
        }

        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onAdOpened() {
        }

        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onInterstitialDismissed() {
        }

        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onInterstitialFailedToLoad(AdRequestError adRequestError) {
        }

        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onInterstitialLoaded() {
        }

        @Override // com.yandex.mobile.ads.InterstitialEventListener
        public void onInterstitialShown() {
        }
    }

    void onAdClosed();

    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialDismissed();

    void onInterstitialFailedToLoad(AdRequestError adRequestError);

    void onInterstitialLoaded();

    void onInterstitialShown();
}
