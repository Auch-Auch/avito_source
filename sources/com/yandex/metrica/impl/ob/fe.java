package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fd;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.ju;
import com.yandex.metrica.impl.ob.we;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
public class fe implements fk, fn, oy {
    public mq a;
    private final Context b;
    private final fb c;
    private final mo d;
    private final mm e;
    private final cr f;
    private final lr g;
    private final hj h;
    private final hg i;
    private final i j;
    @NonNull
    private final a k;
    private volatile ju l;
    private final fv m;
    @NonNull
    private final jf n;
    @NonNull
    private final abl o;
    @NonNull
    private final abb p;
    @NonNull
    private final fw q;
    @NonNull
    private final fd.a r;
    @NonNull
    private final ox s;
    @NonNull
    private final ou t;
    @NonNull
    private final oz u;
    @NonNull
    private final s v;
    @NonNull
    private final dj w;

    public fe(@NonNull Context context, @NonNull yb ybVar, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull we.d dVar, @NonNull ye yeVar) {
        this(context, fbVar, new a(), new dj(), new ff(context, fbVar, aVar, yeVar, ybVar, dVar, as.a().k().g(), dl.c(context, fbVar.b())));
    }

    private void D() {
        long libraryApiLevel = (long) YandexMetrica.getLibraryApiLevel();
        if (this.d.g() < libraryApiLevel) {
            this.r.a(new sy(v())).a();
            this.d.d(libraryApiLevel).q();
        }
    }

    @NonNull
    public s A() {
        return this.v;
    }

    @Nullable
    public String B() {
        return this.d.h();
    }

    @NonNull
    public ox C() {
        return this.s;
    }

    public void b(aa aaVar) {
        this.j.a(aaVar.k());
        i.a b2 = this.j.b();
        if (this.k.a(b2, this.d) && this.o.c()) {
            this.o.a("Save new app environment for %s. Value: %s", c(), b2.a);
        }
    }

    @Override // com.yandex.metrica.impl.ob.fj
    public fb c() {
        return this.c;
    }

    public ju d() {
        return this.l;
    }

    @NonNull
    public fw e() {
        return this.q;
    }

    public hg f() {
        return this.i;
    }

    @Override // com.yandex.metrica.impl.ob.oy
    public synchronized void g() {
        this.f.e();
    }

    @Nullable
    public String h() {
        return this.d.f();
    }

    @NonNull
    public we i() {
        return (we) this.m.d();
    }

    public lr j() {
        return this.g;
    }

    public Context k() {
        return this.b;
    }

    @NonNull
    public abl l() {
        return this.o;
    }

    public void m() {
        this.q.b();
    }

    public void n() {
        this.j.a();
        this.k.b(this.j.b(), this.d);
    }

    public void o() {
        this.d.d(p() + 1).q();
        this.m.a();
    }

    public int p() {
        return this.d.i();
    }

    public boolean q() {
        return this.q.c() && i().g();
    }

    public boolean r() {
        we i2 = i();
        return i2.K() && i2.g() && this.w.a(this.q.d(), i2.M(), "need to check permissions");
    }

    public boolean s() {
        we i2 = i();
        return i2.K() && this.w.a(this.q.d(), i2.N(), "should force send permissions");
    }

    public boolean t() {
        return this.q.e() && i().L() && i().g();
    }

    public mm u() {
        return this.e;
    }

    @Deprecated
    public final sz v() {
        return new sz(this.b, this.c.a());
    }

    public boolean w() {
        return this.a.a();
    }

    public boolean x() {
        boolean z = false;
        boolean b2 = this.e.b(false);
        boolean z2 = this.m.b().w;
        if (b2 && z2) {
            z = true;
        }
        return !z;
    }

    public mo y() {
        return this.d;
    }

    @NonNull
    public jf z() {
        return this.n;
    }

    @Override // com.yandex.metrica.impl.ob.fn
    public void a(@NonNull aa aaVar) {
        if (this.o.c()) {
            this.o.a(aaVar, "Event received on service");
        }
        if (dl.a(this.c.a())) {
            this.h.b(aaVar);
        }
    }

    public static class a {
        private final HashMap<String, i> a = new HashMap<>();

        public synchronized i a(@NonNull fb fbVar, @NonNull abl abl, mo moVar) {
            i iVar;
            iVar = this.a.get(fbVar.toString());
            if (iVar == null) {
                i.a d = moVar.d();
                iVar = new i(d.a, d.b, abl);
                this.a.put(fbVar.toString(), iVar);
            }
            return iVar;
        }

        public synchronized void b(i.a aVar, mo moVar) {
            moVar.a(aVar).q();
        }

        public synchronized boolean a(i.a aVar, mo moVar) {
            if (aVar.b <= moVar.d().b) {
                return false;
            }
            moVar.a(aVar).q();
            return true;
        }
    }

    @VisibleForTesting
    public fe(@NonNull Context context, @NonNull fb fbVar, @NonNull a aVar, @NonNull dj djVar, @NonNull ff ffVar) {
        this.b = context.getApplicationContext();
        this.c = fbVar;
        this.k = aVar;
        this.w = djVar;
        abl a3 = ffVar.a().a();
        this.o = a3;
        abb b2 = ffVar.a().b();
        this.p = b2;
        mo b3 = ffVar.b().b();
        this.d = b3;
        this.e = ffVar.b().a();
        this.a = ffVar.b().c();
        i a4 = aVar.a(fbVar, a3, b3);
        this.j = a4;
        this.n = ffVar.c();
        lr a5 = ffVar.a(this);
        this.g = a5;
        cr<fe> b4 = ffVar.b(this);
        this.f = b4;
        fv c2 = ffVar.c(this);
        this.m = c2;
        this.r = ffVar.e(this);
        oz a6 = ffVar.a(a5, c2);
        this.u = a6;
        ou a8 = ffVar.a(a5);
        this.t = a8;
        ArrayList arrayList = new ArrayList();
        arrayList.add(a6);
        arrayList.add(a8);
        this.s = ffVar.a(arrayList, this);
        D();
        this.l = ffVar.a(this, b3, new ju.a() { // from class: com.yandex.metrica.impl.ob.fe.1
            @Override // com.yandex.metrica.impl.ob.ju.a
            public void a(@NonNull aa aaVar, @NonNull jv jvVar) {
                fe.this.q.a(aaVar, jvVar);
            }
        });
        if (b2.c()) {
            b2.a("Read app environment for component %s. Value: %s", fbVar.toString(), a4.b().a);
        }
        this.q = ffVar.a(b3, this.l, a5, a4, b4);
        hg d2 = ffVar.d(this);
        this.i = d2;
        this.h = ffVar.a(this, d2);
        this.v = ffVar.a(b3);
        a5.a();
    }

    @Override // com.yandex.metrica.impl.ob.fk
    public synchronized void a(@NonNull ew.a aVar) {
        this.m.a(aVar);
        b(aVar);
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public void b() {
        dl.a((Closeable) this.f);
        dl.a((Closeable) this.g);
    }

    private void b(@NonNull ew.a aVar) {
        if (aau.a(aVar.l)) {
            this.o.a();
        } else if (aau.c(aVar.l)) {
            this.o.b();
        }
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public synchronized void a(@Nullable yb ybVar) {
        this.m.a(ybVar);
        this.s.a();
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public synchronized void a(@NonNull xv xvVar, @Nullable yb ybVar) {
    }

    public void b(@Nullable String str) {
        this.d.d(str).q();
    }

    public void a(String str) {
        this.d.a(str).q();
    }

    @NonNull
    public CounterConfiguration.a a() {
        return CounterConfiguration.a.MANUAL;
    }
}
