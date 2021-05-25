package com.facebook.appevents.suggestedevents;

import a2.g.k.a0.d;
import android.app.Activity;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class SuggestedEventsManager {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static final Set<String> b = new HashSet();
    public static final Set<String> c = new HashSet();

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean = SuggestedEventsManager.a;
            if (!atomicBoolean.get()) {
                atomicBoolean.set(true);
                try {
                    FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                    if (queryAppSettings != null) {
                        String suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting();
                        if (suggestedEventsSetting != null) {
                            SuggestedEventsManager.populateEventsFromRawJsonString(suggestedEventsSetting);
                            if (!SuggestedEventsManager.b.isEmpty() || !SuggestedEventsManager.c.isEmpty()) {
                                File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
                                if (ruleFile != null) {
                                    a2.g.k.a0.a.c(ruleFile);
                                    Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                                    if (currentActivity != null) {
                                        SuggestedEventsManager.trackActivity(currentActivity);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static synchronized void enable() {
        synchronized (SuggestedEventsManager.class) {
            FacebookSdk.getExecutor().execute(new a());
        }
    }

    public static boolean isEnabled() {
        return a.get();
    }

    public static void populateEventsFromRawJsonString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("production_events")) {
                JSONArray jSONArray = jSONObject.getJSONArray("production_events");
                for (int i = 0; i < jSONArray.length(); i++) {
                    b.add(jSONArray.getString(i));
                }
            }
            if (jSONObject.has("eligible_for_prediction_events")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("eligible_for_prediction_events");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    c.add(jSONArray2.getString(i2));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void trackActivity(Activity activity) {
        try {
            if (!a.get() || !a2.g.k.a0.a.e || (b.isEmpty() && c.isEmpty())) {
                d.c(activity);
            } else {
                d.b(activity);
            }
        } catch (Exception unused) {
        }
    }
}
