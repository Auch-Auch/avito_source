package com.yandex.mobile.ads.nativeads;
public interface NativeGenericAd {
    void addImageLoadingListener(NativeAdImageLoadingListener nativeAdImageLoadingListener);

    void bindNativeAd(NativeAdViewBinder nativeAdViewBinder) throws NativeAdException;

    NativeAdAssets getAdAssets();

    NativeAdType getAdType();

    String getInfo();

    void loadImages();

    void removeImageLoadingListener(NativeAdImageLoadingListener nativeAdImageLoadingListener);

    void setAdEventListener(NativeAdEventListener nativeAdEventListener);

    void shouldOpenLinksInApp(boolean z);
}
