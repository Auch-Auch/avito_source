package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class rp {
    @NonNull
    private final qp a;
    @NonNull
    private final zk b;
    @NonNull
    private final dn c;
    @NonNull
    private final qo d;
    private final mq e;

    public rp(@NonNull qp qpVar, @NonNull zk zkVar, @NonNull dn dnVar, @NonNull mq mqVar) {
        this(qpVar, zkVar, dnVar, mqVar, as.a().m());
    }

    private void a() {
        boolean g = this.e.g();
        this.a.a(g);
        this.c.a(g);
        this.b.a(g);
        this.d.a();
    }

    public void b(@NonNull Object obj) {
        this.a.a(obj);
        this.b.a();
    }

    @VisibleForTesting
    public rp(@NonNull qp qpVar, @NonNull zk zkVar, @NonNull dn dnVar, @NonNull mq mqVar, @NonNull qo qoVar) {
        this.a = qpVar;
        this.b = zkVar;
        this.c = dnVar;
        this.e = mqVar;
        this.d = qoVar;
        a();
    }

    public void a(@NonNull Object obj) {
        this.a.b(obj);
        this.b.b();
    }

    public void a(boolean z) {
        this.a.a(z);
        this.b.a(z);
        this.c.a(z);
        this.e.b(z);
    }

    public void a(@NonNull yb ybVar) {
        this.d.a(ybVar);
        this.c.a(ybVar);
        this.b.a(ybVar);
    }
}
