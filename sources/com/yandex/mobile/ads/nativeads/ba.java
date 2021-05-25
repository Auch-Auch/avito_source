package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.ah;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.az;
import com.yandex.mobile.ads.impl.bo;
import com.yandex.mobile.ads.impl.cn;
import com.yandex.mobile.ads.impl.cs;
import com.yandex.mobile.ads.impl.dt;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.ln;
import com.yandex.mobile.ads.impl.nu;
import com.yandex.mobile.ads.impl.of;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.qp;
import com.yandex.mobile.ads.impl.ro;
import com.yandex.mobile.ads.impl.rp;
import com.yandex.mobile.ads.impl.t;
import com.yandex.mobile.ads.impl.x;
import java.util.List;
public abstract class ba {
    @NonNull
    private final Context a;
    @NonNull
    private final bf b;
    @NonNull
    private final be c;
    @NonNull
    private final bh d;
    @NonNull
    private final ay e;
    @NonNull
    private final ah f;
    @NonNull
    private final bm g;
    @NonNull
    private final r h;
    @NonNull
    private final t i;
    @NonNull
    private final e j;
    @NonNull
    private final of k;
    @NonNull
    private final fo l;
    @NonNull
    private final x m;
    @NonNull
    private final bl n;
    @NonNull
    private final rp o;
    @NonNull
    private final ro p;
    @NonNull
    private final at q;
    @NonNull
    private final cs r;
    @NonNull
    private final ln s;
    @Nullable
    private ag t;
    private final ah.b u = new ah.b() { // from class: com.yandex.mobile.ads.nativeads.ba.1
        @Override // com.yandex.mobile.ads.impl.ah.b
        public final void a(@NonNull Intent intent) {
            intent.getAction();
            ba.this.e.a(intent, !ba.this.c.a());
        }
    };
    @NonNull
    private final com.yandex.mobile.ads.impl.ba v;

    public enum a {
        CUSTOM("custom"),
        TEMPLATE("template");
        
        public final String c;

        private a(String str) {
            this.c = str;
        }
    }

    public ba(@NonNull Context context, @NonNull c cVar) {
        AnonymousClass2 r7 = new com.yandex.mobile.ads.impl.ba() { // from class: com.yandex.mobile.ads.nativeads.ba.2
            @Override // com.yandex.mobile.ads.impl.ba
            @NonNull
            public final an a(int i2) {
                return ba.this.c.a(ba.this.a, i2);
            }
        };
        this.v = r7;
        this.a = context;
        this.b = cVar.d();
        be b2 = cVar.b();
        this.c = b2;
        bh c2 = cVar.c();
        this.d = c2;
        p a3 = cVar.a();
        fo a4 = a3.a();
        this.l = a4;
        x b3 = a3.b();
        this.m = b3;
        String e2 = a4.e();
        b a5 = a4.a();
        t e3 = cVar.e();
        this.i = e3;
        r a6 = e3.a().a(context, a4);
        this.h = a6;
        t tVar = new t(new qp(c2.d()));
        cs csVar = new cs(context, a4);
        this.r = csVar;
        at atVar = new at(a6, csVar, tVar);
        this.q = atVar;
        List<bo> b4 = c2.b();
        atVar.a(b3, b4);
        bl blVar = new bl();
        this.n = blVar;
        of ofVar = new of(context, b3, a4, a6, blVar);
        this.k = ofVar;
        ay a8 = az.a(context, a4, csVar, r7, dt.a(this));
        this.e = a8;
        this.j = new e(ofVar, a8);
        ah a9 = ah.a();
        this.f = a9;
        bm a10 = e3.d().a(a8, new cn(context, new an(b2), b3, a4, tVar, c2.c()), new nu(b2, b4), a9);
        this.g = a10;
        a10.a(atVar);
        a10.a(b3, b4);
        List<oq> a11 = c2.a();
        this.s = new ln(a11);
        this.o = new rp(context, a5, e2, a11);
        ro roVar = new ro(context, a4, a11);
        this.p = roVar;
        roVar.a(a());
    }

    @NonNull
    public abstract List<String> a();

    @NonNull
    public final be d() {
        return this.c;
    }

    @NonNull
    public final bh e() {
        return this.d;
    }

    public void setAdEventListener(NativeAdEventListener nativeAdEventListener) {
        this.h.a(nativeAdEventListener);
    }

    public void setAdTapHandler(@Nullable AdTapHandler adTapHandler) {
        this.n.a(adTapHandler);
    }

    public void shouldOpenLinksInApp(boolean z) {
        this.l.a(z);
    }

    public final <T extends View> void a(@NonNull T t2, @NonNull j jVar, @NonNull ak<T> akVar, @NonNull f fVar) throws NativeAdException {
        aj a3 = aj.a();
        ba a4 = a3.a(t2);
        if (!equals(a4)) {
            Context context = t2.getContext();
            if (a4 != null) {
                a4.a(context);
            }
            if (a3.a(this)) {
                a(context);
            }
            a3.a(t2, this);
            ag agVar = new ag(t2, akVar, jVar, this.q, fVar, this.i, this.s);
            agVar.a();
            this.o.a(agVar);
            this.t = agVar;
            this.c.a(agVar);
            bk b2 = this.c.b();
            if (b2.b()) {
                a(agVar);
                this.b.a(agVar, this.j);
                dt.a(this);
                b();
                return;
            }
            throw new NativeAdException(String.format("Resource for required view %s is not present", b2.a()));
        }
    }

    public final void b() {
        this.c.a();
        dt.a(this);
        this.g.a(this.a, this.u, this.t);
    }

    public final void c() {
        dt.a(this);
        this.g.a(this.a, this.u);
    }

    private void a(@NonNull ag agVar) {
        this.b.a(agVar);
    }

    public final void a(int i2) {
        dt.a(this);
        if (i2 == 0) {
            b();
        } else {
            c();
        }
    }

    public void a(@NonNull Context context) {
        c();
        this.h.i();
        ag agVar = this.t;
        if (agVar != null) {
            a(agVar);
            this.g.a(this.t);
        }
    }

    public final void a(@NonNull hv.a aVar) {
        this.k.a(aVar);
        this.r.a(aVar);
        this.o.a(aVar);
        this.h.a(aVar);
        this.g.a(aVar);
    }
}
