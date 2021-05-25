package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public abstract class pa {
    @NonNull
    private final String a;

    public pa(@NonNull String str) {
        this.a = str;
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((pa) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
