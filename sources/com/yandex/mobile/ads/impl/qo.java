package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qo implements qm<ov> {
    @NonNull
    private final ca a = new ca();

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qm
    @NonNull
    public final /* synthetic */ ov a(@NonNull JSONObject jSONObject) throws JSONException, z {
        String a3 = ca.a(pp.a(jSONObject, "html"));
        if (!TextUtils.isEmpty(a3)) {
            float f = (float) jSONObject.getDouble("aspectRatio");
            if (f == 0.0f) {
                f = 1.7777778f;
            }
            return new ov(a3, f);
        }
        throw new z("Native Ad json has attribute with broken base64 encoding");
    }
}
