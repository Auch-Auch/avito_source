package com.yandex.metrica.impl.ob;

import android.os.HandlerThread;
import android.support.annotation.NonNull;
public class acw extends HandlerThread implements acv {
    private volatile boolean a = true;

    public acw(@NonNull String str) {
        super(str);
    }

    @Override // com.yandex.metrica.impl.ob.acv
    public synchronized boolean c() {
        return this.a;
    }
}
