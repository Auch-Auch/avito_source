package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
public class yt {
    @NonNull
    private final oa a;

    public yt() {
        this(new oa());
    }

    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        ve.a.h hVar = new ve.a.h();
        JSONObject optJSONObject = aVar.optJSONObject("sdk_list");
        if (optJSONObject != null) {
            Long a3 = abc.a(optJSONObject, "min_collecting_interval_seconds");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            hVar.b = abw.a(a3, timeUnit, hVar.b);
            hVar.c = abw.a(abc.a(optJSONObject, "min_first_collecting_delay_seconds"), timeUnit, hVar.c);
            hVar.d = abw.a(abc.a(optJSONObject, "min_collecting_delay_after_launch_seconds"), timeUnit, hVar.d);
            hVar.e = abw.a(abc.a(optJSONObject, "min_request_retry_interval_seconds"), timeUnit, hVar.e);
        }
        yxVar.a(this.a.a(hVar));
    }

    @VisibleForTesting
    public yt(@NonNull oa oaVar) {
        this.a = oaVar;
    }
}
