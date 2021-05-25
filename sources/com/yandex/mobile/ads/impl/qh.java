package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qh implements qe<ot> {
    @NonNull
    private final pr a;

    public qh(@NonNull Context context) {
        this.a = new pr(new ed(context));
    }

    @NonNull
    /* renamed from: b */
    public final ot a(@NonNull JSONObject jSONObject) throws JSONException, z {
        if (!jSONObject.has("value") || jSONObject.isNull("value")) {
            throw new z("Native Ad json has not required attributes");
        }
        ot otVar = new ot();
        JSONObject jSONObject2 = jSONObject.getJSONObject("value");
        otVar.a(this.a.a(jSONObject2, "url"));
        otVar.a(jSONObject2.getInt("w"));
        otVar.b(jSONObject2.getInt("h"));
        String optString = jSONObject2.optString("sizeType");
        if (!TextUtils.isEmpty(optString)) {
            otVar.b(optString);
        }
        return otVar;
    }
}
