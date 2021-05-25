package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xi;
import java.util.ArrayList;
import java.util.List;
public class oi implements nq<xi.a, ve.a.C0352a.C0353a> {
    @NonNull
    private final oh a;

    public oi() {
        this(new oh());
    }

    @VisibleForTesting
    public oi(@NonNull oh ohVar) {
        this.a = ohVar;
    }

    @NonNull
    public List<xi.a> a(@NonNull ve.a.C0352a.C0353a[] aVarArr) {
        ArrayList arrayList = new ArrayList(aVarArr.length);
        for (ve.a.C0352a.C0353a aVar : aVarArr) {
            arrayList.add(this.a.a(aVar));
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.C0352a.C0353a[] b(@NonNull List<xi.a> list) {
        ve.a.C0352a.C0353a[] aVarArr = new ve.a.C0352a.C0353a[list.size()];
        for (int i = 0; i < list.size(); i++) {
            aVarArr[i] = this.a.b(list.get(i));
        }
        return aVarArr;
    }
}
