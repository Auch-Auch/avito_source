package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public class rt implements aw {
    @NonNull
    private final mq a;
    @NonNull
    private final dj b;
    @Nullable
    private volatile pt c;
    @NonNull
    private final dn d;
    @NonNull
    private final abt e;
    @NonNull
    private final a f;
    @NonNull
    private final rs g;

    public static class a {
        @NonNull
        public CountDownLatch a() {
            return new CountDownLatch(1);
        }
    }

    public rt(@NonNull Context context, @Nullable pt ptVar) {
        this(context, ptVar, dn.a(context));
    }

    public void a(@Nullable pt ptVar) {
        if (!dl.a(this.c, ptVar)) {
            this.c = ptVar;
            a();
        }
    }

    public void b() {
        pt ptVar = this.c;
        if (ptVar != null && ptVar.b != null && this.b.a(this.a.j(0), ptVar.b.b, "last wifi scan attempt time")) {
            CountDownLatch a3 = this.f.a();
            if (this.d.a(a3, this.g)) {
                this.a.k(this.e.b());
                try {
                    a3.await(5, TimeUnit.SECONDS);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private rt(@NonNull Context context, @Nullable pt ptVar, @NonNull dn dnVar) {
        this(dnVar, new mq(lv.a(context).c()), new dj(), new abs(), new a(), ptVar, new rs(null, dnVar.d()));
    }

    @Override // com.yandex.metrica.impl.ob.aw
    public void a() {
        pt ptVar = this.c;
        if (ptVar != null && ptVar.a.a) {
            this.g.a((rs) this.d.b());
        }
    }

    @VisibleForTesting
    public rt(@NonNull dn dnVar, @NonNull mq mqVar, @NonNull dj djVar, @NonNull abt abt, @NonNull a aVar, @Nullable pt ptVar, @NonNull rs rsVar) {
        this.d = dnVar;
        this.a = mqVar;
        this.b = djVar;
        this.f = aVar;
        this.c = ptVar;
        this.e = abt;
        this.g = rsVar;
    }
}
