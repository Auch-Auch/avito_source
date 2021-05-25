package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import org.json.JSONObject;
public class ym {
    @NonNull
    private final nn a;

    public ym() {
        this(new nn());
    }

    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        if (yxVar.a().f) {
            ve.a.c cVar = new ve.a.c();
            JSONObject optJSONObject = aVar.optJSONObject("identity_light_collecting");
            if (optJSONObject != null) {
                cVar.b = optJSONObject.optLong("min_interval_seconds", cVar.b);
            }
            yxVar.a(this.a.a(cVar));
        }
    }

    @VisibleForTesting
    public ym(@NonNull nn nnVar) {
        this.a = nnVar;
    }
}
