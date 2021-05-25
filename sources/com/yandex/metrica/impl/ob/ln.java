package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class ln {
    private final byte[] a;
    private final String b;
    private final int c;
    @NonNull
    private final HashMap<t.a, Integer> d;
    private final String e;
    private final Integer f;
    private final String g;
    private final String h;
    @NonNull
    private final CounterConfiguration.a i;

    public ln(@NonNull String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("event");
        this.a = Base64.decode(jSONObject2.getString("jvm_crash"), 0);
        this.b = jSONObject2.getString("name");
        this.c = jSONObject2.getInt("bytes_truncated");
        String optString = jSONObject2.optString("trimmed_fields");
        this.d = new HashMap<>();
        if (optString != null) {
            try {
                HashMap<String, String> a3 = abc.a(optString);
                if (a3 != null) {
                    for (Map.Entry<String, String> entry : a3.entrySet()) {
                        this.d.put(t.a.valueOf(entry.getKey()), Integer.valueOf(Integer.parseInt(entry.getValue())));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("process_configuration");
        this.e = jSONObject3.getString("package_name");
        this.f = Integer.valueOf(jSONObject3.getInt("pid"));
        this.g = jSONObject3.getString("psid");
        JSONObject jSONObject4 = jSONObject.getJSONObject("reporter_configuration");
        this.h = jSONObject4.getString("api_key");
        this.i = a(jSONObject4);
    }

    public byte[] a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @NonNull
    public HashMap<t.a, Integer> d() {
        return this.d;
    }

    public Integer e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.h;
    }

    @NonNull
    public CounterConfiguration.a i() {
        return this.i;
    }

    public String j() throws JSONException {
        HashMap hashMap = new HashMap();
        for (Map.Entry<t.a, Integer> entry : this.d.entrySet()) {
            hashMap.put(entry.getKey().name(), entry.getValue());
        }
        return new JSONObject().put("process_configuration", new JSONObject().put("pid", this.f).put("psid", this.g).put("package_name", this.e)).put("reporter_configuration", new JSONObject().put("api_key", this.h).put("reporter_type", this.i.a())).put("event", new JSONObject().put("jvm_crash", Base64.encodeToString(this.a, 0)).put("name", this.b).put("bytes_truncated", this.c).put("trimmed_fields", abc.b(hashMap))).toString();
    }

    @NonNull
    @Deprecated
    private CounterConfiguration.a a(@NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("reporter_type")) {
            return CounterConfiguration.a.a(jSONObject.getString("reporter_type"));
        }
        if (jSONObject.getBoolean("is_commutation")) {
            return CounterConfiguration.a.COMMUTATION;
        }
        return CounterConfiguration.a.MAIN;
    }

    public ln(@NonNull aa aaVar, @NonNull et etVar, @Nullable HashMap<t.a, Integer> hashMap) {
        this.a = aaVar.f();
        this.b = aaVar.d();
        this.c = aaVar.o();
        if (hashMap != null) {
            this.d = hashMap;
        } else {
            this.d = new HashMap<>();
        }
        eu g2 = etVar.g();
        this.e = g2.i();
        this.f = g2.f();
        this.g = g2.g();
        CounterConfiguration h2 = etVar.h();
        this.h = h2.e();
        this.i = h2.r();
    }
}
