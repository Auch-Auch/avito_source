package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.n2;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.r;
import a2.j.b.e.a.b.r1;
import android.content.Context;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
public final class q implements ci<q2> {
    public final ci<Context> a;
    public final ci<r> b;
    public final ci<r1> c;

    public q(ci<Context> ciVar, ci<r> ciVar2, ci<r1> ciVar3) {
        this.a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ q2 a() {
        q2 q2Var = (q2) (n2.a(((r) this.a).a()) == null ? cg.b(this.b).a() : cg.b(this.c).a());
        bl.a(q2Var, "Cannot return null from a non-@Nullable @Provides method");
        return q2Var;
    }
}
