package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
public class nr implements np<ql, ve.a.d.C0355a> {
    @NonNull
    private final nk a;
    @NonNull
    private final nm b;

    public nr() {
        this(new nk(), new nm());
    }

    @VisibleForTesting
    public nr(@NonNull nk nkVar, @NonNull nm nmVar) {
        this.a = nkVar;
        this.b = nmVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.d.C0355a b(@NonNull ql qlVar) {
        ve.a.d.C0355a aVar = new ve.a.d.C0355a();
        aVar.b = qlVar.a;
        aVar.c = qlVar.b;
        aVar.d = qlVar.c;
        aVar.e = qlVar.d;
        aVar.f = qlVar.e;
        aVar.g = qlVar.f;
        aVar.h = qlVar.g;
        aVar.k = qlVar.h;
        aVar.i = qlVar.i;
        aVar.j = qlVar.j;
        pt ptVar = qlVar.k;
        if (ptVar != null) {
            aVar.l = this.a.b(ptVar);
        }
        pt ptVar2 = qlVar.l;
        if (ptVar2 != null) {
            aVar.m = this.a.b(ptVar2);
        }
        pt ptVar3 = qlVar.m;
        if (ptVar3 != null) {
            aVar.n = this.a.b(ptVar3);
        }
        pt ptVar4 = qlVar.n;
        if (ptVar4 != null) {
            aVar.o = this.a.b(ptVar4);
        }
        py pyVar = qlVar.o;
        if (pyVar != null) {
            aVar.p = this.b.b(pyVar);
        }
        return aVar;
    }

    @NonNull
    public ql a(@NonNull ve.a.d.C0355a aVar) {
        ve.a.d.C0355a.C0356a aVar2 = aVar.l;
        py pyVar = null;
        pt a3 = aVar2 != null ? this.a.a(aVar2) : null;
        ve.a.d.C0355a.C0356a aVar3 = aVar.m;
        pt a4 = aVar3 != null ? this.a.a(aVar3) : null;
        ve.a.d.C0355a.C0356a aVar4 = aVar.n;
        pt a5 = aVar4 != null ? this.a.a(aVar4) : null;
        ve.a.d.C0355a.C0356a aVar5 = aVar.o;
        pt a6 = aVar5 != null ? this.a.a(aVar5) : null;
        ve.a.d.C0355a.b bVar = aVar.p;
        if (bVar != null) {
            pyVar = this.b.a(bVar);
        }
        return new ql(aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h, aVar.k, aVar.i, aVar.j, a3, a4, a5, a6, pyVar);
    }
}
