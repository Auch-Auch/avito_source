package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class acx extends Thread implements acv {
    private volatile boolean a = true;

    public acx() {
    }

    public synchronized void b() {
        this.a = false;
        interrupt();
    }

    @Override // com.yandex.metrica.impl.ob.acv
    public synchronized boolean c() {
        return this.a;
    }

    public acx(@NonNull Runnable runnable, @NonNull String str) {
        super(runnable, str);
    }

    public acx(@NonNull String str) {
        super(str);
    }
}
