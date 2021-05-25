package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class pj extends pq implements qn {
    @Nullable
    private volatile pt a;

    public pj(@NonNull act act, @Nullable pt ptVar) {
        super(act);
        this.a = ptVar;
    }

    @Override // com.yandex.metrica.impl.ob.pm
    public void a(@NonNull Runnable runnable) {
        ps psVar;
        pt ptVar = this.a;
        if (ptVar != null && (psVar = ptVar.b) != null) {
            a(runnable, psVar.a);
        }
    }

    @Override // com.yandex.metrica.impl.ob.qn
    public void a(@Nullable pt ptVar) {
        this.a = ptVar;
    }
}
