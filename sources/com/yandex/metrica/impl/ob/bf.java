package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.SystemClock;
public class bf {
    private final Handler a;
    private final o b;
    private final bg c;

    public bf(Handler handler, o oVar) {
        this.a = handler;
        this.b = oVar;
        this.c = new bg(handler, oVar);
    }

    private static int c(o oVar) {
        return ((Integer) abw.b(oVar.d().h().c(), 10)).intValue() * 500;
    }

    public void a() {
        b(this.a, this.b, this.c);
    }

    public void b() {
        a(this.a, this.b, this.c);
    }

    public static void a(Handler handler, o oVar, Runnable runnable) {
        b(handler, oVar, runnable);
        handler.postAtTime(runnable, b(oVar), a(oVar));
    }

    private static void b(Handler handler, o oVar, Runnable runnable) {
        handler.removeCallbacks(runnable, b(oVar));
    }

    private static String b(o oVar) {
        return oVar.d().h().e();
    }

    private static long a(o oVar) {
        return SystemClock.uptimeMillis() + ((long) c(oVar));
    }
}
