package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class bb {
    @NonNull
    private final abt a;
    @NonNull
    private final dj b;
    @NonNull
    private final mq c;
    private long d;
    @Nullable
    private xn e;

    public bb(@NonNull mq mqVar, @Nullable xn xnVar) {
        this(mqVar, xnVar, new abs(), new dj());
    }

    private void b() {
        xa.a().e();
    }

    public void a() {
        xn xnVar = this.e;
        if (xnVar != null && this.b.a(this.d, xnVar.a, "should send EVENT_IDENTITY_LIGHT")) {
            b();
            long b2 = this.a.b();
            this.d = b2;
            this.c.i(b2);
        }
    }

    @VisibleForTesting
    public bb(@NonNull mq mqVar, @Nullable xn xnVar, @NonNull abt abt, @NonNull dj djVar) {
        this.c = mqVar;
        this.e = xnVar;
        this.d = mqVar.h(0);
        this.a = abt;
        this.b = djVar;
    }

    public void a(@Nullable xn xnVar) {
        this.e = xnVar;
    }
}
