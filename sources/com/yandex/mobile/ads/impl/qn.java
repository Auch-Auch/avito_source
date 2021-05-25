package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qn implements qm<ot> {
    @NonNull
    private final pr a;

    public qn(@NonNull Context context) {
        this.a = new pr(new ed(context));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qm
    @NonNull
    public final /* synthetic */ ot a(@NonNull JSONObject jSONObject) throws JSONException, z {
        ot otVar = new ot();
        otVar.a(this.a.a(jSONObject, "url"));
        otVar.a(jSONObject.getInt("w"));
        otVar.b(jSONObject.getInt("h"));
        String optString = jSONObject.optString("sizeType");
        if (!TextUtils.isEmpty(optString)) {
            otVar.b(optString);
        }
        return otVar;
    }
}
