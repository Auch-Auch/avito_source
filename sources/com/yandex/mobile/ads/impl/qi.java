package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class qi implements qe<ow> {
    @NonNull
    private final qo a = new qo();
    @NonNull
    private final qn b;

    public qi(@NonNull Context context) {
        this.b = new qn(context);
    }

    @Nullable
    private static <T> T a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull qm<T> qmVar) throws JSONException, z {
        if (a(jSONObject, str)) {
            return qmVar.a(jSONObject.getJSONObject(str));
        }
        return null;
    }

    private static boolean a(@NonNull JSONObject jSONObject, @NonNull String str) {
        return jSONObject.has(str) && !jSONObject.isNull(str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.qe
    @NonNull
    public final /* synthetic */ ow a(@NonNull JSONObject jSONObject) throws JSONException, z {
        if (a(jSONObject, "value")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("value");
            ov ovVar = (ov) a(jSONObject2, "media", this.a);
            ot otVar = (ot) a(jSONObject2, "image", this.b);
            if (ovVar != null || otVar != null) {
                return new ow(ovVar, otVar);
            }
            throw new z("Native Ad json has not required attributes");
        }
        throw new z("Native Ad json has not required attributes");
    }
}
