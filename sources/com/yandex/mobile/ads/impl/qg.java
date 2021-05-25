package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qg implements qe<os> {
    @NonNull
    private final qh a;

    public qg(@NonNull qh qhVar) {
        this.a = qhVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qe
    @NonNull
    public final /* synthetic */ os a(@NonNull JSONObject jSONObject) throws JSONException, z {
        if (jSONObject.has("value")) {
            ot otVar = null;
            if (!jSONObject.isNull("value")) {
                otVar = this.a.a(jSONObject);
            }
            return new os(otVar);
        }
        throw new z("Native Ad json has not required attributes");
    }
}
