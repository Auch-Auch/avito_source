package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.wo;
public class wq {
    @NonNull
    private final wp a;
    @NonNull
    private final mx<wr> b;
    @NonNull
    private final dj c;
    @NonNull
    private final act d;
    @NonNull
    private final h.b e;
    @NonNull
    private final h f;
    @NonNull
    private final wo g;
    private boolean h;
    @Nullable
    private xr i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private boolean o;
    private boolean p;
    private final Object q;

    public wq(@NonNull Context context, @NonNull act act) {
        this(new wp(context, null, act), op.a.a(wr.class).a(context), new dj(), act, as.a().j());
    }

    private void d() {
        if (this.o) {
            f();
        } else {
            g();
        }
    }

    private void e() {
        if (this.k - this.l >= this.i.b) {
            b();
        }
    }

    private void f() {
        if (this.c.b(this.m, this.i.d, "should retry sdk collecting")) {
            b();
        }
    }

    private void g() {
        if (this.c.b(this.m, this.i.a, "should collect sdk as usual")) {
            b();
        }
    }

    public void c() {
        wr a3 = this.b.a();
        this.m = a3.c;
        this.n = a3.d;
        this.o = a3.e;
    }

    public void a(@Nullable yb ybVar) {
        c();
        b(ybVar);
    }

    public void b(@Nullable yb ybVar) {
        boolean c2 = c(ybVar);
        synchronized (this.q) {
            if (ybVar != null) {
                this.j = ybVar.o.e;
                this.i = ybVar.C;
                this.k = ybVar.F;
                this.l = ybVar.G;
            }
            this.a.a(ybVar);
        }
        if (c2) {
            a();
        }
    }

    @VisibleForTesting
    public wq(@NonNull wp wpVar, @NonNull mx<wr> mxVar, @NonNull dj djVar, @NonNull act act, @NonNull h hVar) {
        this.p = false;
        this.q = new Object();
        this.a = wpVar;
        this.b = mxVar;
        this.g = new wo(mxVar, new wo.a() { // from class: com.yandex.metrica.impl.ob.wq.1
            @Override // com.yandex.metrica.impl.ob.wo.a
            public void a() {
                wq.this.c();
                wq.this.h = false;
            }
        });
        this.c = djVar;
        this.d = act;
        this.e = new h.b() { // from class: com.yandex.metrica.impl.ob.wq.2
            @Override // com.yandex.metrica.impl.ob.h.b
            public void a() {
                wq.this.p = true;
                wq.this.a.a(wq.this.g);
            }
        };
        this.f = hVar;
    }

    private boolean c(@Nullable yb ybVar) {
        xr xrVar;
        if (ybVar == null) {
            return false;
        }
        if ((this.j || !ybVar.o.e) && (xrVar = this.i) != null && xrVar.equals(ybVar.C) && this.k == ybVar.F && this.l == ybVar.G && !this.a.b(ybVar)) {
            return false;
        }
        return true;
    }

    public void a() {
        synchronized (this.q) {
            if (this.j && this.i != null) {
                if (this.n) {
                    d();
                } else {
                    e();
                }
            }
        }
    }

    public void b() {
        if (!this.h) {
            this.h = true;
            if (!this.p) {
                this.f.a(this.i.c, this.d, this.e);
            } else {
                this.a.a(this.g);
            }
        }
    }
}
