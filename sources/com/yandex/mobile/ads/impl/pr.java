package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
import org.json.JSONObject;
public final class pr {
    @NonNull
    private final ed a;

    public pr(@NonNull ed edVar) {
        this.a = edVar;
    }

    @NonNull
    public final String a(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException, z {
        String a3 = this.a.a(pp.a(jSONObject, str));
        if (!TextUtils.isEmpty(a3)) {
            return a3;
        }
        throw new z("Native Ad json has not required attributes");
    }
}
