package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public abstract class gc implements gg {
    @NonNull
    private final Context a;
    @NonNull
    private final ft b;
    @NonNull
    private final rp c;

    public gc(@NonNull Context context, @NonNull ft ftVar) {
        this(context, ftVar, new rp(qp.a(context), as.a().l(), dn.a(context), new mq(lv.a(context).c())));
    }

    @Override // com.yandex.metrica.impl.ob.gg
    public void a(@NonNull aa aaVar, @NonNull ew ewVar) {
        b(aaVar, ewVar);
    }

    @NonNull
    public ft b() {
        return this.b;
    }

    public abstract void b(@NonNull aa aaVar, @NonNull ew ewVar);

    @NonNull
    public rp c() {
        return this.c;
    }

    @Override // com.yandex.metrica.impl.ob.gg
    public void a() {
        this.b.b(this);
        this.c.a(this);
    }

    @VisibleForTesting
    public gc(@NonNull Context context, @NonNull ft ftVar, @NonNull rp rpVar) {
        this.a = context.getApplicationContext();
        this.b = ftVar;
        this.c = rpVar;
        ftVar.a(this);
        rpVar.b(this);
    }
}
