package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.vx;
import com.yandex.metrica.impl.ob.vy;
import com.yandex.metrica.impl.ob.vy.d;
public abstract class wa<T extends vy, IA, A extends vx<IA, A>, L extends vy.d<T, vy.c<A>>> {
    @Nullable
    private T a;
    @NonNull
    private L b;
    @NonNull
    private vy.c<A> c;

    public wa(@NonNull L l, @NonNull yb ybVar, @NonNull A a3) {
        this.b = l;
        eh.a().a(this, ep.class, el.a(new ek<ep>() { // from class: com.yandex.metrica.impl.ob.wa.1
            public void a(ep epVar) {
                wa.this.a();
            }
        }).a());
        a((vy.c) new vy.c<>(ybVar, a3));
    }

    public synchronized void a() {
        this.a = null;
    }

    @NonNull
    public synchronized yb b() {
        return this.c.a;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [A extends com.yandex.metrica.impl.ob.vx<IA, A>, com.yandex.metrica.impl.ob.vx] */
    @VisibleForTesting(otherwise = 4)
    @NonNull
    public synchronized A c() {
        return this.c.b;
    }

    @NonNull
    public synchronized T d() {
        if (this.a == null) {
            this.a = (T) this.b.a(this.c);
        }
        return this.a;
    }

    public synchronized void a(@NonNull vy.c<A> cVar) {
        this.c = cVar;
    }

    public synchronized void a(@NonNull IA ia) {
        if (!this.c.b.a(ia)) {
            a((vy.c) new vy.c<>(b(), this.c.b.b(ia)));
            a();
        }
    }

    public synchronized void a(@NonNull yb ybVar) {
        a((vy.c) new vy.c<>(ybVar, c()));
        a();
    }
}
