package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.op;
import java.util.List;
public class ib extends hu {
    private final ss a;
    @NonNull
    private final mx<sk> b;
    @NonNull
    private final n c;
    @NonNull
    private final j d;
    @NonNull
    private final l e;

    public ib(fe feVar, ss ssVar) {
        this(feVar, ssVar, op.a.a(sk.class).a(feVar.k()), new n(feVar.k()), new j(), new l(feVar.k()));
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        fe a3 = a();
        a3.c().toString();
        if (!a3.u().d() || !a3.r()) {
            return false;
        }
        sk a4 = this.b.a();
        sk a5 = a(a4);
        if (a5 != null) {
            a(a5, aaVar, a3.e());
            this.b.a(a5);
            return false;
        } else if (!a3.s()) {
            return false;
        } else {
            a(a4, aaVar, a3.e());
            return false;
        }
    }

    @VisibleForTesting
    public ib(fe feVar, ss ssVar, @NonNull mx<sk> mxVar, @NonNull n nVar, @NonNull j jVar, @NonNull l lVar) {
        super(feVar);
        this.a = ssVar;
        this.b = mxVar;
        this.c = nVar;
        this.d = jVar;
        this.e = lVar;
    }

    @Nullable
    private sk a(@NonNull sk skVar) {
        List<sr> list = skVar.a;
        m mVar = skVar.b;
        m a3 = this.c.a();
        List<String> list2 = skVar.c;
        List<String> a4 = this.e.a();
        List<sr> a5 = this.a.a(a().k(), list);
        if (a5 == null && dl.a(mVar, a3) && aav.a(list2, a4)) {
            return null;
        }
        if (a5 != null) {
            list = a5;
        }
        return new sk(list, a3, a4);
    }

    private void a(@NonNull sk skVar, @NonNull aa aaVar, @NonNull fw fwVar) {
        fwVar.c(aa.a(aaVar, skVar.a, skVar.b, this.d, skVar.c));
    }
}
