package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.abc;
import com.yandex.metrica.impl.ob.ve;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public class yo {
    public void a(@NonNull yx yxVar, @NonNull abc.a aVar) {
        if (yxVar.a().j) {
            yxVar.a(new nu().a(a(aVar)));
        }
    }

    @NonNull
    private ve.a.m a(@NonNull abc.a aVar) {
        ve.a.m mVar = new ve.a.m();
        JSONObject optJSONObject = aVar.optJSONObject("wakeup");
        if (optJSONObject == null) {
            return mVar;
        }
        mVar.b = abw.a(abc.a(optJSONObject, "collection_duration_seconds"), TimeUnit.SECONDS, mVar.b);
        mVar.c = abc.a(optJSONObject, "aggressive_relaunch", mVar.c);
        mVar.d = a(optJSONObject.optJSONArray("collection_interval_ranges_seconds"), mVar.d);
        return mVar;
    }

    private ve.a.m.C0360a[] a(@Nullable JSONArray jSONArray, ve.a.m.C0360a[] aVarArr) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                aVarArr = new ve.a.m.C0360a[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    aVarArr[i] = new ve.a.m.C0360a();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ve.a.m.C0360a aVar = aVarArr[i];
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    aVar.b = timeUnit.toMillis(jSONObject.getLong("min"));
                    aVarArr[i].c = timeUnit.toMillis(jSONObject.getLong("max"));
                }
            } catch (Throwable unused) {
            }
        }
        return aVarArr;
    }
}
