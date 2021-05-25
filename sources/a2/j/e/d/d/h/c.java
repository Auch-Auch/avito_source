package a2.j.e.d.d.h;

import a2.j.e.d.d.h.d.a;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
public class c implements b {
    @Override // a2.j.e.d.d.h.b
    public SettingsData a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        String str;
        long j;
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("fabric");
        JSONObject jSONObject3 = jSONObject.getJSONObject("app");
        String string = jSONObject3.getString("status");
        boolean equals = AppSettingsData.STATUS_NEW.equals(string);
        String string2 = jSONObject2.getString("bundle_id");
        String string3 = jSONObject2.getString(a.ORGANIZATION_ID_PARAM);
        if (equals) {
            str = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
        } else {
            str = String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", string2);
        }
        Locale locale = Locale.US;
        AppSettingsData appSettingsData = new AppSettingsData(string, str, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject3.optBoolean("update_required", false), jSONObject3.optInt("report_upload_variant", 0), jSONObject3.optInt("native_report_upload_variant", 0));
        SessionSettingsData sessionSettingsData = new SessionSettingsData(8, 4);
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(jSONObject.getJSONObject("features").optBoolean("collect_reports", true));
        long j2 = (long) optInt2;
        if (jSONObject.has("expires_at")) {
            j = jSONObject.optLong("expires_at");
        } else {
            j = (j2 * 1000) + currentTimeProvider.getCurrentTimeMillis();
        }
        return new SettingsData(j, appSettingsData, sessionSettingsData, featuresSettingsData, optInt, optInt2);
    }
}
