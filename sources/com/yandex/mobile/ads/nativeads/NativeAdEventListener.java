package com.yandex.mobile.ads.nativeads;
public interface NativeAdEventListener {

    public static class SimpleNativeAdEventListener implements NativeAdEventListener {
        @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener
        public void onAdClosed() {
        }

        @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener
        public void onAdLeftApplication() {
        }

        @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener
        public void onAdOpened() {
        }
    }

    void onAdClosed();

    void onAdLeftApplication();

    void onAdOpened();
}
