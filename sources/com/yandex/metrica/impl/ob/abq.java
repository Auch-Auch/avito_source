package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
public class abq {
    @NonNull
    public static String a(Map<String, String> map) {
        if (dl.a((Map) map)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static boolean b(String str) {
        return b(a(str));
    }

    public static Map<String, String> c(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (d(entry.getKey()) && c(entry.getValue())) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    private static boolean d(String str) {
        return !TextUtils.isEmpty(str) && !str.contains(":") && !str.contains(",") && !str.contains("&");
    }

    public static boolean b(Map<String, String> map) {
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                Integer.parseInt(entry.getValue());
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(String str) {
        return !TextUtils.isEmpty(str) && abk.a(str, -1) != -1;
    }

    @NonNull
    public static Map<String, String> a(@Nullable String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            for (String str2 : split) {
                int indexOf = str2.indexOf(":");
                if (indexOf != -1) {
                    String substring = str2.substring(0, indexOf);
                    if (!TextUtils.isEmpty(substring)) {
                        hashMap.put(substring, str2.substring(indexOf + 1));
                    }
                }
            }
        }
        return hashMap;
    }
}
