package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.p;
import java.util.List;
public class qo implements fg, k.b, p.b {
    @NonNull
    private List<qm> a;
    @NonNull
    private final p b;
    @NonNull
    private final qp c;
    @NonNull
    private final k d;
    @Nullable
    private volatile ql e;

    public qo(@NonNull Context context) {
        this(as.a().n(), qp.a(context), op.a.a(yb.class).a(context), as.a().o());
    }

    private void c() {
        ql d2 = d();
        if (!dl.a(this.e, d2)) {
            this.c.a(d2);
            this.e = d2;
        }
    }

    @Nullable
    private ql d() {
        k.a c2 = this.d.c();
        p.a.EnumC0340a d2 = this.b.d();
        for (qm qmVar : this.a) {
            if (qmVar.b.a.contains(d2) && qmVar.b.b.contains(c2)) {
                return qmVar.a;
            }
        }
        return null;
    }

    public synchronized void a(@NonNull yb ybVar) {
        this.a = ybVar.p;
        this.e = d();
        this.c.a(ybVar, this.e);
    }

    @Override // com.yandex.metrica.impl.ob.fg
    public synchronized void b() {
        this.d.b(this);
        this.b.b(this);
    }

    @Override // com.yandex.metrica.impl.ob.k.b
    public synchronized void a(@NonNull k.a aVar) {
        c();
    }

    @VisibleForTesting
    public qo(@NonNull p pVar, @NonNull qp qpVar, @NonNull mx<yb> mxVar, @NonNull k kVar) {
        synchronized (this) {
            this.b = pVar;
            this.c = qpVar;
            this.d = kVar;
            this.a = mxVar.a().p;
            pVar.a(this);
            kVar.a(this);
        }
    }

    @Override // com.yandex.metrica.impl.ob.p.b
    public synchronized void a(@NonNull p.a.EnumC0340a aVar) {
        c();
    }

    public synchronized void a() {
        c();
    }
}
