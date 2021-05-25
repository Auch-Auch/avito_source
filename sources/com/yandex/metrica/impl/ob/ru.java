package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uu;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
public class ru {
    @NonNull
    public uu.b.a a(@NonNull qk qkVar) {
        int i;
        int i2;
        uu.b.a aVar = new uu.b.a();
        aVar.b = qkVar.a() == null ? aVar.b : qkVar.a().longValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVar.c = timeUnit.toSeconds(qkVar.b());
        aVar.f = timeUnit.toSeconds(qkVar.e());
        if (qkVar.f() == null) {
            i = 0;
        } else {
            i = ci.a(qkVar.f());
        }
        aVar.g = i;
        if (qkVar.g() == null) {
            i2 = 3;
        } else {
            i2 = ci.a(qkVar.g());
        }
        aVar.h = i2;
        JSONArray d = qkVar.d();
        if (d != null) {
            aVar.d = ci.b(d);
        }
        JSONArray c = qkVar.c();
        if (c != null) {
            aVar.e = ci.a(c);
        }
        return aVar;
    }
}
