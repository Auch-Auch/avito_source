package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.df;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.vf;
public final class as {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile as a;
    @NonNull
    private final Context b;
    private volatile vt c;
    private volatile wx d;
    @Nullable
    private volatile vf e;
    private volatile df f;
    private volatile h g;
    @Nullable
    private volatile wq h;
    @Nullable
    private volatile ao i;
    @NonNull
    private volatile ada j = new ada();
    @Nullable
    private volatile zk k;
    @NonNull
    private volatile p l;
    @NonNull
    private volatile k m;
    @Nullable
    private volatile cz n;
    @Nullable
    private volatile by o;
    @Nullable
    private volatile qo p;

    private as(@NonNull Context context) {
        this.b = context;
        this.l = new p(context);
        this.m = new k(context, this.j.i());
        this.f = new df(new df.b(new mq(lv.a(context).c())));
        this.g = new h();
    }

    public static void a(@NonNull Context context) {
        if (a == null) {
            synchronized (as.class) {
                if (a == null) {
                    a = new as(context.getApplicationContext());
                }
            }
        }
    }

    public static synchronized void s() {
        synchronized (as.class) {
            if (!(a == null || a.o == null)) {
                a.o.a();
                a.o = null;
            }
        }
    }

    private void t() {
        if (this.o == null) {
            synchronized (this) {
                if (this.o == null) {
                    this.o = new by(this.b, a().k().b(), new mq(lv.a(this.b).c()));
                    this.o.setName(acy.a("YMM-NC"));
                    this.o.start();
                }
            }
        }
    }

    public void b() {
        this.l.a();
        this.m.a();
        f().a();
        this.g.a();
        t();
    }

    @NonNull
    public Context c() {
        return this.b;
    }

    @NonNull
    public vt d() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new vt(this.b);
                }
            }
        }
        return this.c;
    }

    @NonNull
    public wx e() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = new wx();
                }
            }
        }
        return this.d;
    }

    @NonNull
    public synchronized vf f() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = new vf(this.b, op.a.a(vf.a.class).a(this.b), this.f, e(), this.j.h());
                }
            }
        }
        return this.e;
    }

    @NonNull
    public wq g() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = new wq(this.b, this.j.h());
                }
            }
        }
        return this.h;
    }

    @NonNull
    public ao h() {
        if (this.i == null) {
            synchronized (this) {
                if (this.i == null) {
                    this.i = new ao();
                }
            }
        }
        return this.i;
    }

    @NonNull
    public df i() {
        return this.f;
    }

    @NonNull
    public h j() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = new h();
                }
            }
        }
        return this.g;
    }

    @NonNull
    public ada k() {
        return this.j;
    }

    @NonNull
    public zk l() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = new zk(this.b, k().d());
                }
            }
        }
        return this.k;
    }

    @NonNull
    public qo m() {
        if (this.p == null) {
            synchronized (this) {
                if (this.p == null) {
                    this.p = new qo(this.b);
                }
            }
        }
        return this.p;
    }

    @NonNull
    public p n() {
        return this.l;
    }

    @NonNull
    public k o() {
        return this.m;
    }

    public void p() {
        this.l.b();
        this.m.b();
        if (this.p != null) {
            this.p.b();
        }
    }

    @Nullable
    public synchronized cz q() {
        return this.n;
    }

    @Nullable
    public synchronized by r() {
        return this.o;
    }

    public static as a() {
        return a;
    }

    public void a(@NonNull yb ybVar) {
        if (this.h != null) {
            this.h.b(ybVar);
        }
        if (this.i != null) {
            this.i.a(ybVar);
        }
    }

    public synchronized void a(@NonNull da daVar) {
        this.n = new cz(this.b, daVar);
    }
}
