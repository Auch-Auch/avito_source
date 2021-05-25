package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
public final class jo implements Runnable {
    @Nullable
    private er a;

    public final void a(@Nullable er erVar) {
        this.a = erVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        er erVar = this.a;
        if (erVar != null) {
            erVar.onAdFailedToLoad(v.i);
        }
    }
}
