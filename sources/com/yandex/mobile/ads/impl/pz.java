package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class pz implements pv<pd> {
    @NonNull
    private final pr a;

    public pz(@NonNull pr prVar) {
        this.a = prVar;
    }

    /* Return type fixed from 'com.yandex.mobile.ads.impl.pa' to match base method */
    @Override // com.yandex.mobile.ads.impl.pv
    @NonNull
    public final /* synthetic */ pd a(@NonNull JSONObject jSONObject) throws JSONException, z {
        return new pd(pp.a(jSONObject, "type"), pp.a(jSONObject, "icon"), pp.a(jSONObject, "title"), this.a.a(jSONObject, "url"));
    }
}
