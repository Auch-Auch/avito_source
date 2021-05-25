package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.du;
import org.json.JSONArray;
import org.json.JSONObject;
public class t extends c<cs> implements du.a {
    @NonNull
    public static c<cs> f() {
        return new t();
    }

    @Nullable
    public cs a(@NonNull String str, @NonNull bp bpVar, @Nullable cs csVar, @NonNull a aVar, @NonNull Context context) {
        JSONObject optJSONObject;
        cl i;
        JSONObject a = a(str, context);
        if (a == null) {
            return null;
        }
        if (csVar == null) {
            csVar = cs.cg();
        }
        JSONObject optJSONObject2 = a.optJSONObject(aVar.getFormat());
        if (optJSONObject2 != null) {
            JSONArray optJSONArray = optJSONObject2.optJSONArray("banners");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                dv g = dv.g(bpVar, aVar, context);
                int bannersCount = aVar.getBannersCount();
                if (bannersCount > 0) {
                    int length = optJSONArray.length();
                    if (bannersCount > length) {
                        bannersCount = length;
                    }
                } else {
                    bannersCount = 1;
                }
                for (int i2 = 0; i2 < bannersCount; i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        cg newBanner = cg.newBanner();
                        g.a(optJSONObject3, newBanner);
                        csVar.a(newBanner);
                    }
                }
                if (csVar.getBannersCount() > 0) {
                    return csVar;
                }
            }
            return null;
        } else if (!aVar.isMediationEnabled() || (optJSONObject = a.optJSONObject("mediation")) == null || (i = du.a(this, bpVar, aVar, context).i(optJSONObject)) == null) {
            return null;
        } else {
            csVar.a(i);
            return csVar;
        }
    }

    @Override // com.my.target.du.a
    @Nullable
    public cn b(@NonNull JSONObject jSONObject, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        cs cg = cs.cg();
        dv g = dv.g(bpVar, aVar, context);
        cg newBanner = cg.newBanner();
        g.a(jSONObject, newBanner);
        cg.a(newBanner);
        return cg;
    }
}
