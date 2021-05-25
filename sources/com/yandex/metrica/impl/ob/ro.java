package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
public abstract class ro implements ph {
    @NonNull
    private final dj a;
    @NonNull
    private final qe b;

    public ro(@NonNull qe qeVar, @NonNull dj djVar) {
        this.b = qeVar;
        this.a = djVar;
    }

    public boolean a(long j) {
        dj djVar = this.a;
        long a3 = this.b.a();
        StringBuilder L = a.L("last ");
        L.append(c());
        L.append(" scan attempt");
        return djVar.a(a3, j, L.toString());
    }

    @NonNull
    public abstract String c();
}
