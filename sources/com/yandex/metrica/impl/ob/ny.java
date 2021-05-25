package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.cg;
import com.yandex.metrica.impl.ob.vc;
import com.yandex.metrica.impl.ob.vf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ny implements np<vf.a, vc.a> {
    private static final Map<Integer, cg.a> a = Collections.unmodifiableMap(new HashMap<Integer, cg.a>() { // from class: com.yandex.metrica.impl.ob.ny.1
        {
            put(1, cg.a.WIFI);
            put(2, cg.a.CELL);
        }
    });
    private static final Map<cg.a, Integer> b = Collections.unmodifiableMap(new HashMap<cg.a, Integer>() { // from class: com.yandex.metrica.impl.ob.ny.2
        {
            put(cg.a.WIFI, 1);
            put(cg.a.CELL, 2);
        }
    });

    @NonNull
    private List<vf.a.C0361a> b(@NonNull vc.a aVar) {
        ArrayList arrayList = new ArrayList();
        vc.a.C0349a[] aVarArr = aVar.b;
        for (vc.a.C0349a aVar2 : aVarArr) {
            arrayList.add(new vf.a.C0361a(aVar2.b, aVar2.c, aVar2.d, a(aVar2.e), aVar2.f, a(aVar2.g)));
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    public vc.a b(@NonNull vf.a aVar) {
        vc.a aVar2 = new vc.a();
        Set<String> a3 = aVar.a();
        aVar2.c = (String[]) a3.toArray(new String[a3.size()]);
        aVar2.b = b(aVar);
        return aVar2;
    }

    @NonNull
    public vf.a a(@NonNull vc.a aVar) {
        return new vf.a(b(aVar), Arrays.asList(aVar.c));
    }

    @NonNull
    private acb<String, String> a(@NonNull vc.a.C0349a.C0350a[] aVarArr) {
        acb<String, String> acb = new acb<>();
        for (vc.a.C0349a.C0350a aVar : aVarArr) {
            acb.a(aVar.b, aVar.c);
        }
        return acb;
    }

    private vc.a.C0349a[] b(@NonNull vf.a aVar) {
        List<vf.a.C0361a> b2 = aVar.b();
        vc.a.C0349a[] aVarArr = new vc.a.C0349a[b2.size()];
        for (int i = 0; i < b2.size(); i++) {
            aVarArr[i] = a(b2.get(i));
        }
        return aVarArr;
    }

    @NonNull
    private vc.a.C0349a a(@NonNull vf.a.C0361a aVar) {
        vc.a.C0349a aVar2 = new vc.a.C0349a();
        aVar2.b = aVar.a;
        aVar2.c = aVar.b;
        aVar2.e = b(aVar);
        aVar2.d = aVar.c;
        aVar2.f = aVar.e;
        aVar2.g = a(aVar.f);
        return aVar2;
    }

    @NonNull
    private vc.a.C0349a.C0350a[] b(@NonNull vf.a.C0361a aVar) {
        vc.a.C0349a.C0350a[] aVarArr = new vc.a.C0349a.C0350a[aVar.d.a()];
        Iterator<? extends Map.Entry<String, ? extends Collection<String>>> it = aVar.d.b().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            for (String str : (Collection) entry.getValue()) {
                vc.a.C0349a.C0350a aVar2 = new vc.a.C0349a.C0350a();
                aVar2.b = (String) entry.getKey();
                aVar2.c = str;
                aVarArr[i] = aVar2;
                i++;
            }
        }
        return aVarArr;
    }

    @NonNull
    private List<cg.a> a(@NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(a.get(Integer.valueOf(i)));
        }
        return arrayList;
    }

    @NonNull
    private int[] a(@NonNull List<cg.a> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = b.get(list.get(i)).intValue();
        }
        return iArr;
    }
}
