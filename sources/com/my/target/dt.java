package com.my.target;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
public class dt {
    public static int a(@NonNull JSONObject jSONObject, @NonNull String str, int i) {
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return i;
        }
        try {
            return Color.parseColor(optString);
        } catch (Throwable unused) {
            ae.b("error parsing color " + optString);
            return i;
        }
    }
}
