package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.i1;
import a2.j.b.e.a.b.k0;
import a2.j.b.e.a.b.k1;
import com.google.android.play.core.internal.ci;
public final class cv implements ci<k1> {
    public final ci<i1> a;
    public final ci<a0> b;
    public final ci<k0> c;

    public cv(ci<i1> ciVar, ci<a0> ciVar2, ci<k0> ciVar3) {
        this.a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ k1 a() {
        return new k1(this.a.a(), this.b.a(), this.c.a());
    }
}
