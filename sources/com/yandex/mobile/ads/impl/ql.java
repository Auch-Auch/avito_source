package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class ql implements qe<String> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qe
    @NonNull
    public final /* bridge */ /* synthetic */ String a(@NonNull JSONObject jSONObject) throws JSONException, z {
        return pp.a(jSONObject, "value");
    }
}
