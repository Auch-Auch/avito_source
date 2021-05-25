package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class qy {
    @NonNull
    private final qx a;
    @NonNull
    private final ph b;
    @NonNull
    private final ra c;
    @NonNull
    private final pm d;
    @NonNull
    private final Runnable e = new Runnable() { // from class: com.yandex.metrica.impl.ob.qy.1
        @Override // java.lang.Runnable
        public void run() {
            qy.this.c();
        }
    };

    public qy(@NonNull qx qxVar, @NonNull ph phVar, @NonNull ra raVar, @NonNull pm pmVar) {
        this.a = qxVar;
        this.b = phVar;
        this.c = raVar;
        this.d = pmVar;
    }

    public void a() {
        c();
        b();
    }

    public void b() {
        if (this.b.a() && this.a.a()) {
            this.c.a();
            this.d.a(this.e);
        }
    }

    public void c() {
        this.d.a();
        this.a.b();
    }

    public void d() {
        if (this.b.b()) {
            this.a.c();
        }
        b();
    }
}
