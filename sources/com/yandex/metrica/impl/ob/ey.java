package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.vt;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ey implements fk, fm, xy {
    @NonNull
    private final Context a;
    @NonNull
    private final fb b;
    @NonNull
    private final xt c;
    @NonNull
    private final yc d;
    @NonNull
    private final fy e;
    @NonNull
    private final hl<hk, ey> f;
    @NonNull
    private final di<ey> g;
    @NonNull
    private List<ba> h;
    @Nullable
    private yb i;
    @NonNull
    private final fc<gj> j;
    @NonNull
    private final vt k;
    private final vt.a l;
    @Nullable
    private vf m;
    private final Object n;

    public ey(@NonNull Context context, @NonNull xt xtVar, @NonNull fb fbVar, @NonNull ew ewVar, @NonNull vt vtVar) {
        this(context, xtVar, fbVar, ewVar, new fy(ewVar.b), vtVar, new fc(), new fa());
    }

    @Override // com.yandex.metrica.impl.ob.fk
    public void a(@NonNull ew.a aVar) {
        this.e.a(aVar);
    }

    public synchronized void b(@NonNull gj gjVar) {
        this.j.b(gjVar);
    }

    @Override // com.yandex.metrica.impl.ob.fj
    @NonNull
    public fb c() {
        return this.b;
    }

    @NonNull
    public Context d() {
        return this.a;
    }

    @NonNull
    public vt e() {
        return this.k;
    }

    @VisibleForTesting
    public ey(@NonNull Context context, @NonNull xt xtVar, @NonNull fb fbVar, @NonNull ew ewVar, @NonNull fy fyVar, @NonNull vt vtVar, @NonNull fc<gj> fcVar, @NonNull fa faVar) {
        this.h = new ArrayList();
        this.i = null;
        this.n = new Object();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = fbVar;
        this.c = xtVar;
        this.e = fyVar;
        this.j = fcVar;
        this.f = faVar.a(this);
        yc a3 = xtVar.a(applicationContext, fbVar, this, ewVar.a);
        this.d = a3;
        this.g = faVar.a(this, a3);
        this.k = vtVar;
        vt.a a4 = faVar.a(a3);
        this.l = a4;
        vtVar.a(a4);
    }

    public synchronized void a(@NonNull gj gjVar) {
        this.j.a(gjVar);
        yb ybVar = this.i;
        if (ybVar != null) {
            a(ybVar, gjVar);
        }
    }

    private void b(yb ybVar) {
        synchronized (this.n) {
            for (gj gjVar : this.j.a()) {
                a(ybVar, gjVar);
            }
            ArrayList arrayList = new ArrayList();
            for (ba baVar : this.h) {
                if (baVar.a(ybVar)) {
                    ab.a(baVar.c(), ybVar);
                } else {
                    arrayList.add(baVar);
                }
            }
            this.h = new ArrayList(arrayList);
            if (!arrayList.isEmpty()) {
                this.g.e();
            }
        }
    }

    public void a(@NonNull aa aaVar, @NonNull gj gjVar) {
        this.f.a(aaVar, gjVar);
    }

    @NonNull
    public ew.a a() {
        return this.e.a();
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public void a(@Nullable yb ybVar) {
        this.i = ybVar;
        b(ybVar);
        if (ybVar != null) {
            if (this.m == null) {
                this.m = as.a().f();
            }
            this.m.a(ybVar);
        }
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public void a(@NonNull xv xvVar, @Nullable yb ybVar) {
        synchronized (this.n) {
            for (ba baVar : this.h) {
                ab.a(baVar.c(), xvVar, ybVar);
            }
            this.h.clear();
        }
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public void b() {
        dl.a((Closeable) this.g);
    }

    private void a(@Nullable yb ybVar, @NonNull xy xyVar) {
        xyVar.a(ybVar);
    }

    public void a(@Nullable ba baVar) {
        ResultReceiver resultReceiver;
        Map<String, String> hashMap = new HashMap<>();
        List<String> list = null;
        if (baVar != null) {
            list = baVar.a();
            resultReceiver = baVar.c();
            hashMap = baVar.b();
        } else {
            resultReceiver = null;
        }
        boolean a3 = this.d.a(list, hashMap);
        if (!a3) {
            ab.a(resultReceiver, this.d.e());
        }
        if (this.d.b()) {
            synchronized (this.n) {
                if (a3 && baVar != null) {
                    this.h.add(baVar);
                }
            }
            this.g.e();
        } else if (a3) {
            ab.a(resultReceiver, this.d.e());
        }
    }

    @Override // com.yandex.metrica.impl.ob.fm
    public void a(@NonNull ew ewVar) {
        this.d.a(ewVar.a);
        a(ewVar.b);
    }
}
