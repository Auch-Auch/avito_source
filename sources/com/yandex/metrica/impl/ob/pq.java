package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;
public abstract class pq implements pm {
    @NonNull
    private act a;
    @Nullable
    private volatile Runnable b;

    public pq(@NonNull act act) {
        this.a = act;
    }

    public void a(@NonNull Runnable runnable, long j) {
        this.a.a(runnable, j, TimeUnit.SECONDS);
        this.b = runnable;
    }

    @Override // com.yandex.metrica.impl.ob.pm
    public void a() {
        Runnable runnable = this.b;
        if (runnable != null) {
            this.a.b(runnable);
            this.b = null;
        }
    }
}
