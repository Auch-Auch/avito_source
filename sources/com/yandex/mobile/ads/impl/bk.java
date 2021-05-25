package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
public final class bk {
    @NonNull
    public static Map<String, String> a(@Nullable x xVar) {
        bq o;
        HashMap hashMap = new HashMap();
        if (!(xVar == null || (o = xVar.o()) == null)) {
            hashMap.put("rewarding_side", o.c() ? "server_side" : "client_side");
        }
        return hashMap;
    }
}
