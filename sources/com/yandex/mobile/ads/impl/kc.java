package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class kc {
    @NonNull
    private final Object a = new Object();
    private boolean b;

    public final void a(@NonNull Runnable runnable) {
        synchronized (this.a) {
            if (!this.b) {
                this.b = true;
                runnable.run();
            }
        }
    }
}
