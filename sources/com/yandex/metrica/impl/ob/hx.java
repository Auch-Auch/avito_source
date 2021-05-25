package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class hx extends hu {
    private mm a;
    private abp b;

    public hx(fe feVar) {
        this(feVar, feVar.u(), abp.a());
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        fe a3 = a();
        we i = a3.i();
        if (this.a.d()) {
            return false;
        }
        if (!this.a.c()) {
            if (i.S()) {
                this.b.c();
            }
            String e = aaVar.e();
            this.a.c(e);
            a3.e().a(aa.d(aaVar).c(e));
            this.a.a(i.T());
            a().z().a();
        }
        this.a.b();
        return false;
    }

    @VisibleForTesting
    public hx(fe feVar, mm mmVar, abp abp) {
        super(feVar);
        this.a = mmVar;
        this.b = abp;
    }
}
