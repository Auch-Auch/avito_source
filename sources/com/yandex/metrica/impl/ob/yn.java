package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.avito.android.remote.model.Navigation;
import com.google.firebase.messaging.Constants;
import com.yandex.metrica.impl.ob.ve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public class yn {
    private static final Map<String, Integer> a = Collections.unmodifiableMap(new HashMap<String, Integer>() { // from class: com.yandex.metrica.impl.ob.yn.1
        {
            put("FOREGROUND", 1);
            put("BACKGROUND", 0);
            put("VISIBLE", 2);
        }
    });

    @NonNull
    private static ve.a.d.C0355a.C0356a b(@Nullable JSONObject jSONObject) {
        return a(jSONObject, false);
    }

    @NonNull
    private static ve.a.d.C0355a.C0356a.C0357a c(@NonNull JSONObject jSONObject) {
        ve.a.d.C0355a.C0356a.C0357a aVar = new ve.a.d.C0355a.C0356a.C0357a();
        aVar.b = ((Long) abw.b(abc.a(jSONObject, "duration_seconds"), Long.valueOf(aVar.b))).longValue();
        aVar.c = ((Long) abw.b(abc.a(jSONObject, "interval_seconds"), Long.valueOf(aVar.c))).longValue();
        return aVar;
    }

    private int[] d(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("charge_types");
        int i = 0;
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if ("USB".equals(optString)) {
                    arrayList.add(1);
                } else if ("AC".equals(optString)) {
                    arrayList.add(3);
                } else if ("NONE".equals(optString)) {
                    arrayList.add(0);
                } else if ("WIRELESS".equals(optString)) {
                    arrayList.add(2);
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    private static int[] e(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("app_statuses");
        int i = 0;
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                Integer num = a.get(optJSONArray.optString(i2, ""));
                if (num != null) {
                    arrayList.add(num);
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public void a(@NonNull yx yxVar, @NonNull JSONObject jSONObject) {
        ve.a.d a3;
        ns nsVar = new ns();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("location_collecting");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (a3 = a(optJSONObject, yxVar.a())) == null)) {
                    arrayList.add(nsVar.a(a3));
                }
            }
        }
        yxVar.f(arrayList);
    }

    @Nullable
    private ve.a.d a(@NonNull JSONObject jSONObject, @NonNull xk xkVar) {
        ve.a.d dVar = new ve.a.d();
        JSONObject optJSONObject = jSONObject.optJSONObject(Navigation.CONFIG);
        ve.a.d.C0355a aVar = new ve.a.d.C0355a();
        dVar.b = aVar;
        if (optJSONObject != null) {
            Long a3 = abc.a(optJSONObject, "min_update_interval_seconds");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            aVar.b = abw.a(a3, timeUnit, dVar.b.b);
            dVar.b.c = ((Float) abw.b(abc.e(optJSONObject, "min_update_distance_meters"), Float.valueOf(dVar.b.c))).floatValue();
            dVar.b.d = ((Integer) abw.b(abc.c(optJSONObject, "records_count_to_force_flush"), Integer.valueOf(dVar.b.d))).intValue();
            dVar.b.e = ((Integer) abw.b(abc.c(optJSONObject, "max_records_count_in_batch"), Integer.valueOf(dVar.b.e))).intValue();
            dVar.b.f = abw.a(abc.a(optJSONObject, "max_age_seconds_to_force_flush"), timeUnit, dVar.b.f);
            dVar.b.g = ((Integer) abw.b(abc.c(optJSONObject, "max_records_to_store_locally"), Integer.valueOf(dVar.b.g))).intValue();
            dVar.b.k = abw.a(abc.a(optJSONObject, "lbs_min_update_interval_seconds"), timeUnit, dVar.b.k);
            boolean z = false;
            dVar.b.h = ((Boolean) abw.b(abc.d(optJSONObject, "location_collecting_enabled"), Boolean.valueOf(dVar.b.h))).booleanValue() && xkVar.h;
            dVar.b.i = ((Boolean) abw.b(abc.d(optJSONObject, "lbs_collecting_enabled"), Boolean.valueOf(dVar.b.i))).booleanValue() && xkVar.i;
            ve.a.d.C0355a aVar2 = dVar.b;
            if (((Boolean) abw.b(abc.d(optJSONObject, "passive_collecting_enabled"), Boolean.valueOf(dVar.b.j))).booleanValue() && xkVar.h) {
                z = true;
            }
            aVar2.j = z;
            if (xkVar.q) {
                dVar.b.l = b(optJSONObject.optJSONObject("wifi_access_config"));
            }
            ve.a.d.C0355a aVar3 = dVar.b;
            if (aVar3.i) {
                aVar3.m = b(optJSONObject.optJSONObject("lbs_access_config"));
            }
            ve.a.d.C0355a aVar4 = dVar.b;
            if (aVar4.h) {
                aVar4.n = b(optJSONObject.optJSONObject("gps_access_config"));
            }
            ve.a.d.C0355a aVar5 = dVar.b;
            if (aVar5.j) {
                aVar5.o = a(optJSONObject.optJSONObject("passive_access_config"), true);
            }
            if (xkVar.k) {
                dVar.b.p = a(optJSONObject.optJSONObject("gpl_access_config"));
            }
        }
        dVar.c = new ve.a.d.b();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("preconditions");
        if (optJSONObject2 != null) {
            dVar.c.b = d(optJSONObject2);
            dVar.c.c = e(optJSONObject2);
        }
        return dVar;
    }

    @NonNull
    private static ve.a.d.C0355a.b a(@Nullable JSONObject jSONObject) {
        ve.a.d.C0355a.b bVar = new ve.a.d.C0355a.b();
        bVar.c = ((Boolean) abw.b(abc.d(jSONObject, "scanning_enabled"), Boolean.valueOf(bVar.c))).booleanValue();
        bVar.b = ((Boolean) abw.b(abc.d(jSONObject, "last_known_enabled"), Boolean.valueOf(bVar.b))).booleanValue();
        if (bVar.c) {
            Integer num = null;
            String b = abc.b(jSONObject, Constants.FirelogAnalytics.PARAM_PRIORITY);
            Long a3 = abc.a(jSONObject, "duration_seconds");
            Long a4 = abc.a(jSONObject, "interval_seconds");
            if (b != null) {
                if (b.equals("PRIORITY_NO_POWER")) {
                    num = 0;
                } else if (b.equals("PRIORITY_LOW_POWER")) {
                    num = 1;
                } else if (b.equals("PRIORITY_BALANCED_POWER_ACCURACY")) {
                    num = 2;
                } else if (b.equals("PRIORITY_HIGH_ACCURACY")) {
                    num = 3;
                }
            }
            if (!(num == null || a3 == null || a4 == null)) {
                ve.a.d.C0355a.b.C0358a aVar = new ve.a.d.C0355a.b.C0358a();
                aVar.b = a3.longValue();
                aVar.c = a4.longValue();
                aVar.d = num.intValue();
                bVar.d = aVar;
            }
        }
        return bVar;
    }

    @NonNull
    private static ve.a.d.C0355a.C0356a a(@Nullable JSONObject jSONObject, boolean z) {
        ve.a.d.C0355a.C0356a aVar = new ve.a.d.C0355a.C0356a();
        aVar.b = ((Boolean) abw.b(abc.d(jSONObject, "last_known_enabled"), Boolean.valueOf(aVar.b))).booleanValue();
        boolean booleanValue = ((Boolean) abw.b(abc.d(jSONObject, "scanning_enabled"), Boolean.valueOf(z))).booleanValue();
        aVar.c = booleanValue;
        if (jSONObject != null && booleanValue) {
            aVar.d = c(jSONObject);
        }
        return aVar;
    }
}
