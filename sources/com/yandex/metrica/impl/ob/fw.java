package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
public class fw {
    @NonNull
    private final mo a;
    @NonNull
    private ju b;
    @NonNull
    private lr c;
    @NonNull
    private final ack d;
    @NonNull
    private final i e;
    @NonNull
    private final fi f;
    @NonNull
    private a g;
    @NonNull
    private final abt h;
    private final int i;
    private long j;
    private long k;
    private int l;

    public interface a {
        void a();
    }

    public fw(@NonNull mo moVar, @NonNull ju juVar, @NonNull lr lrVar, @NonNull i iVar, @NonNull ack ack, int i2, @NonNull a aVar) {
        this(moVar, juVar, lrVar, iVar, ack, i2, aVar, new fi(moVar), new abs());
    }

    public void a(aa aaVar) {
        this.b.c(aaVar);
    }

    public void b(aa aaVar) {
        e(aaVar);
        f();
    }

    public void c(aa aaVar) {
        e(aaVar);
        a();
    }

    public void d(aa aaVar) {
        e(aaVar);
        b();
    }

    public void e(aa aaVar) {
        a(aaVar, this.b.d(aaVar));
    }

    public void f(@NonNull aa aaVar) {
        a(aaVar, this.b.e(aaVar));
    }

    @VisibleForTesting
    public fw(@NonNull mo moVar, @NonNull ju juVar, @NonNull lr lrVar, @NonNull i iVar, @NonNull ack ack, int i2, @NonNull a aVar, @NonNull fi fiVar, @NonNull abt abt) {
        this.a = moVar;
        this.b = juVar;
        this.c = lrVar;
        this.e = iVar;
        this.d = ack;
        this.i = i2;
        this.f = fiVar;
        this.h = abt;
        this.g = aVar;
        this.j = moVar.a(0L);
        this.k = moVar.b();
        this.l = moVar.c();
    }

    private void f() {
        long b2 = this.h.b();
        this.j = b2;
        this.a.b(b2).q();
    }

    @VisibleForTesting
    public void a(@NonNull aa aaVar, @NonNull jv jvVar) {
        if (TextUtils.isEmpty(aaVar.l())) {
            aaVar.a(this.a.f());
        }
        aaVar.d(this.a.h());
        this.c.a(this.d.a(aaVar).a(aaVar), aaVar.g(), jvVar, this.e.b(), this.f);
        this.g.a();
    }

    public boolean e() {
        return this.l < this.i;
    }

    public void b() {
        int i2 = this.i;
        this.l = i2;
        this.a.c(i2).q();
    }

    public boolean c() {
        return this.h.b() - this.j > jr.a;
    }

    public long d() {
        return this.k;
    }

    public void a() {
        long b2 = this.h.b();
        this.k = b2;
        this.a.c(b2).q();
    }
}
