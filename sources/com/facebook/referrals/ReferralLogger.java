package com.facebook.referrals;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
public class ReferralLogger {
    public final InternalAppEventsLogger a;
    public String b = UUID.randomUUID().toString();
    public String c;

    public ReferralLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.a = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.c = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("0_auth_logger_id", this.b);
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("2_error_message", "");
        bundle.putString("3_extras", "");
        return bundle;
    }

    public void logCancel() {
        this.a.logEventImplicitly("fb_mobile_referral_cancel", a());
    }

    public void logError(Exception exc) {
        Bundle a3 = a();
        if (!(exc == null || exc.getMessage() == null)) {
            a3.putString("2_error_message", exc.getMessage());
        }
        this.a.logEventImplicitly("fb_mobile_referral_error", a3);
    }

    public void logStartReferral() {
        Bundle a3 = a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request_code", CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode());
            String str = this.c;
            if (str != null) {
                jSONObject.put("facebookVersion", str);
            }
            a3.putString("3_extras", jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.a.logEventImplicitly("fb_mobile_referral_start", a3);
    }

    public void logSuccess() {
        this.a.logEventImplicitly("fb_mobile_referral_success", a());
    }
}
