package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public class acy implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(0);
    private final String b;

    public acy(String str) {
        this.b = str;
    }

    public static int b() {
        return a.incrementAndGet();
    }

    private String c() {
        return a(this.b);
    }

    /* renamed from: a */
    public acx newThread(Runnable runnable) {
        return new acx(runnable, c());
    }

    public acw a() {
        return new acw(c());
    }

    public static acx a(String str, Runnable runnable) {
        return new acy(str).newThread(runnable);
    }

    public static String a(String str) {
        StringBuilder Q = a.Q(str, "-");
        Q.append(b());
        return Q.toString();
    }
}
