package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
public class of implements np<xi, ve.a.C0352a> {
    @NonNull
    private final oj a;
    @NonNull
    private final oi b;

    public of() {
        this(new oj(), new oi());
    }

    @VisibleForTesting
    public of(@NonNull oj ojVar, @NonNull oi oiVar) {
        this.a = ojVar;
        this.b = oiVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.C0352a b(@NonNull xi xiVar) {
        ve.a.C0352a aVar = new ve.a.C0352a();
        aVar.b = this.a.b(xiVar.a);
        aVar.c = this.b.b(xiVar.b);
        aVar.d = xiVar.c;
        aVar.e = xiVar.d;
        return aVar;
    }

    @NonNull
    public xi a(@NonNull ve.a.C0352a aVar) {
        return new xi(this.a.a(aVar.b), this.b.a(aVar.c), aVar.d, aVar.e);
    }
}
