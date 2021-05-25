package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
import com.yandex.metrica.impl.ob.xi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
public class oj implements np<xi.b, ve.a.C0352a.b> {
    private static final Map<Integer, xi.b.a> a;
    private static final Map<xi.b.a, Integer> b;
    private static final Map<Integer, xi.b.EnumC0364b> c;
    private static final Map<xi.b.EnumC0364b, Integer> d;
    private static final Map<Integer, xi.b.c> e;
    private static final Map<xi.b.c, Integer> f;
    private static final Map<Integer, xi.b.d> g;
    private static final Map<xi.b.d, Integer> h;

    static {
        HashMap hashMap = new HashMap();
        xi.b.a aVar = xi.b.a.ALL_MATCHES;
        hashMap.put(1, aVar);
        xi.b.a aVar2 = xi.b.a.FIRST_MATCH;
        hashMap.put(2, aVar2);
        xi.b.a aVar3 = xi.b.a.MATCH_LOST;
        hashMap.put(3, aVar3);
        a = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(aVar, 1);
        hashMap2.put(aVar2, 2);
        hashMap2.put(aVar3, 3);
        b = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        xi.b.EnumC0364b bVar = xi.b.EnumC0364b.AGGRESSIVE;
        hashMap3.put(1, bVar);
        xi.b.EnumC0364b bVar2 = xi.b.EnumC0364b.STICKY;
        hashMap3.put(2, bVar2);
        c = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(bVar, 1);
        hashMap4.put(bVar2, 2);
        d = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        xi.b.c cVar = xi.b.c.ONE_AD;
        hashMap5.put(1, cVar);
        xi.b.c cVar2 = xi.b.c.FEW_AD;
        hashMap5.put(2, cVar2);
        xi.b.c cVar3 = xi.b.c.MAX_AD;
        hashMap5.put(3, cVar3);
        e = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put(cVar, 1);
        hashMap6.put(cVar2, 2);
        hashMap6.put(cVar3, 3);
        f = Collections.unmodifiableMap(hashMap6);
        HashMap hashMap7 = new HashMap();
        xi.b.d dVar = xi.b.d.LOW_POWER;
        hashMap7.put(1, dVar);
        xi.b.d dVar2 = xi.b.d.BALANCED;
        hashMap7.put(2, dVar2);
        xi.b.d dVar3 = xi.b.d.LOW_LATENCY;
        hashMap7.put(3, dVar3);
        g = Collections.unmodifiableMap(hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put(dVar, 1);
        hashMap8.put(dVar2, 2);
        hashMap8.put(dVar3, 3);
        h = Collections.unmodifiableMap(hashMap8);
    }

    @NonNull
    /* renamed from: a */
    public ve.a.C0352a.b b(@NonNull xi.b bVar) {
        ve.a.C0352a.b bVar2 = new ve.a.C0352a.b();
        bVar2.b = b.get(bVar.a).intValue();
        bVar2.c = d.get(bVar.b).intValue();
        bVar2.d = f.get(bVar.c).intValue();
        bVar2.e = h.get(bVar.d).intValue();
        bVar2.f = bVar.e;
        return bVar2;
    }

    @NonNull
    public xi.b a(@NonNull ve.a.C0352a.b bVar) {
        return new xi.b(a.get(Integer.valueOf(bVar.b)), c.get(Integer.valueOf(bVar.c)), e.get(Integer.valueOf(bVar.d)), g.get(Integer.valueOf(bVar.e)), bVar.f);
    }
}
