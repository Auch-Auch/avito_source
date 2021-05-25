package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;
public final class uh {
    public static void a(@NonNull Uri.Builder builder, @NonNull String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    public static void a(@NonNull Uri.Builder builder, @Nullable Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    a(builder, key, value);
                }
            }
        }
    }
}
