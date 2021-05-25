package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class pk implements ra {
    @NonNull
    private final abt a;
    @NonNull
    private final qe b;

    public pk(@NonNull qe qeVar) {
        this(qeVar, new abs());
    }

    @Override // com.yandex.metrica.impl.ob.ra
    public void a() {
        this.b.a(this.a.b());
    }

    @VisibleForTesting
    public pk(@NonNull qe qeVar, @NonNull abt abt) {
        this.b = qeVar;
        this.a = abt;
    }
}
