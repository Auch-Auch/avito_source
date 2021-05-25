package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.HashMap;
import java.util.Map;
public final class nt {
    private static final Map<NativeAdType, ns> a = new HashMap<NativeAdType, ns>() { // from class: com.yandex.mobile.ads.impl.nt.1
        {
            put(NativeAdType.APP_INSTALL, new np());
            put(NativeAdType.CONTENT, new nq());
            put(NativeAdType.IMAGE, new nr());
        }
    };

    @Nullable
    public static ns a(@NonNull NativeAdType nativeAdType) {
        return a.get(nativeAdType);
    }
}
