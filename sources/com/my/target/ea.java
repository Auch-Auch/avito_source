package com.my.target;

import androidx.annotation.NonNull;
import org.json.JSONObject;
public class ea {
    @NonNull
    public static ea cT() {
        return new ea();
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull cu cuVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            cuVar.u(optJSONObject.optBoolean("hasAdditionalAds", cuVar.cq()));
        }
    }
}
