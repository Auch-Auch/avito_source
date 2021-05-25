package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.be;
public final class nx {
    @NonNull
    private final be a;
    private final int b;

    public nx(@NonNull be beVar, int i) {
        this.a = beVar;
        this.b = i;
    }

    @NonNull
    public final an a(@NonNull Context context) {
        return this.a.a(context, this.b);
    }
}
