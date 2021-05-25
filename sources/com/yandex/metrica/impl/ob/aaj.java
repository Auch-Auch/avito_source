package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.support.annotation.NonNull;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class aaj {
    public void a(@NonNull zo zoVar, @NonNull Activity activity, @NonNull List<aam> list, @NonNull aah aah, long j) {
        if (!list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("sid", activity.getClass().getName()).put("cid", j);
            } catch (Throwable unused) {
            }
            int length = jSONObject.toString().getBytes().length + 4 + 3 + 2 + 3 + 3 + 2 + 1;
            for (aam aam : list) {
                length += a(aam, jSONArray, aah, length);
            }
            try {
                jSONObject.put("cxt", jSONArray);
            } catch (Throwable unused2) {
            }
            zoVar.a(jSONObject);
        }
    }

    private int a(@NonNull aam aam, @NonNull JSONArray jSONArray, @NonNull aah aah, int i) {
        if (!aah.f && !aam.a()) {
            return 0;
        }
        JSONObject c = aam.c(aah);
        int length = c.toString().getBytes().length + 1;
        int length2 = jSONArray.length();
        if (i + length > aah.k || length2 >= aah.j) {
            return 0;
        }
        jSONArray.put(c);
        return length;
    }
}
