package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.sumsub.sns.core.common.SNSConstants;
import org.json.JSONException;
import org.json.JSONObject;
public class xc {
    private final JSONObject a = new JSONObject();

    public void a(String str) {
        a("uuid", str);
    }

    public void b(String str) {
        a(SNSConstants.Preference.KEY_DEVICE_ID, str);
    }

    public void c(String str) {
        a("google_aid", str);
    }

    public void d(String str) {
        a("android_id", str);
    }

    private void a(String str, String str2) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            try {
                this.a.put(str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public String a() throws JSONException {
        return this.a.toString();
    }
}
