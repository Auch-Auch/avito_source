package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.facebook.applinks.AppLinkData;
import com.yandex.mobile.ads.nativeads.z;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
public final class qc {
    @NonNull
    private final qb a = new qb();
    @NonNull
    private final pr b;

    public qc(@NonNull pr prVar) {
        this.b = prVar;
    }

    @NonNull
    public final pf a(@NonNull JSONObject jSONObject) throws JSONException, z {
        HashMap hashMap;
        String a3 = pp.a(jSONObject, "package");
        String a4 = this.b.a(jSONObject, "url");
        JSONObject optJSONObject = jSONObject.optJSONObject(AppLinkData.ARGUMENTS_EXTRAS_KEY);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            if (keys.hasNext()) {
                hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!optJSONObject.isNull(next)) {
                        hashMap.put(next, optJSONObject.get(next));
                    }
                }
                return new pf(a3, a4, hashMap);
            }
        }
        hashMap = null;
        return new pf(a3, a4, hashMap);
    }
}
