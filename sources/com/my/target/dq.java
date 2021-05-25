package com.my.target;

import androidx.annotation.NonNull;
import com.my.target.common.models.AudioData;
import java.util.Iterator;
import org.json.JSONObject;
public class dq {
    @NonNull
    public static dq cS() {
        return new dq();
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull cp cpVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            Iterator<cr<AudioData>> it = cpVar.bV().iterator();
            while (it.hasNext()) {
                cr<AudioData> next = it.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next.getName());
                if (optJSONObject2 != null) {
                    next.s(optJSONObject2.optInt("connectionTimeout", next.bY()));
                    int optInt = optJSONObject2.optInt("maxBannersShow", next.bZ());
                    if (optInt == 0) {
                        optInt = -1;
                    }
                    next.t(optInt);
                }
            }
        }
    }
}
