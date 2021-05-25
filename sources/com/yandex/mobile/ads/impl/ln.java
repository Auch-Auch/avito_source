package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class ln {
    @NonNull
    private final Map<String, Object> a;

    public ln(@NonNull List<oq> list) {
        this.a = a(list);
    }

    @NonNull
    private static Map<String, Object> a(@NonNull List<oq> list) {
        HashMap hashMap = new HashMap();
        for (oq oqVar : list) {
            hashMap.put(oqVar.a(), oqVar.c());
        }
        return hashMap;
    }

    @Nullable
    public final ow a() {
        Object obj = this.a.get("media");
        if (obj instanceof ow) {
            return (ow) obj;
        }
        return null;
    }
}
