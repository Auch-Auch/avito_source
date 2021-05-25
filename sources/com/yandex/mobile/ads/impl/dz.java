package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
public final class dz implements ThreadFactory {
    private final String a;

    public dz(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.a);
    }
}
