package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.i1;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.w1;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import java.util.concurrent.Executor;
public final class dk implements ci<w1> {
    public final ci<a0> a;
    public final ci<q2> b;
    public final ci<i1> c;
    public final ci<Executor> d;
    public final ci<t0> e;

    public dk(ci<a0> ciVar, ci<q2> ciVar2, ci<i1> ciVar3, ci<Executor> ciVar4, ci<t0> ciVar5) {
        this.a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
        this.e = ciVar5;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ w1 a() {
        a0 a3 = this.a.a();
        return new w1(a3, cg.b(this.b), this.c.a(), cg.b(this.d), this.e.a());
    }
}
