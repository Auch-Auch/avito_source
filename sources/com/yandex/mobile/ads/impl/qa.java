package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qa implements pv<pe> {
    @NonNull
    private final qd a;
    @NonNull
    private final pr b;

    public qa(@NonNull pr prVar) {
        this.b = prVar;
        this.a = new qd(prVar);
    }

    /* Return type fixed from 'com.yandex.mobile.ads.impl.pa' to match base method */
    @Override // com.yandex.mobile.ads.impl.pv
    @NonNull
    public final /* synthetic */ pe a(@NonNull JSONObject jSONObject) throws JSONException, z {
        return new pe(pp.a(jSONObject, "type"), this.b.a(jSONObject, "fallbackUrl"), this.a.a(jSONObject.optJSONArray("preferredPackages")));
    }
}
