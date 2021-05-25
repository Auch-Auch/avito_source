package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
import java.util.List;
public class nu implements np<rr, ve.a.m> {
    @NonNull
    private final no a;

    public nu() {
        this(new no());
    }

    @VisibleForTesting
    public nu(@NonNull no noVar) {
        this.a = noVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.m b(@NonNull rr rrVar) {
        ve.a.m.C0360a[] aVarArr;
        ve.a.m mVar = new ve.a.m();
        mVar.b = rrVar.a;
        mVar.c = rrVar.b;
        List<qd> list = rrVar.c;
        if (list == null) {
            aVarArr = new ve.a.m.C0360a[0];
        } else {
            aVarArr = this.a.b(list);
        }
        mVar.d = aVarArr;
        return mVar;
    }

    @NonNull
    public rr a(@NonNull ve.a.m mVar) {
        List<qd> list;
        long j = mVar.b;
        boolean z = mVar.c;
        if (dl.a((Object[]) mVar.d)) {
            list = null;
        } else {
            list = this.a.a(mVar.d);
        }
        return new rr(j, z, list);
    }
}
