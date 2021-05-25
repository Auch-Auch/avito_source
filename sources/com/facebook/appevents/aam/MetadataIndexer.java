package com.facebook.appevents.aam;

import a2.g.k.w.b;
import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class MetadataIndexer {
    public static Boolean a = Boolean.FALSE;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            String rawAamRules;
            if (!AttributionIdentifiers.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                Boolean bool = MetadataIndexer.a;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (!(queryAppSettings == null || (rawAamRules = queryAppSettings.getRawAamRules()) == null)) {
                    Set<MetadataRule> set = MetadataRule.d;
                    try {
                        MetadataRule.d.clear();
                        MetadataRule.a(new JSONObject(rawAamRules));
                    } catch (JSONException unused) {
                    }
                }
                MetadataIndexer.a = Boolean.TRUE;
            }
        }
    }

    public static void enable() {
        try {
            FacebookSdk.getExecutor().execute(new a());
        } catch (Exception e) {
            Utility.logd("com.facebook.appevents.aam.MetadataIndexer", e);
        }
    }

    @UiThread
    public static void onActivityResumed(Activity activity) {
        try {
            if (a.booleanValue()) {
                Set<MetadataRule> set = MetadataRule.d;
                if (!new HashSet(MetadataRule.d).isEmpty()) {
                    b.c(activity);
                }
            }
        } catch (Exception unused) {
        }
    }
}
