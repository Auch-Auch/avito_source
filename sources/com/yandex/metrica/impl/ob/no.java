package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
import java.util.ArrayList;
import java.util.List;
public class no implements nq<qd, ve.a.m.C0360a> {
    @NonNull
    /* renamed from: a */
    public ve.a.m.C0360a[] b(@NonNull List<qd> list) {
        ve.a.m.C0360a[] aVarArr = new ve.a.m.C0360a[list.size()];
        for (int i = 0; i < list.size(); i++) {
            aVarArr[i] = a(list.get(i));
        }
        return aVarArr;
    }

    @NonNull
    public List<qd> a(@NonNull ve.a.m.C0360a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (ve.a.m.C0360a aVar : aVarArr) {
            arrayList.add(a(aVar));
        }
        return arrayList;
    }

    @NonNull
    private ve.a.m.C0360a a(@NonNull qd qdVar) {
        ve.a.m.C0360a aVar = new ve.a.m.C0360a();
        aVar.b = qdVar.a;
        aVar.c = qdVar.b;
        return aVar;
    }

    @NonNull
    private qd a(@NonNull ve.a.m.C0360a aVar) {
        return new qd(aVar.b, aVar.c);
    }
}
