package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.abc;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;
public class yl {
    private List<String> b(JSONObject jSONObject, String str) {
        try {
            return abc.a(jSONObject.getJSONObject(str).getJSONArray("urls"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        try {
            JSONObject optJSONObject = ((JSONObject) aVar.a("query_hosts", new JSONObject())).optJSONObject("list");
            if (optJSONObject != null) {
                String a = a(optJSONObject, "get_ad");
                if (!TextUtils.isEmpty(a)) {
                    yxVar.b(a);
                }
                List<String> b = b(optJSONObject, "report");
                if (!dl.a((Collection) b)) {
                    yxVar.b(b);
                }
                String a3 = a(optJSONObject, "report_ad");
                if (!TextUtils.isEmpty(a3)) {
                    yxVar.c(a3);
                }
                List<String> b2 = b(optJSONObject, "location");
                if (!dl.a((Collection) b2)) {
                    yxVar.c(b2);
                }
                List<String> b3 = b(optJSONObject, "startup");
                if (!dl.a((Collection) b3)) {
                    yxVar.a(b3);
                }
                List<String> b4 = b(optJSONObject, "diagnostic");
                if (!dl.a((Collection) b4)) {
                    yxVar.e(b4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str).getJSONArray("urls").getString(0);
        } catch (Throwable unused) {
            return "";
        }
    }
}
