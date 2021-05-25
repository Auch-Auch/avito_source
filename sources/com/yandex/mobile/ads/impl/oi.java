package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
public final class oi {
    @NonNull
    private final dg a;

    public oi(@NonNull dg dgVar) {
        this.a = dgVar;
    }

    public final void a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.a(str);
        }
    }
}
