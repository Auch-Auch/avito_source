package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.pc;
import com.yandex.mobile.ads.nativeads.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class py implements pv<pc> {
    @NonNull
    private final pr a;

    public py(@NonNull pr prVar) {
        this.a = prVar;
    }

    /* Return type fixed from 'com.yandex.mobile.ads.impl.pa' to match base method */
    @Override // com.yandex.mobile.ads.impl.pv
    @NonNull
    public final /* synthetic */ pc a(@NonNull JSONObject jSONObject) throws JSONException, z {
        String a3 = pp.a(jSONObject, "type");
        JSONArray jSONArray = jSONObject.getJSONArray("items");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new pc.a(pp.a(jSONObject2, "title"), this.a.a(jSONObject2, "url")));
        }
        if (!arrayList.isEmpty()) {
            return new pc(a3, arrayList);
        }
        throw new z("Native Ad json has not required attributes");
    }
}
