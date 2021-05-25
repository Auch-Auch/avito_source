package ru.ok.android.sdk.util;

import org.json.JSONException;
import org.json.JSONObject;
public class Utils {
    public static JSONObject toJson(String str, String str2) {
        try {
            return new JSONObject().put(str, str2);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
