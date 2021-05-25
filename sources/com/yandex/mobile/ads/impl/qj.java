package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qj implements qe<String> {
    @NonNull
    private final qk a = new qk();

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qe
    @NonNull
    public final /* synthetic */ String a(@NonNull JSONObject jSONObject) throws JSONException, z {
        String a3 = pp.a(jSONObject, "name");
        String a4 = pp.a(jSONObject, "value");
        return "review_count".equals(a3) ? this.a.a(a4) : a4;
    }
}
