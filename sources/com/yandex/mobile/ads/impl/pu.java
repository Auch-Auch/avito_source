package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class pu {
    @NonNull
    private final ed a;
    @NonNull
    private final pw b;

    public pu(@NonNull ed edVar) {
        this.a = edVar;
        this.b = new pw(edVar);
    }

    @Nullable
    private String a(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException, z {
        return this.a.a(b(jSONObject, str));
    }

    @Nullable
    private static String b(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException, z {
        if (jSONObject.has(str)) {
            return pp.a(jSONObject, str);
        }
        return null;
    }

    @NonNull
    public final ou a(@NonNull JSONObject jSONObject) throws JSONException, z {
        ArrayList arrayList;
        JSONArray optJSONArray = jSONObject.optJSONArray("actions");
        dk dkVar = null;
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                pv a3 = this.b.a(jSONObject2);
                if (a3 != null) {
                    arrayList.add(a3.a(jSONObject2));
                }
            }
        } else {
            arrayList = null;
        }
        String a4 = a(jSONObject, "falseClickUrl");
        Long valueOf = Long.valueOf(jSONObject.optLong("falseClickInterval", 0));
        if (!(a4 == null || valueOf == null)) {
            dkVar = new dk(a4, valueOf.longValue());
        }
        return new ou(arrayList, dkVar, a(jSONObject, "trackingUrl"), a(jSONObject, "url"));
    }
}
