package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.i1;
import a2.j.b.e.a.b.k2;
import a2.j.b.e.a.b.m0;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.v;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import com.google.android.play.core.splitinstall.z;
import java.util.concurrent.Executor;
public final class j implements ci<k2> {
    public final ci<a0> a;
    public final ci<q2> b;
    public final ci<v> c;
    public final ci<z> d;
    public final ci<i1> e;
    public final ci<t0> f;
    public final ci<m0> g;
    public final ci<Executor> h;

    public j(ci<a0> ciVar, ci<q2> ciVar2, ci<v> ciVar3, ci<z> ciVar4, ci<i1> ciVar5, ci<t0> ciVar6, ci<m0> ciVar7, ci<Executor> ciVar8) {
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
    public final /* bridge */ /* synthetic */ k2 a() {
        return new k2(this.a.a(), cg.b(this.b), this.c.a(), this.d.a(), this.e.a(), this.f.a(), this.g.a(), cg.b(this.h));
    }
}
