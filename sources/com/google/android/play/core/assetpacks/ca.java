package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.e2;
import a2.j.b.e.a.b.i1;
import a2.j.b.e.a.b.k1;
import a2.j.b.e.a.b.p0;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.r0;
import a2.j.b.e.a.b.t1;
import a2.j.b.e.a.b.w1;
import a2.j.b.e.a.b.y1;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
public final class ca implements ci<r0> {
    public final ci<i1> a;
    public final ci<q2> b;
    public final ci<p0> c;
    public final ci<e2> d;
    public final ci<t1> e;
    public final ci<w1> f;
    public final ci<y1> g;
    public final ci<k1> h;

    public ca(ci<i1> ciVar, ci<q2> ciVar2, ci<p0> ciVar3, ci<e2> ciVar4, ci<t1> ciVar5, ci<w1> ciVar6, ci<y1> ciVar7, ci<k1> ciVar8) {
        this.a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
        this.e = ciVar5;
        this.f = ciVar6;
        this.g = ciVar7;
        this.h = ciVar8;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ r0 a() {
        return new r0(this.a.a(), cg.b(this.b), this.c.a(), this.d.a(), this.e.a(), this.f.a(), this.g.a(), this.h.a());
    }
}
