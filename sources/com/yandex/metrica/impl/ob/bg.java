package com.yandex.metrica.impl.ob;

import android.os.Handler;
import java.lang.ref.WeakReference;
public class bg implements Runnable {
    private final WeakReference<Handler> a;
    private final WeakReference<o> b;

    public bg(Handler handler, o oVar) {
        this.a = new WeakReference<>(handler);
        this.b = new WeakReference<>(oVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler = this.a.get();
        o oVar = this.b.get();
        if (handler != null && oVar != null && oVar.c()) {
            bf.a(handler, oVar, this);
        }
    }
}
