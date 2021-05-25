package com.my.target;

import androidx.annotation.NonNull;
import com.my.target.common.models.VideoData;
import java.util.Iterator;
import org.json.JSONObject;
public class dp {
    @NonNull
    public static dp cR() {
        return new dp();
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull co coVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            Iterator<cr<VideoData>> it = coVar.bS().iterator();
            while (it.hasNext()) {
                cr<VideoData> next = it.next();
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
