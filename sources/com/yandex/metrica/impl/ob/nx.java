package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
public class nx implements np<xo, ve.a.f> {
    @NonNull
    /* renamed from: a */
    public ve.a.f b(@NonNull xo xoVar) {
        ve.a.f fVar = new ve.a.f();
        fVar.b = xoVar.a;
        fVar.c = xoVar.b;
        return fVar;
    }

    @NonNull
    public xo a(@NonNull ve.a.f fVar) {
        return new xo(fVar.b, fVar.c);
    }
}
