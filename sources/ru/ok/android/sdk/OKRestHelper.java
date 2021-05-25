package ru.ok.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sumsub.sns.core.common.SNSConstants;
import com.vk.sdk.api.model.VKAttachments;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.util.StatsBuilder;
public class OKRestHelper {
    public final Odnoklassniki a;

    public class a implements OkListener {
        public final /* synthetic */ OkListener a;

        public a(OkListener okListener) {
            this.a = okListener;
        }

        @Override // ru.ok.android.sdk.OkListener
        public void onError(String str) {
            OKRestHelper.this.a.notifyFailed(this.a, str);
        }

        @Override // ru.ok.android.sdk.OkListener
        public void onSuccess(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("endpoints");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("widgets", Shared.REMOTE_WIDGETS);
                OKRestHelper.this.a.setBasePlatformUrls(optJSONObject.optString("api", Shared.REMOTE_API), optString);
            }
            OKRestHelper.this.a.notifySuccess(this.a, jSONObject);
        }
    }

    public OKRestHelper(Odnoklassniki odnoklassniki) {
        this.a = odnoklassniki;
    }

    @NonNull
    public String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str = null;
        if (telephonyManager != null) {
            try {
                str = telephonyManager.getDeviceId();
            } catch (SecurityException e) {
                e.getMessage();
            }
        }
        return a2.b.a.a.a.e3(str, "_", Settings.Secure.getString(context.getContentResolver(), "android_id"));
    }

    public boolean notifyListener(OkListener okListener, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("error_msg")) {
                this.a.notifyFailed(okListener, jSONObject.optString("error_msg", jSONObject.toString()));
                return false;
            }
            this.a.notifySuccess(okListener, jSONObject);
            return true;
        } catch (JSONException unused) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("reponse", str);
            } catch (JSONException unused2) {
            }
            this.a.notifySuccess(okListener, jSONObject2);
            return true;
        }
    }

    public void sdkGetEndpoints(@Nullable OkListener okListener) {
        this.a.requestAsync("sdk.getEndpoints", null, EnumSet.of(OkRequestMode.SIGNED), new a(okListener));
    }

    public boolean sdkInit(Context context) throws IOException {
        if (!TextUtils.isEmpty(this.a.sdkToken)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", 2);
            jSONObject.put(SNSConstants.Preference.KEY_DEVICE_ID, getDeviceId(context));
            jSONObject.put("client_version", "android_sdk_1");
            jSONObject.put("client_type", "SDK_ANDROID");
            HashMap hashMap = new HashMap();
            hashMap.put("session_data", jSONObject.toString());
            try {
                JSONObject jSONObject2 = new JSONObject(this.a.request("sdk.init", hashMap, EnumSet.of(OkRequestMode.UNSIGNED)));
                if (jSONObject2.has("session_key")) {
                    this.a.sdkToken = jSONObject2.getString("session_key");
                    if (!TextUtils.isEmpty(this.a.sdkToken)) {
                        String str = this.a.sdkToken;
                        SharedPreferences.Editor edit = context.getSharedPreferences(Shared.PREFERENCES_FILE, 0).edit();
                        edit.putString("ok_sdk_tkn", str);
                        edit.apply();
                        return true;
                    }
                }
            } catch (JSONException e) {
                e.getMessage();
            }
            return false;
        } catch (JSONException e2) {
            e2.getMessage();
            return false;
        }
    }

    public void sdkReportStats(StatsBuilder statsBuilder, OkListener okListener) throws JSONException, IOException {
        HashMap hashMap = new HashMap();
        hashMap.put("stats", statsBuilder.build().toString());
        notifyListener(okListener, this.a.request("sdk.reportStats", hashMap, OkRequestMode.DEFAULT));
    }

    public boolean sdkSendNote(JSONObject jSONObject, OkListener okListener) throws IOException {
        HashMap hashMap = new HashMap();
        hashMap.put(VKAttachments.TYPE_NOTE, jSONObject.toString());
        return notifyListener(okListener, this.a.request("sdk.sendNote", hashMap, EnumSet.of(OkRequestMode.SIGNED, OkRequestMode.SDK_SESSION)));
    }
}
