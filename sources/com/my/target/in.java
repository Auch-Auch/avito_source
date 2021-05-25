package com.my.target;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import java.util.Map;
public class in {
    @NonNull
    public static String a(@NonNull Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                String encode = ip.encode(value);
                if (!z) {
                    sb.append("&");
                } else {
                    z = false;
                }
                a.m1(sb, key, "=", encode);
            }
        }
        return sb.toString();
    }
}
