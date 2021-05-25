package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
public final class pb {
    private final String a;
    private final int b;
    private final boolean c;

    public pb(@NonNull JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt("version", -1);
    }

    public JSONObject a() throws JSONException {
        JSONObject put = new JSONObject().put("name", this.a).put("required", this.c);
        int i = this.b;
        if (i != -1) {
            put.put("version", i);
        }
        return put;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pb.class != obj.getClass()) {
            return false;
        }
        pb pbVar = (pb) obj;
        if (this.b != pbVar.b || this.c != pbVar.c) {
            return false;
        }
        String str = this.a;
        String str2 = pbVar.a;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public pb(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }

    public pb(String str, boolean z) {
        this(str, -1, z);
    }
}
