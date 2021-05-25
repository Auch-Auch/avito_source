package com.yandex.metrica.impl.ob;

import android.os.SystemClock;
public class ar {
    private long a = (SystemClock.elapsedRealtime() - 2000000);
    private boolean b = true;

    public boolean a() {
        boolean z = this.b;
        this.b = false;
        return a(z);
    }

    public void b() {
        this.b = true;
        this.a = SystemClock.elapsedRealtime();
    }

    public boolean c() {
        return this.b;
    }

    private boolean a(boolean z) {
        return z && SystemClock.elapsedRealtime() - this.a > 1000;
    }
}
