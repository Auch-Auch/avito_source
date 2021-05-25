package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.nativeads.NativeAdEventListener;
public interface ClosableNativeAdEventListener extends NativeAdEventListener {

    public static class SimpleClosableNativeAdEventListener extends NativeAdEventListener.SimpleNativeAdEventListener implements ClosableNativeAdEventListener {
        @Override // com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener
        public void closeNativeAd() {
        }
    }

    void closeNativeAd();
}
