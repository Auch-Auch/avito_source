package com.yandex.metrica.impl.ob;

import android.os.SystemClock;
public class abs implements abt {
    @Override // com.yandex.metrica.impl.ob.abt
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.yandex.metrica.impl.ob.abt
    public long b() {
        return System.currentTimeMillis() / 1000;
    }

    @Override // com.yandex.metrica.impl.ob.abt
    public long c() {
        return SystemClock.elapsedRealtime();
    }

    public long d() {
        return System.nanoTime();
    }
}
