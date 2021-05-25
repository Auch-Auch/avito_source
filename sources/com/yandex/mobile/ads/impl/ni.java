package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
public final class ni {
    private static final Map<af, nh> a = new HashMap<af, nh>() { // from class: com.yandex.mobile.ads.impl.ni.1
        {
            put(af.AD, new nn());
            put(af.AD_UNIT, new nm());
        }
    };

    @Nullable
    public static nh a(@Nullable af afVar) {
        return a.get(afVar);
    }
}
