package ru.ok.android.sdk.util;

import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class StatsBuilder {
    public String a = "1.0.0";
    public long b = System.currentTimeMillis();
    public final JSONArray c = new JSONArray();

    public enum Type {
        COUNTER,
        SELECT,
        INTERVAL,
        STATUS
    }

    public StatsBuilder addCounter(Type type, String str, long j, Collection<String> collection) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", type.name().toLowerCase());
        jSONObject.put("id", str);
        jSONObject.put("time", j);
        jSONObject.put("data", new JSONArray((Collection) collection));
        this.c.put(jSONObject);
        return this;
    }

    public JSONObject build() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", this.a);
        jSONObject.put("time", this.b);
        jSONObject.put("stats", this.c);
        return jSONObject;
    }

    public StatsBuilder withTime(long j) {
        this.b = j;
        return this;
    }

    public StatsBuilder withVersion(String str) {
        this.a = str;
        return this;
    }

    public StatsBuilder addCounter(Type type, String str, long j, String str2) throws JSONException {
        return addCounter(type, str, j, Collections.singleton(str2));
    }
}
