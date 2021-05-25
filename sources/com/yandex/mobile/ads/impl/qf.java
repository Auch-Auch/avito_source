package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.av;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qf implements qe<or> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qe
    @NonNull
    public final /* synthetic */ or a(@NonNull JSONObject jSONObject) throws JSONException, z {
        if (!jSONObject.has("value") || !jSONObject.isNull("value")) {
            return new or(av.a.TEXT, pp.a(jSONObject, "value"));
        }
        return new or(av.a.IMAGE, null);
    }
}
