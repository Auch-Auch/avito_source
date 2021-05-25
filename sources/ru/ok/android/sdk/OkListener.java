package ru.ok.android.sdk;

import org.json.JSONObject;
public interface OkListener {
    public static final String KEY_EXCEPTION = "exception";
    public static final String KEY_RESULT = "result";

    void onError(String str);

    void onSuccess(JSONObject jSONObject);
}
