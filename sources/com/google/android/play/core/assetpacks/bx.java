package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.p0;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.v;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
public final class bx implements ci<p0> {
    public final ci<a0> a;
    public final ci<q2> b;
    public final ci<v> c;
    public final ci<t0> d;

    public bx(ci<a0> ciVar, ci<q2> ciVar2, ci<v> ciVar3, ci<t0> ciVar4) {
        this.a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ p0 a() {
        return new p0(this.a.a(), cg.b(this.b), cg.b(this.c), this.d.a());
    }
}
