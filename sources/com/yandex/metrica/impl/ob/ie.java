package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class ie extends hu {
    private mm a;

    public ie(fe feVar) {
        this(feVar, feVar.u());
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        aa aaVar2;
        fe a3 = a();
        if (this.a.c()) {
            return false;
        }
        if (a3.i().S()) {
            aaVar2 = aa.e(aaVar);
        } else {
            aaVar2 = aa.c(aaVar);
        }
        a3.e().e(aaVar2.c(this.a.d("")));
        this.a.a();
        this.a.e();
        return false;
    }

    @VisibleForTesting
    public ie(fe feVar, mm mmVar) {
        super(feVar);
        this.a = mmVar;
    }
}
