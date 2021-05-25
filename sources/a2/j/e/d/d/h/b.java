package a2.j.e.d.d.h;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;
public interface b {
    SettingsData a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException;
}
