package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.ca;
import java.util.Collection;
public class ry extends cb<wk> {
    @NonNull
    private Context j;
    @NonNull
    private sc k;
    @NonNull
    private final df l;
    @NonNull
    private ql m;
    @NonNull
    private mq n;
    @NonNull
    private final sa o;
    @NonNull
    private final qz p;
    private long q;
    private rz r;

    public ry(@NonNull Context context, @NonNull sc scVar, @NonNull df dfVar, @NonNull qz qzVar) {
        this(context, scVar, dfVar, qzVar, new mq(lv.a(context).c()), new wk(), new sa(context));
    }

    private void I() {
        this.o.a(this.r);
    }

    private boolean J() {
        rz a = this.o.a(this.m.d);
        this.r = a;
        if (!a.a()) {
            return c(e.a(this.r.c));
        }
        return false;
    }

    private void K() {
        long b = this.n.b(-1L) + 1;
        this.q = b;
        ((wk) this.i).a(b);
    }

    private void L() {
        this.n.c(this.q).q();
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void D() {
        if (x()) {
            this.p.a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @Nullable
    public ca.a E() {
        return ca.a.LOCATION;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    @Nullable
    public xq F() {
        return this.k.f();
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public void G() {
        I();
    }

    @Override // com.yandex.metrica.impl.ob.cb
    public void H() {
        I();
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean a() {
        if (!this.l.d() && !TextUtils.isEmpty(this.k.s()) && !TextUtils.isEmpty(this.k.u()) && !dl.a((Collection) s())) {
            return J();
        }
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.cb, com.yandex.metrica.impl.ob.ce, com.yandex.metrica.impl.ob.ca
    public boolean b() {
        boolean b = super.b();
        L();
        return b;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean t() {
        return super.t() & (400 != k());
    }

    @VisibleForTesting
    public ry(@NonNull Context context, @NonNull sc scVar, @NonNull df dfVar, @NonNull qz qzVar, @NonNull mq mqVar, @NonNull wk wkVar, @NonNull sa saVar) {
        super(wkVar);
        this.j = context;
        this.k = scVar;
        this.l = dfVar;
        this.p = qzVar;
        this.m = scVar.a();
        this.n = mqVar;
        this.o = saVar;
        K();
        a(this.k.b());
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void a(@NonNull Uri.Builder builder) {
        ((wk) this.i).a(builder, this.k);
    }
}
