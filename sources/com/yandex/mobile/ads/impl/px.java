package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class px implements pv {
    @Override // com.yandex.mobile.ads.impl.pv
    @NonNull
    public final pa a(@NonNull JSONObject jSONObject) throws JSONException, z {
        return new pb(pp.a(jSONObject, "type"));
    }
}
