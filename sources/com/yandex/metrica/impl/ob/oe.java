package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
public class oe implements nh<yd, ve.a.j> {
    @NonNull
    /* renamed from: a */
    public ve.a.j b(@NonNull yd ydVar) {
        ve.a.j jVar = new ve.a.j();
        jVar.b = ydVar.a;
        return jVar;
    }

    @NonNull
    public yd a(@NonNull ve.a.j jVar) {
        return new yd(jVar.b);
    }
}
