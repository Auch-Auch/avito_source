package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
public final class pq {
    public static boolean a(@NonNull List<oq> list) {
        HashSet hashSet = new HashSet();
        for (oq oqVar : list) {
            hashSet.add(oqVar.a());
        }
        return list.size() > hashSet.size();
    }

    public static boolean a(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            if (!jSONObject.has(str)) {
                return false;
            }
        }
        return true;
    }
}
