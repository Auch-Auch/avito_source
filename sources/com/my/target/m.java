package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
public class m extends c<bs> {
    public final int a;

    public m(int i) {
        this.a = i;
    }

    @NonNull
    public static c<bs> a(int i) {
        return new m(i);
    }

    @Nullable
    public bs a(@NonNull String str, @NonNull bp bpVar, @Nullable bs bsVar, @NonNull a aVar, @NonNull Context context) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        JSONObject a3 = a(str, context);
        if (a3 == null || (optJSONObject = a3.optJSONObject(aVar.getFormat())) == null || (optJSONArray = optJSONObject.optJSONArray("banners")) == null || optJSONArray.length() <= 0 || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        br newBanner = br.newBanner();
        String optString = optJSONObject2.optString("id");
        if (TextUtils.isEmpty(optString)) {
            optString = optJSONObject2.optString("bannerID", newBanner.getId());
        }
        newBanner.setId(optString);
        String optString2 = optJSONObject2.optString("type");
        if (!TextUtils.isEmpty(optString2)) {
            newBanner.setType(optString2);
        }
        if (optJSONObject2.optJSONArray("statistics") != null) {
            dy.i(bpVar, aVar, context).a(newBanner.getStatHolder(), optJSONObject2, optString, (float) this.a);
        }
        if (!newBanner.getStatHolder().cC()) {
            return null;
        }
        bs bq = bs.bq();
        bq.a(newBanner);
        return bq;
    }
}
