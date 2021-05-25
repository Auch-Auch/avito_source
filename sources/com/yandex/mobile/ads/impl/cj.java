package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
public final class cj {
    @Nullable
    public static Map<String, String> a(@Nullable Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("&");
            sb.append(Uri.encode(entry.getKey()));
            sb.append("=");
            sb.append(Uri.encode(entry.getValue()));
            if (sb.length() > 61440) {
                ij.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", 61440, 61440);
                return hashMap;
            }
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    @Nullable
    public static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int length = Uri.encode(str).length();
            if (length <= 1024) {
                return str;
            }
            ij.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. Current size is %s bytes", 1024, Integer.valueOf(length));
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
