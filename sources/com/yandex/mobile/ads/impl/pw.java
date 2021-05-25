package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public final class pw {
    @NonNull
    private final pr a;
    @NonNull
    private final Map<String, pv> b = new HashMap<String, pv>() { // from class: com.yandex.mobile.ads.impl.pw.1
        {
            put("close", new px());
            put("deeplink", new qa(pw.this.a));
            put("feedback", new py(pw.this.a));
            put("shortcut", new pz(pw.this.a));
        }
    };

    public pw(@NonNull ed edVar) {
        this.a = new pr(edVar);
    }

    @Nullable
    public final pv a(@NonNull JSONObject jSONObject) throws JSONException, z {
        return this.b.get(pp.a(jSONObject, "type"));
    }
}
