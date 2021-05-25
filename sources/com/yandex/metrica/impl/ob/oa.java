package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
public class oa implements nh<xr, ve.a.h> {
    @NonNull
    /* renamed from: a */
    public ve.a.h b(@NonNull xr xrVar) {
        ve.a.h hVar = new ve.a.h();
        hVar.b = xrVar.a;
        hVar.c = xrVar.b;
        hVar.d = xrVar.c;
        hVar.e = xrVar.d;
        return hVar;
    }

    @NonNull
    public xr a(@NonNull ve.a.h hVar) {
        return new xr(hVar.b, hVar.c, hVar.d, hVar.e);
    }
}
