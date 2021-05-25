package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class px extends pq implements pz {
    @Nullable
    private volatile py a;

    public px(@NonNull act act, @Nullable py pyVar) {
        super(act);
        this.a = pyVar;
    }

    @Override // com.yandex.metrica.impl.ob.pm
    public void a(@NonNull Runnable runnable) {
        pw pwVar;
        py pyVar = this.a;
        if (pyVar != null && (pwVar = pyVar.b) != null) {
            a(runnable, pwVar.b);
        }
    }

    @Override // com.yandex.metrica.impl.ob.pz
    public void a(@Nullable py pyVar) {
        this.a = pyVar;
    }
}
