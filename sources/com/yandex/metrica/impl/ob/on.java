package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
public class on implements nh<aap, ve.a.l> {
    @NonNull
    /* renamed from: a */
    public ve.a.l b(@NonNull aap aap) {
        ve.a.l lVar = new ve.a.l();
        lVar.b = aap.a;
        lVar.c = aap.b;
        lVar.d = aap.c;
        lVar.e = aap.d;
        lVar.f = aap.e;
        return lVar;
    }

    @NonNull
    public aap a(@NonNull ve.a.l lVar) {
        return new aap(lVar.b, lVar.c, lVar.d, lVar.e, lVar.f);
    }
}
