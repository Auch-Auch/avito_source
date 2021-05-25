package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import android.text.TextUtils;
public final class gr {
    @Nullable
    public static gq a(@Nullable String str, @Nullable Boolean bool) {
        if (bool == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new gq(str, bool.booleanValue());
    }
}
