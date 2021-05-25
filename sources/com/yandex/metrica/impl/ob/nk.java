package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
public class nk implements np<pt, ve.a.d.C0355a.C0356a> {
    @NonNull
    private final nj a;

    public nk() {
        this(new nj());
    }

    @VisibleForTesting
    public nk(@NonNull nj njVar) {
        this.a = njVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.d.C0355a.C0356a b(@NonNull pt ptVar) {
        ve.a.d.C0355a.C0356a aVar = new ve.a.d.C0355a.C0356a();
        rk rkVar = ptVar.a;
        aVar.b = rkVar.a;
        aVar.c = rkVar.b;
        ps psVar = ptVar.b;
        if (psVar != null) {
            aVar.d = this.a.b(psVar);
        }
        return aVar;
    }

    @NonNull
    public pt a(@NonNull ve.a.d.C0355a.C0356a aVar) {
        ve.a.d.C0355a.C0356a.C0357a aVar2 = aVar.d;
        return new pt(new rk(aVar.b, aVar.c), aVar2 != null ? this.a.a(aVar2) : null);
    }
}
