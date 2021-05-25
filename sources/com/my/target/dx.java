package com.my.target;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;
public class dx {
    public static dx h(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dx();
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull ct ctVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            ctVar.setTitle(optJSONObject.optString("title", ctVar.getTitle()));
            ctVar.B(optJSONObject.optString("icon_hd", ctVar.ck()));
            ctVar.C(optJSONObject.optString("bubble_icon_hd", ctVar.cl()));
            ctVar.D(optJSONObject.optString("label_icon_hd", ctVar.cm()));
            ctVar.E(optJSONObject.optString("goto_app_icon_hd", ctVar.cn()));
            ctVar.F(optJSONObject.optString("item_highlight_icon", ctVar.co()));
            JSONArray optJSONArray = optJSONObject.optJSONArray("icon_status");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        ctVar.cj().add(new Pair<>(optJSONObject2.optString("value"), optJSONObject2.optString("icon_hd")));
                    }
                }
            }
        }
    }
}
