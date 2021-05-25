package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import com.avito.android.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class dx {
    @NonNull
    public static Map<String, String> a(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject2.getString(next));
        }
        return hashMap;
    }

    @Nullable
    public static List<String> b(@NonNull JSONObject jSONObject, @NonNull String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (a(optJSONArray.optString(i))) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return arrayList;
    }

    public static String c(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        String string = jSONObject.getString(str);
        if (a(string)) {
            return String.valueOf(Html.fromHtml(string));
        }
        throw new JSONException("Json value can not be null or empty");
    }

    private static boolean a(@Nullable String str) {
        return !TextUtils.isEmpty(str) && !BuildConfig.ADJUST_DEFAULT_TRACKER.equals(str);
    }
}
