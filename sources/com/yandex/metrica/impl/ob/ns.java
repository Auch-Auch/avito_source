package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
public class ns implements np<qm, ve.a.d> {
    @NonNull
    private final nr a;
    @NonNull
    private final nt b;

    public ns() {
        this(new nr(), new nt());
    }

    @VisibleForTesting
    public ns(@NonNull nr nrVar, @NonNull nt ntVar) {
        this.a = nrVar;
        this.b = ntVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.d b(@NonNull qm qmVar) {
        ve.a.d dVar = new ve.a.d();
        dVar.b = this.a.b(qmVar.a);
        dVar.c = this.b.b(qmVar.b);
        return dVar;
    }

    @NonNull
    public qm a(@NonNull ve.a.d dVar) {
        return new qm(this.a.a((ve.a.d.C0355a) abw.b(dVar.b, new ve.a.d.C0355a())), this.b.a((ve.a.d.b) abw.b(dVar.c, new ve.a.d.b())));
    }
}
