package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.xp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class yr {
    private static final Map<String, xp.a> a = Collections.unmodifiableMap(new HashMap<String, xp.a>() { // from class: com.yandex.metrica.impl.ob.yr.1
        {
            put("wifi", xp.a.WIFI);
            put("cell", xp.a.CELL);
        }
    });

    @NonNull
    private static List<xp.a> b(@NonNull JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("accept_network_types")) {
            JSONArray jSONArray = jSONObject.getJSONArray("accept_network_types");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(a.get(jSONArray.getString(i)));
            }
        }
        return arrayList;
    }

    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        JSONArray optJSONArray;
        JSONObject optJSONObject = aVar.optJSONObject("requests");
        if (!(optJSONObject == null || !optJSONObject.has("list") || (optJSONArray = optJSONObject.optJSONArray("list")) == null)) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(a(optJSONArray.getJSONObject(i)));
                } catch (Throwable unused) {
                }
            }
            if (!arrayList.isEmpty()) {
                yxVar.d(arrayList);
            }
        }
    }

    @NonNull
    private xp a(@NonNull JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("headers");
        ArrayList arrayList = new ArrayList(jSONObject2.length());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray jSONArray = jSONObject2.getJSONArray(next);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new Pair(next, jSONArray.getString(i)));
            }
        }
        return new xp(abc.b(jSONObject, "id"), abc.b(jSONObject, "url"), abc.b(jSONObject, "method"), arrayList, Long.valueOf(jSONObject.getLong("delay_seconds")), b(jSONObject));
    }
}
