package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
import java.util.ArrayList;
import java.util.List;
public class nv implements nq<sr, ve.a.e> {
    @NonNull
    /* renamed from: a */
    public ve.a.e[] b(@NonNull List<sr> list) {
        ve.a.e[] eVarArr = new ve.a.e[list.size()];
        for (int i = 0; i < list.size(); i++) {
            eVarArr[i] = a(list.get(i));
        }
        return eVarArr;
    }

    @NonNull
    public List<sr> a(@NonNull ve.a.e[] eVarArr) {
        ArrayList arrayList = new ArrayList(eVarArr.length);
        for (ve.a.e eVar : eVarArr) {
            arrayList.add(a(eVar));
        }
        return arrayList;
    }

    @NonNull
    private ve.a.e a(@NonNull sr srVar) {
        ve.a.e eVar = new ve.a.e();
        eVar.b = srVar.a;
        eVar.c = srVar.b;
        return eVar;
    }

    @NonNull
    private sr a(@NonNull ve.a.e eVar) {
        return new sr(eVar.b, eVar.c);
    }
}
