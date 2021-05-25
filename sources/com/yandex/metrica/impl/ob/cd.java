package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class cd implements Runnable {
    @NonNull
    private final sd a;
    @NonNull
    private final se b;
    @NonNull
    private final ca c;
    @NonNull
    private final acv d;
    @NonNull
    private final String e;
    @NonNull
    private final cc f;

    public cd(@NonNull sd sdVar, @NonNull se seVar, @NonNull ca caVar, @NonNull acv acv, @NonNull String str) {
        this(sdVar, seVar, caVar, acv, new cc(), str);
    }

    private boolean a() {
        this.f.a(this.c);
        boolean b2 = this.c.b();
        this.c.a(b2);
        return b2;
    }

    private void b() {
        this.c.g();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = true;
        if (!this.d.c() || !this.a.a() || !this.b.c()) {
            z = false;
        } else {
            boolean a3 = this.c.a();
            sg c2 = this.c.c();
            if (a3 && !c2.b()) {
                a3 = false;
            }
            while (this.d.c() && a3) {
                boolean a4 = a();
                boolean z2 = !a4 && this.c.t();
                if (a4) {
                    this.b.a();
                } else {
                    this.b.b();
                }
                a3 = z2;
            }
        }
        if (!z) {
            b();
        }
        this.c.f();
    }

    public cd(@NonNull sd sdVar, @NonNull se seVar, @NonNull ca caVar, @NonNull acv acv, @NonNull cc ccVar, @NonNull String str) {
        this.a = sdVar;
        this.b = seVar;
        this.c = caVar;
        this.d = acv;
        this.f = ccVar;
        this.e = str;
    }
}
