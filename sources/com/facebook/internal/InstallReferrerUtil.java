package com.facebook.internal;

import a2.g.r.e;
import com.android.installreferrer.api.InstallReferrerClient;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@AutoHandleExceptions
public class InstallReferrerUtil {

    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    public static void a() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean("is_referrer_updated", true).apply();
    }

    public static void tryUpdateReferrerInfo(Callback callback) {
        if (!FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean("is_referrer_updated", false)) {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
            try {
                build.startConnection(new e(build, callback));
            } catch (Exception unused) {
            }
        }
    }
}
