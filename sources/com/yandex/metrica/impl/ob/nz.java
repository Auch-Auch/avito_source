package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class nz implements np<xp, ve.a.g> {
    private static final Map<Integer, xp.a> a = Collections.unmodifiableMap(new HashMap<Integer, xp.a>() { // from class: com.yandex.metrica.impl.ob.nz.1
        {
            put(1, xp.a.WIFI);
            put(2, xp.a.CELL);
        }
    });
    private static final Map<xp.a, Integer> b = Collections.unmodifiableMap(new HashMap<xp.a, Integer>() { // from class: com.yandex.metrica.impl.ob.nz.2
        {
            put(xp.a.WIFI, 1);
            put(xp.a.CELL, 2);
        }
    });

    @NonNull
    private int[] b(@NonNull List<xp.a> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = b.get(list.get(i)).intValue();
        }
        return iArr;
    }

    @NonNull
    /* renamed from: a */
    public ve.a.g b(@NonNull xp xpVar) {
        ve.a.g gVar = new ve.a.g();
        gVar.b = xpVar.a;
        gVar.c = xpVar.b;
        gVar.d = xpVar.c;
        gVar.e = a(xpVar.d);
        Long l = xpVar.e;
        gVar.f = l == null ? 0 : l.longValue();
        gVar.g = b(xpVar.f);
        return gVar;
    }

    @NonNull
    public xp a(@NonNull ve.a.g gVar) {
        return new xp(gVar.b, gVar.c, gVar.d, a(gVar.e), Long.valueOf(gVar.f), a(gVar.g));
    }

    @NonNull
    private ve.a.g.C0359a[] a(@NonNull List<Pair<String, String>> list) {
        ve.a.g.C0359a[] aVarArr = new ve.a.g.C0359a[list.size()];
        int i = 0;
        for (Pair<String, String> pair : list) {
            ve.a.g.C0359a aVar = new ve.a.g.C0359a();
            aVar.b = (String) pair.first;
            aVar.c = (String) pair.second;
            aVarArr[i] = aVar;
            i++;
        }
        return aVarArr;
    }

    @NonNull
    private List<Pair<String, String>> a(@NonNull ve.a.g.C0359a[] aVarArr) {
        ArrayList arrayList = new ArrayList(aVarArr.length);
        for (ve.a.g.C0359a aVar : aVarArr) {
            arrayList.add(new Pair(aVar.b, aVar.c));
        }
        return arrayList;
    }

    @NonNull
    private List<xp.a> a(@NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(a.get(Integer.valueOf(i)));
        }
        return arrayList;
    }
}
