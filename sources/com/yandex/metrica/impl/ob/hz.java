package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class hz extends hu {
    private mm a;

    public hz(fe feVar) {
        super(feVar);
        this.a = feVar.u();
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        fe a3 = a();
        a3.c().toString();
        if (!this.a.d() || !a3.q()) {
            return false;
        }
        a3.e().b(aa.a(aaVar, a3));
        return false;
    }
}
