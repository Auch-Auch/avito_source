package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
public abstract class abd {
    private static Map<String, abl> a = new HashMap();
    private static Map<String, abb> b = new HashMap();
    private static final Object c = new Object();
    private static final Object d = new Object();

    @NonNull
    public static abl a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        abl abl = a.get(str);
        if (abl == null) {
            synchronized (c) {
                abl = a.get(str);
                if (abl == null) {
                    abl = new abl(str);
                    a.put(str, abl);
                }
            }
        }
        return abl;
    }

    @NonNull
    public static abb b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        abb abb = b.get(str);
        if (abb == null) {
            synchronized (d) {
                abb = b.get(str);
                if (abb == null) {
                    abb = new abb(str);
                    b.put(str, abb);
                }
            }
        }
        return abb;
    }

    @NonNull
    public static abl a() {
        return abl.h();
    }

    @NonNull
    public static abb b() {
        return abb.h();
    }
}
