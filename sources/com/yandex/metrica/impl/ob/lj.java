package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.us;
public class lj implements nh<lc, us.e> {
    @NonNull
    private lh a = new lh();

    @NonNull
    /* renamed from: a */
    public us.e b(@NonNull lc lcVar) {
        us.e eVar = new us.e();
        Integer num = lcVar.e;
        eVar.f = num == null ? -1 : num.intValue();
        eVar.e = lcVar.d;
        eVar.c = lcVar.b;
        eVar.b = lcVar.a;
        eVar.d = lcVar.c;
        eVar.g = this.a.b(lcVar.f);
        return eVar;
    }

    @NonNull
    public lc a(@NonNull us.e eVar) {
        throw new UnsupportedOperationException();
    }
}
