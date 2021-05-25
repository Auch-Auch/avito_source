package com.yandex.mobile.ads.impl;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
public final class qt {
    @NonNull
    public static Intent a(@NonNull pf pfVar) {
        String b = pfVar.b();
        String a = pfVar.a();
        Map<String, Object> c = pfVar.c();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(b));
        intent.addFlags(1342177280);
        intent.setPackage(a);
        a(intent, c);
        return intent;
    }

    private static void a(@NonNull Intent intent, @Nullable Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    intent.putExtra(key, (Boolean) value);
                } else if (value instanceof Integer) {
                    intent.putExtra(key, (Integer) value);
                } else if (value instanceof String) {
                    intent.putExtra(key, (String) value);
                }
            }
        }
    }
}
