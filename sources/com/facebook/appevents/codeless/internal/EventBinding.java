package com.facebook.appevents.codeless.internal;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.util.preferences.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public class EventBinding {
    public final String a;
    public final MappingMethod b;
    public final ActionType c;
    public final String d;
    public final List<PathComponent> e;
    public final List<ParameterComponent> f;
    public final String g;
    public final String h;
    public final String i;

    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        this.a = str;
        this.b = mappingMethod;
        this.c = actionType;
        this.d = str2;
        this.e = list;
        this.f = list2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
    }

    public static EventBinding getInstanceFromJson(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        String string = jSONObject.getString("event_name");
        String string2 = jSONObject.getString("method");
        Locale locale = Locale.ENGLISH;
        MappingMethod valueOf = MappingMethod.valueOf(string2.toUpperCase(locale));
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase(locale));
        String string3 = jSONObject.getString(Preference.APP_VERSION);
        JSONArray jSONArray = jSONObject.getJSONArray(MessageMetaInfo.COLUMN_PATH);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i2)));
        }
        String optString = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, "absolute");
        JSONArray optJSONArray = jSONObject.optJSONArray(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList2.add(new ParameterComponent(optJSONArray.getJSONObject(i3)));
            }
        }
        return new EventBinding(string, valueOf, valueOf2, string3, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0010 A[Catch:{ IllegalArgumentException | JSONException -> 0x001e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.facebook.appevents.codeless.internal.EventBinding> parseArray(org.json.JSONArray r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r4 == 0) goto L_0x000d
            int r2 = r4.length()     // Catch:{ IllegalArgumentException | JSONException -> 0x001e }
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r1 >= r2) goto L_0x001e
            org.json.JSONObject r3 = r4.getJSONObject(r1)     // Catch:{ IllegalArgumentException | JSONException -> 0x001e }
            com.facebook.appevents.codeless.internal.EventBinding r3 = getInstanceFromJson(r3)     // Catch:{ IllegalArgumentException | JSONException -> 0x001e }
            r0.add(r3)     // Catch:{ IllegalArgumentException | JSONException -> 0x001e }
            int r1 = r1 + 1
            goto L_0x000e
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.EventBinding.parseArray(org.json.JSONArray):java.util.List");
    }

    public String getActivityName() {
        return this.i;
    }

    public String getAppVersion() {
        return this.d;
    }

    public String getComponentId() {
        return this.g;
    }

    public String getEventName() {
        return this.a;
    }

    public MappingMethod getMethod() {
        return this.b;
    }

    public String getPathType() {
        return this.h;
    }

    public ActionType getType() {
        return this.c;
    }

    public List<ParameterComponent> getViewParameters() {
        return Collections.unmodifiableList(this.f);
    }

    public List<PathComponent> getViewPath() {
        return Collections.unmodifiableList(this.e);
    }
}
