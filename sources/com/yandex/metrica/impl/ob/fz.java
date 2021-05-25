package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ew;
public class fz extends fe {
    private final String b;
    private final df c;

    public fz(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull df dfVar, @NonNull yb ybVar, @NonNull ye yeVar) {
        super(context, ybVar, fbVar, aVar, new fx(dfVar), yeVar);
        this.b = fbVar.a();
        this.c = dfVar;
    }

    @Override // com.yandex.metrica.impl.ob.fe, com.yandex.metrica.impl.ob.fk
    public synchronized void a(@NonNull ew.a aVar) {
        super.a(aVar);
        this.c.a(this.b, aVar.m);
    }
}
