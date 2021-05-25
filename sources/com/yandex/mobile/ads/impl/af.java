package com.yandex.mobile.ads.impl;
public enum af {
    AD("ad"),
    AD_UNIT("ad_unit");
    
    private final String c;

    private af(String str) {
        this.c = str;
    }

    public final String a() {
        return this.c;
    }
}
