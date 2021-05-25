package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.r1;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.v;
import a2.j.b.e.a.b.x1;
import android.content.Context;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import java.io.File;
import java.util.concurrent.Executor;
public final class dc implements ci<r1> {
    public final ci<String> a;
    public final ci<v> b;
    public final ci<t0> c;
    public final ci<Context> d;
    public final ci<x1> e;
    public final ci<Executor> f;

    public dc(ci<String> ciVar, ci<v> ciVar2, ci<t0> ciVar3, ci<Context> ciVar4, ci<x1> ciVar5, ci<Executor> ciVar6) {
        this.a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
        this.e = ciVar5;
        this.f = ciVar6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ r1 a() {
        String a3 = this.a.a();
        v a4 = this.b.a();
        t0 a5 = this.c.a();
        Context b2 = ((r) this.d).a();
        x1 a6 = this.e.a();
        return new r1(a3 != null ? new File(b2.getExternalFilesDir(null), a3) : b2.getExternalFilesDir(null), a4, a5, b2, a6, cg.b(this.f));
    }
}
