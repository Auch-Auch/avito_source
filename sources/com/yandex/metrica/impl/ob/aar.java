package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.vk.sdk.api.VKApiConst;
import org.json.JSONArray;
import org.json.JSONObject;
public class aar {
    @NonNull
    public JSONObject a(@NonNull Activity activity, @NonNull aaf aaf, @NonNull aah aah, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ssh", new JSONArray().put(new JSONObject().put("si", new JSONObject().put("cn", activity.getClass().getName())).put("cid", j).put(VKApiConst.VERSION, new JSONObject())));
            jSONObject.getJSONArray("ssh").getJSONObject(0).put(VKApiConst.VERSION, aaf.a(aah, jSONObject.toString().getBytes().length - 2));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
