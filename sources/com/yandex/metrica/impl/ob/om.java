package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ve;
public class om implements nh<aah, ve.a.k> {
    @NonNull
    /* renamed from: a */
    public ve.a.k b(@NonNull aah aah) {
        ve.a.k kVar = new ve.a.k();
        kVar.b = aah.a;
        kVar.c = aah.b;
        kVar.d = aah.c;
        kVar.e = aah.d;
        kVar.j = aah.e;
        kVar.k = aah.f;
        kVar.l = aah.g;
        kVar.f = aah.h;
        kVar.g = aah.i;
        kVar.h = aah.j;
        kVar.i = aah.k;
        return kVar;
    }

    @NonNull
    public aah a(@NonNull ve.a.k kVar) {
        return new aah(kVar.b, kVar.c, kVar.d, kVar.e, kVar.j, kVar.k, kVar.l, kVar.f, kVar.g, kVar.h, kVar.i);
    }
}
