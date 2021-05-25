package com.google.firebase.crashlytics.internal.settings;

import a2.j.e.d.d.h.a;
import a2.j.e.d.d.h.b;
import a2.j.e.d.d.h.c;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;
public class SettingsJsonParser {
    public final CurrentTimeProvider a;

    public SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.a = currentTimeProvider;
    }

    public SettingsData parseSettingsJson(JSONObject jSONObject) throws JSONException {
        b bVar;
        if (jSONObject.getInt("settings_version") != 3) {
            bVar = new a();
        } else {
            bVar = new c();
        }
        return bVar.a(this.a, jSONObject);
    }
}
