package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import org.json.JSONObject;
public class yp {
    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        long j;
        long j2;
        if (yxVar.a().c) {
            JSONObject optJSONObject = aVar.optJSONObject("permissions_collecting");
            ve.a.f fVar = new ve.a.f();
            if (optJSONObject != null) {
                j2 = optJSONObject.optLong("check_interval_seconds", fVar.b);
                j = optJSONObject.optLong("force_send_interval_seconds", fVar.c);
            } else {
                j2 = fVar.b;
                j = fVar.c;
            }
            yxVar.a(new xo(j2, j));
        }
    }
}
