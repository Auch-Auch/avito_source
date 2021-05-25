package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class qd {
    @NonNull
    private final qc a;

    public qd(@NonNull pr prVar) {
        this.a = new qc(prVar);
    }

    @NonNull
    public final List<pf> a(@Nullable JSONArray jSONArray) throws JSONException, z {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(this.a.a(optJSONObject));
                }
            }
        }
        return arrayList;
    }
}
