package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.vb;
import java.util.ArrayList;
import java.util.List;
public class nw implements nh<List<sr>, vb.a> {
    @NonNull
    /* renamed from: a */
    public vb.a b(@NonNull List<sr> list) {
        vb.a aVar = new vb.a();
        aVar.b = new vb.a.C0348a[list.size()];
        for (int i = 0; i < list.size(); i++) {
            aVar.b[i] = a(list.get(i));
        }
        return aVar;
    }

    @NonNull
    public List<sr> a(@NonNull vb.a aVar) {
        ArrayList arrayList = new ArrayList(aVar.b.length);
        int i = 0;
        while (true) {
            vb.a.C0348a[] aVarArr = aVar.b;
            if (i >= aVarArr.length) {
                return arrayList;
            }
            arrayList.add(a(aVarArr[i]));
            i++;
        }
    }

    @NonNull
    private vb.a.C0348a a(@NonNull sr srVar) {
        vb.a.C0348a aVar = new vb.a.C0348a();
        aVar.b = srVar.a;
        aVar.c = srVar.b;
        return aVar;
    }

    @NonNull
    private sr a(@NonNull vb.a.C0348a aVar) {
        return new sr(aVar.b, aVar.c);
    }
}
