package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Map;
public final class go {
    public static boolean a(@NonNull Map<String, String> map) {
        String str = map.get("yandex_mobile_metrica_get_ad_url");
        if (!(!TextUtils.isEmpty(map.get("yandex_mobile_metrica_uuid"))) || !(!TextUtils.isEmpty(str))) {
            return false;
        }
        return true;
    }
}
