package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;
public final class PathComponent {
    public final String className;
    public final String description;
    public final String hint;
    public final int id;
    public final int index;
    public final int matchBitmask;
    public final String tag;
    public final String text;

    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        public final int a;

        /* access modifiers changed from: public */
        MatchBitmaskType(int i) {
            this.a = i;
        }

        public int getValue() {
            return this.a;
        }
    }

    public PathComponent(JSONObject jSONObject) throws JSONException {
        this.className = jSONObject.getString("class_name");
        this.index = jSONObject.optInt(FirebaseAnalytics.Param.INDEX, -1);
        this.id = jSONObject.optInt("id");
        this.text = jSONObject.optString("text");
        this.tag = jSONObject.optString("tag");
        this.description = jSONObject.optString("description");
        this.hint = jSONObject.optString("hint");
        this.matchBitmask = jSONObject.optInt("match_bitmask");
    }
}
