package com.yandex.mobile.ads.impl;

import androidx.core.app.NotificationCompat;
public enum ag {
    AD("ad"),
    PROMO(NotificationCompat.CATEGORY_PROMO);
    
    private final String c;

    private ag(String str) {
        this.c = str;
    }

    public final String a() {
        return this.c;
    }
}
