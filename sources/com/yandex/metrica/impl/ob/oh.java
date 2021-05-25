package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xi;
public class oh implements np<xi.a, ve.a.C0352a.C0353a> {
    @NonNull
    private final og a;
    @NonNull
    private final ok b;
    @NonNull
    private final ol c;

    public oh() {
        this(new og(), new ok(), new ol());
    }

    @VisibleForTesting
    public oh(@NonNull og ogVar, @NonNull ok okVar, @NonNull ol olVar) {
        this.a = ogVar;
        this.b = okVar;
        this.c = olVar;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.C0352a.C0353a b(@NonNull xi.a aVar) {
        ve.a.C0352a.C0353a aVar2 = new ve.a.C0352a.C0353a();
        if (!TextUtils.isEmpty(aVar.a)) {
            aVar2.b = aVar.a;
        }
        if (!TextUtils.isEmpty(aVar.b)) {
            aVar2.c = aVar.b;
        }
        xi.a.C0363a aVar3 = aVar.c;
        if (aVar3 != null) {
            aVar2.d = this.a.b(aVar3);
        }
        xi.a.b bVar = aVar.d;
        if (bVar != null) {
            aVar2.e = this.b.b(bVar);
        }
        xi.a.c cVar = aVar.e;
        if (cVar != null) {
            aVar2.f = this.c.b(cVar);
        }
        return aVar2;
    }

    @NonNull
    public xi.a a(@NonNull ve.a.C0352a.C0353a aVar) {
        xi.a.C0363a aVar2;
        xi.a.b bVar;
        xi.a.c cVar;
        String str = TextUtils.isEmpty(aVar.b) ? null : aVar.b;
        String str2 = TextUtils.isEmpty(aVar.c) ? null : aVar.c;
        ve.a.C0352a.C0353a.C0354a aVar3 = aVar.d;
        if (aVar3 == null) {
            aVar2 = null;
        } else {
            aVar2 = this.a.a(aVar3);
        }
        ve.a.C0352a.C0353a.b bVar2 = aVar.e;
        if (bVar2 == null) {
            bVar = null;
        } else {
            bVar = this.b.a(bVar2);
        }
        ve.a.C0352a.C0353a.c cVar2 = aVar.f;
        if (cVar2 == null) {
            cVar = null;
        } else {
            cVar = this.c.a(cVar2);
        }
        return new xi.a(str, str2, aVar2, bVar, cVar);
    }
}
