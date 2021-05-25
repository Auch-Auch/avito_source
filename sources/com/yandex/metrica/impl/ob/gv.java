package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.gz;
import java.io.Closeable;
public class gv implements fk, fl, ha {
    @NonNull
    private final Context a;
    @NonNull
    private final fb b;
    @NonNull
    private final ag c;
    @NonNull
    private gw d;
    @NonNull
    private gb e;
    @NonNull
    private final CounterConfiguration.a f;

    public static class a {
        public gw a(@NonNull Context context, @NonNull fb fbVar, @NonNull yb ybVar, @NonNull gz.a aVar) {
            return new gw(new gz.b(context, fbVar.b()), ybVar, aVar);
        }
    }

    public static class b {
        public ag<gv> a(@NonNull gv gvVar, @NonNull ye yeVar, @NonNull hb hbVar, @NonNull mo moVar) {
            return new ag<>(gvVar, yeVar.a(), hbVar, moVar);
        }
    }

    public gv(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yb ybVar, @NonNull ye yeVar, @NonNull CounterConfiguration.a aVar2) {
        this(context, fbVar, aVar, ybVar, yeVar, aVar2, new hb(), new b(), new a(), new gb(context, fbVar), new mo(lv.a(context).b(fbVar)));
    }

    @Override // com.yandex.metrica.impl.ob.fk
    public void a(@NonNull ew.a aVar) {
        this.d.a((gw) aVar);
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public void a(@NonNull xv xvVar, @Nullable yb ybVar) {
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public void b() {
        dl.a((Closeable) this.c);
    }

    @Override // com.yandex.metrica.impl.ob.fj
    @NonNull
    public fb c() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.ha
    @NonNull
    public gz d() {
        return (gz) this.d.d();
    }

    @Override // com.yandex.metrica.impl.ob.fn
    public void a(@NonNull aa aaVar) {
        this.c.a(aaVar);
    }

    @Override // com.yandex.metrica.impl.ob.fo
    public void a() {
        if (this.e.a(((gz) this.d.d()).c())) {
            a(al.a());
            this.e.a();
        }
    }

    public gv(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yb ybVar, @NonNull ye yeVar, @NonNull CounterConfiguration.a aVar2, @NonNull hb hbVar, @NonNull b bVar, @NonNull a aVar3, @NonNull gb gbVar, @NonNull mo moVar) {
        this.a = context;
        this.b = fbVar;
        this.e = gbVar;
        this.f = aVar2;
        this.c = bVar.a(this, yeVar, hbVar, moVar);
        synchronized (this) {
            this.e.a(ybVar.z);
            this.d = aVar3.a(context, fbVar, ybVar, new gz.a(aVar));
        }
    }

    @Override // com.yandex.metrica.impl.ob.xy
    public synchronized void a(@Nullable yb ybVar) {
        this.d.a(ybVar);
        this.e.a(ybVar.z);
    }
}
