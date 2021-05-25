package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.abc;
import org.json.JSONArray;
import org.json.JSONObject;
public class yq {
    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        JSONArray optJSONArray;
        JSONObject optJSONObject = aVar.optJSONObject("permissions");
        if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("name");
                    boolean optBoolean = optJSONObject2.optBoolean("enabled");
                    if (TextUtils.isEmpty(optString)) {
                        yxVar.a("", false);
                    } else {
                        yxVar.a(optString, optBoolean);
                    }
                }
            }
        }
    }
}
