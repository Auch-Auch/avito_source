package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public class yv {
    private static final Map<String, Integer> a;
    private static final Map<String, Integer> b;
    private static final Map<String, Integer> c;
    private static final Map<String, Integer> d;
    @NonNull
    private final of e;

    static {
        HashMap hashMap = new HashMap(3);
        hashMap.put("all_matches", 1);
        hashMap.put("first_match", 2);
        hashMap.put("match_lost", 3);
        a = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("aggressive", 1);
        hashMap2.put("sticky", 2);
        b = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap(3);
        hashMap3.put("one", 1);
        hashMap3.put("few", 2);
        hashMap3.put("max", 3);
        c = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("low_power", 1);
        hashMap4.put("balanced", 2);
        hashMap4.put("low_latency", 3);
        d = Collections.unmodifiableMap(hashMap4);
    }

    public yv() {
        this(new of());
    }

    @NonNull
    private ve.a.C0352a.b b(@Nullable JSONObject jSONObject) {
        ve.a.C0352a.b bVar = new ve.a.C0352a.b();
        if (jSONObject != null) {
            Integer a3 = a(jSONObject, "callback_type", a);
            if (a3 != null) {
                bVar.b = a3.intValue();
            }
            Integer a4 = a(jSONObject, "match_mode", b);
            if (a4 != null) {
                bVar.c = a4.intValue();
            }
            Integer a5 = a(jSONObject, "num_of_matches", c);
            if (a5 != null) {
                bVar.d = a5.intValue();
            }
            Integer a6 = a(jSONObject, "scan_mode", d);
            if (a6 != null) {
                bVar.e = a6.intValue();
            }
            bVar.f = abw.a(abc.a(jSONObject, "report_delay"), TimeUnit.SECONDS, bVar.f);
        }
        return bVar;
    }

    @Nullable
    private ve.a.C0352a.C0353a c(@Nullable JSONObject jSONObject) {
        ve.a.C0352a.C0353a aVar;
        boolean z = false;
        boolean z2 = true;
        if (jSONObject != null) {
            aVar = new ve.a.C0352a.C0353a();
            String optString = jSONObject.optString("device_address", null);
            if (optString != null) {
                aVar.b = optString;
                z2 = false;
            }
            String optString2 = jSONObject.optString("device_name", null);
            if (optString2 != null) {
                aVar.c = optString2;
                z2 = false;
            }
            ve.a.C0352a.C0353a.C0354a d2 = d(jSONObject.optJSONObject("manufacturer_data"));
            if (d2 != null) {
                aVar.d = d2;
                z2 = false;
            }
            ve.a.C0352a.C0353a.b e2 = e(jSONObject.optJSONObject("service_data"));
            if (e2 != null) {
                aVar.e = e2;
                z2 = false;
            }
            ve.a.C0352a.C0353a.c f = f(jSONObject.optJSONObject("service_uuid"));
            if (f != null) {
                aVar.f = f;
            } else {
                z = z2;
            }
        } else {
            aVar = null;
            z = true;
        }
        if (z) {
            return null;
        }
        return aVar;
    }

    @Nullable
    private ve.a.C0352a.C0353a.C0354a d(@Nullable JSONObject jSONObject) {
        Integer c2;
        if (jSONObject == null || (c2 = abc.c(jSONObject, "id")) == null) {
            return null;
        }
        ve.a.C0352a.C0353a.C0354a aVar = new ve.a.C0352a.C0353a.C0354a();
        aVar.b = c2.intValue();
        aVar.c = abc.a(jSONObject, "data", aVar.c);
        aVar.d = abc.a(jSONObject, "data_mask", aVar.d);
        return aVar;
    }

    @Nullable
    private ve.a.C0352a.C0353a.b e(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("uuid", null);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        ve.a.C0352a.C0353a.b bVar = new ve.a.C0352a.C0353a.b();
        bVar.b = optString;
        bVar.c = abc.a(jSONObject, "data", bVar.c);
        bVar.d = abc.a(jSONObject, "data_mask", bVar.d);
        return bVar;
    }

    @Nullable
    private ve.a.C0352a.C0353a.c f(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("uuid", null);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        ve.a.C0352a.C0353a.c cVar = new ve.a.C0352a.C0353a.c();
        cVar.b = optString;
        cVar.c = jSONObject.optString("data_mask", cVar.c);
        return cVar;
    }

    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        yxVar.a(this.e.a(a(aVar)));
    }

    @VisibleForTesting
    public yv(@NonNull of ofVar) {
        this.e = ofVar;
    }

    @NonNull
    private ve.a.C0352a a(@NonNull JSONObject jSONObject) {
        ve.a.C0352a aVar = new ve.a.C0352a();
        JSONObject optJSONObject = jSONObject.optJSONObject("ble_collecting");
        if (optJSONObject != null) {
            aVar.b = b(optJSONObject.optJSONObject("scan_settings"));
            aVar.c = a(optJSONObject.optJSONArray("filters"));
            Long a3 = abc.a(optJSONObject, "same_beacon_min_reporting_interval");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            aVar.d = abw.a(a3, timeUnit, aVar.d);
            aVar.e = abw.a(abc.a(optJSONObject, "first_delay_seconds"), timeUnit, aVar.e);
        } else {
            aVar.b = new ve.a.C0352a.b();
        }
        return aVar;
    }

    @NonNull
    private ve.a.C0352a.C0353a[] a(@Nullable JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                ve.a.C0352a.C0353a c2 = c(jSONArray.optJSONObject(i));
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
        }
        return (ve.a.C0352a.C0353a[]) arrayList.toArray(new ve.a.C0352a.C0353a[arrayList.size()]);
    }

    @Nullable
    private Integer a(@NonNull JSONObject jSONObject, @NonNull String str, Map<String, Integer> map) {
        if (jSONObject.has(str)) {
            return map.get(jSONObject.optString(str));
        }
        return null;
    }
}
