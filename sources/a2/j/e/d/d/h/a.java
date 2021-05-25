package a2.j.e.d.d.h;

import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;
public class a implements b {
    public static long b(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return (j * 1000) + currentTimeProvider.getCurrentTimeMillis();
    }

    @Override // a2.j.e.d.d.h.b
    public SettingsData a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("app");
        return new SettingsData(b(currentTimeProvider, (long) optInt2, jSONObject), new AppSettingsData(jSONObject2.getString("status"), jSONObject2.getString("url"), jSONObject2.getString("reports_url"), jSONObject2.getString("ndk_reports_url"), jSONObject2.optBoolean("update_required", false)), new SessionSettingsData(jSONObject.getJSONObject(SessionContract.SESSION).optInt("max_custom_exception_events", 8), 4), new FeaturesSettingsData(jSONObject.getJSONObject("features").optBoolean("collect_reports", true)), optInt, optInt2);
    }
}
