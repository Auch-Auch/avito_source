package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import org.json.JSONObject;
public class ys {
    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        ve.a aVar2 = new ve.a();
        JSONObject optJSONObject = aVar.optJSONObject("retry_policy");
        int i = aVar2.I;
        int i2 = aVar2.J;
        if (optJSONObject != null) {
            i = optJSONObject.optInt("max_interval_seconds", i);
            i2 = optJSONObject.optInt("exponential_multiplier", aVar2.J);
        }
        yxVar.a(new xq(i, i2));
    }
}
