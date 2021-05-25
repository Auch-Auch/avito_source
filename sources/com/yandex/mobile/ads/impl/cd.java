package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.bn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class cd implements ce<bm> {
    @NonNull
    private final bu a = new bu();

    @Nullable
    public static bm a(@NonNull rx rxVar) {
        String a3 = bu.a(rxVar);
        if (!TextUtils.isEmpty(a3)) {
            return a(a3);
        }
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.ce
    @Nullable
    public final /* synthetic */ bm b(@NonNull rx rxVar) {
        return a(rxVar);
    }

    @Nullable
    private static bn b(@NonNull JSONObject jSONObject) {
        try {
            String c = dx.c(jSONObject, "adapter");
            Map<String, String> a3 = dx.a(jSONObject, "network_data");
            if (a3.isEmpty()) {
                return null;
            }
            List<String> b = dx.b(jSONObject, "click_tracking_urls");
            List<String> b2 = dx.b(jSONObject, "impression_tracking_urls");
            return new bn.a(c, a3).a(b2).b(b).c(dx.b(jSONObject, "ad_response_tracking_urls")).a();
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private static bm a(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Map<String, String> a3 = a(jSONObject);
            if (a3.isEmpty()) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("networks");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                bn b = b(jSONArray.getJSONObject(i));
                if (b != null) {
                    arrayList.add(b);
                }
            }
            if (!arrayList.isEmpty()) {
                return new bm(arrayList, a3);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    @NonNull
    private static Map<String, String> a(@NonNull JSONObject jSONObject) throws JSONException {
        try {
            return dx.a(jSONObject, "passback_parameters");
        } catch (JSONException e) {
            throw new JSONException(e.getMessage());
        }
    }
}
