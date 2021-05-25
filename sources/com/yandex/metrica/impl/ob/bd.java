package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public enum bd {
    GPL("gpl"),
    BROADCAST("broadcast"),
    API("api");
    
    @NonNull
    public final String d;

    private bd(String str) {
        this.d = str;
    }
}
