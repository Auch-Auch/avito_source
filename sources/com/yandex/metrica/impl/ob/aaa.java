package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import org.json.JSONObject;
public class aaa {
    @NonNull
    public JSONObject a(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time_millis", j);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @NonNull
    public JSONObject a(long j, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time_millis", j).put("force", z).put("rescanned", z2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
