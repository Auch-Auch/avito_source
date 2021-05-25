package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
public class nm implements np<py, ve.a.d.C0355a.b> {
    @NonNull
    private final nl a;

    public nm() {
        this(new nl());
    }

    @VisibleForTesting
    public nm(@NonNull nl nlVar) {
        this.a = nlVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.d.C0355a.b b(@NonNull py pyVar) {
        ve.a.d.C0355a.b bVar = new ve.a.d.C0355a.b();
        rk rkVar = pyVar.a;
        bVar.b = rkVar.a;
        bVar.c = rkVar.b;
        pw pwVar = pyVar.b;
        if (pwVar != null) {
            bVar.d = this.a.b(pwVar);
        }
        return bVar;
    }

    @NonNull
    public py a(@NonNull ve.a.d.C0355a.b bVar) {
        ve.a.d.C0355a.b.C0358a aVar = bVar.d;
        return new py(new rk(bVar.b, bVar.c), aVar != null ? this.a.a(aVar) : null);
    }
}
