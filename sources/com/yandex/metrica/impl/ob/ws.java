package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class ws {
    @NonNull
    public List<wu> a(@NonNull List<wu> list) {
        ArrayList arrayList = new ArrayList();
        for (wu wuVar : list) {
            ArrayList arrayList2 = new ArrayList(wuVar.b.size());
            for (String str : wuVar.b) {
                if (cx.b(str)) {
                    arrayList2.add(str);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new wu(wuVar.a, arrayList2));
            }
        }
        return arrayList;
    }

    @NonNull
    public JSONObject b(@NonNull List<wu> list) {
        JSONObject jSONObject = new JSONObject();
        for (wu wuVar : list) {
            try {
                jSONObject.put(wuVar.a, new JSONObject().put("classes", new JSONArray((Collection) wuVar.b)));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }
}
