package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.abc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class wv {
    @NonNull
    public List<wu> a(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new abc.a(str).optJSONArray("sdk_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("name");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("classes");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                try {
                                    String optString2 = optJSONArray2.getJSONObject(i2).optString("name");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        arrayList2.add(optString2);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!dl.a((Collection) arrayList2)) {
                            arrayList.add(new wu(optString, arrayList2));
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }
}
