package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fk;
import com.yandex.metrica.impl.ob.fn;
import java.util.ArrayList;
import java.util.List;
public class ft<COMPONENT extends fn & fk> implements fg, fm, xy {
    @NonNull
    private final Context a;
    @NonNull
    private final fb b;
    @NonNull
    private final gk<COMPONENT> c;
    @NonNull
    private final yc d;
    @NonNull
    private final fy e;
    @Nullable
    private COMPONENT f;
    @Nullable
    private fl g;
    private List<xy> h;
    @NonNull
    private final fc<gg> i;

    public ft(@NonNull Context context, @NonNull fb fbVar, @NonNull ew ewVar, @NonNull gk<COMPONENT> gkVar) {
        this(context, fbVar, ewVar, new fy(ewVar.b), gkVar, new fc(), xt.a());
    }

    private void c() {
        e().a();
    }

    private COMPONENT d() {
        if (this.f == null) {
            synchronized (this) {
                COMPONENT d2 = this.c.d(this.a, this.b, this.e.a(), this.d);
                this.f = d2;
                this.h.add(d2);
            }
        }
        return this.f;
    }

    private fl e() {
        if (this.g == null) {
            synchronized (this) {
                fl c2 = this.c.c(this.a, this.b, this.e.a(), this.d);
                this.g = c2;
                this.h.add(c2);
            }
        }
        return this.g;
    }

    public void a(@NonNull aa aaVar, @NonNull ew ewVar) {
        COMPONENT component;
        c();
        if (al.d(aaVar.g())) {
            component = e();
        } else {
            component = d();
        }
        if (!al.a(aaVar.g())) {
            a(ewVar.b);
        }
        component.a(aaVar);
    }

    public synchronized void b(@NonNull gg ggVar) {
        this.i.b(ggVar);
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public void b() {
        COMPONENT component = this.f;
        if (component != null) {
            ((fg) component).b();
        }
        fl flVar = this.g;
        if (flVar != null) {
            flVar.b();
        }
    }

    public ft(@NonNull Context context, @NonNull fb fbVar, @NonNull ew ewVar, @NonNull fy fyVar, @NonNull gk<COMPONENT> gkVar, @NonNull fc<gg> fcVar, @NonNull xt xtVar) {
        this.h = new ArrayList();
        this.a = context;
        this.b = fbVar;
        this.e = fyVar;
        this.c = gkVar;
        this.i = fcVar;
        this.d = xtVar.a(context, a(), this, ewVar.a);
    }

    public synchronized void a(@NonNull ew.a aVar) {
        this.e.a(aVar);
        fl flVar = this.g;
        if (flVar != null) {
            flVar.a(aVar);
        }
        COMPONENT component = this.f;
        if (component != null) {
            component.a(aVar);
        }
    }

    public synchronized void a(@NonNull gg ggVar) {
        this.i.a(ggVar);
    }

    @VisibleForTesting
    @NonNull
    public final fb a() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public synchronized void a(@Nullable yb ybVar) {
        for (xy xyVar : this.h) {
            xyVar.a(ybVar);
        }
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public synchronized void a(@NonNull xv xvVar, @Nullable yb ybVar) {
        for (xy xyVar : this.h) {
            xyVar.a(xvVar, ybVar);
        }
    }

    @Override // com.yandex.metrica.impl.ob.fm
    public void a(@NonNull ew ewVar) {
        this.d.a(ewVar.a);
        a(ewVar.b);
    }
}
