package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.i1;
import a2.j.b.e.a.b.m0;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.r0;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.v;
import android.content.Context;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import java.util.concurrent.Executor;
public final class ax implements ci<v> {
    public final ci<Context> a;
    public final ci<i1> b;
    public final ci<r0> c;
    public final ci<q2> d;
    public final ci<t0> e;
    public final ci<m0> f;
    public final ci<Executor> g;
    public final ci<Executor> h;

    public ax(ci<Context> ciVar, ci<i1> ciVar2, ci<r0> ciVar3, ci<q2> ciVar4, ci<t0> ciVar5, ci<m0> ciVar6, ci<Executor> ciVar7, ci<Executor> ciVar8) {
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
    public final /* bridge */ /* synthetic */ v a() {
        return new v(((r) this.a).a(), this.b.a(), this.c.a(), cg.b(this.d), this.e.a(), this.f.a(), cg.b(this.g), cg.b(this.h));
    }
}
