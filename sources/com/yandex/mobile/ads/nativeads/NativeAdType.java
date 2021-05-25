package com.yandex.mobile.ads.nativeads;
public enum NativeAdType {
    CONTENT("content"),
    APP_INSTALL("app"),
    IMAGE("image");
    
    private final String a;

    private NativeAdType(String str) {
        this.a = str;
    }

    public final String getValue() {
        return this.a;
    }
}
