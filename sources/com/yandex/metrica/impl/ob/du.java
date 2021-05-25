package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
@TargetApi(21)
public class du {
    @NonNull
    private final xl a;
    @NonNull
    private final dx b;
    @NonNull
    private final ds c;
    private Boolean d;

    public du(@NonNull Context context, @NonNull dx dxVar) {
        this(dxVar, new ds(context), new xl());
    }

    public void a(@NonNull Context context) {
        yb a3 = this.a.a(context);
        xi xiVar = a3.I;
        if (xiVar != null && this.c.a(a3, xiVar)) {
            if (!this.c.b(a3, xiVar)) {
                this.b.a();
                this.d = Boolean.FALSE;
            } else if (aau.b(this.d)) {
                this.b.a(a3.I);
                this.d = Boolean.TRUE;
            }
        }
    }

    @VisibleForTesting
    public du(@NonNull dx dxVar, @NonNull ds dsVar, @NonNull xl xlVar) {
        this.b = dxVar;
        this.c = dsVar;
        this.a = xlVar;
    }
}
