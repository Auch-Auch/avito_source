package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class pt {
    @NonNull
    public static pg a(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException, z {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("installedPackages");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                if (pq.a(jSONObject3, "name")) {
                    arrayList.add(new ph(pp.a(jSONObject3, "name"), dt.a(jSONObject3, "minVersion", 0), dt.a(jSONObject3, "maxVersion", Integer.MAX_VALUE)));
                } else {
                    throw new z("Native Ad json has not required attributes");
                }
            }
        }
        return new pg(arrayList);
    }
}
