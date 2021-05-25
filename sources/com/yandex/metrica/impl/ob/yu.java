package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.avito.android.social.AppleSignInManagerKt;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
public class yu {
    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        JSONObject optJSONObject;
        if (yxVar.C() && (optJSONObject = aVar.optJSONObject("socket")) != null) {
            long optLong = optJSONObject.optLong("seconds_to_live");
            long optLong2 = optJSONObject.optLong("first_delay_seconds", new ve.a.i().e);
            int optInt = optJSONObject.optInt("launch_delay_seconds", new ve.a.i().f);
            String optString = optJSONObject.optString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            JSONArray optJSONArray = optJSONObject.optJSONArray("ports");
            if (optLong > 0 && !TextUtils.isEmpty(optString) && optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    int optInt2 = optJSONArray.optInt(i);
                    if (optInt2 != 0) {
                        arrayList.add(Integer.valueOf(optInt2));
                    }
                }
                if (!arrayList.isEmpty()) {
                    yxVar.a(new xs(optLong, optString, arrayList, optLong2, optInt));
                }
            }
        }
    }
}
