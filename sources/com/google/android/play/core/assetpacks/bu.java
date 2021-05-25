package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.e2;
import a2.j.b.e.a.b.i1;
import a2.j.b.e.a.b.k0;
import a2.j.b.e.a.b.k1;
import a2.j.b.e.a.b.k2;
import a2.j.b.e.a.b.m0;
import a2.j.b.e.a.b.n0;
import a2.j.b.e.a.b.n2;
import a2.j.b.e.a.b.o2;
import a2.j.b.e.a.b.p0;
import a2.j.b.e.a.b.p2;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.r;
import a2.j.b.e.a.b.r0;
import a2.j.b.e.a.b.r1;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.t1;
import a2.j.b.e.a.b.u0;
import a2.j.b.e.a.b.v;
import a2.j.b.e.a.b.w1;
import a2.j.b.e.a.b.x1;
import a2.j.b.e.a.b.y1;
import android.content.Context;
import com.google.android.play.core.internal.cf;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import com.google.android.play.core.splitinstall.z;
import java.util.concurrent.Executor;
public final class bu implements a {
    public final n2 a;
    public ci<Context> b;
    public ci<x1> c;
    public ci<a0> d;
    public ci<t0> e;
    public ci<r> f;
    public ci<String> g = cg.a(new s(this.b));
    public ci<q2> h = new cf();
    public ci<Executor> i;
    public ci<i1> j;
    public ci<v> k;
    public ci<p0> l;
    public ci<e2> m;
    public ci<t1> n;
    public ci<w1> o;
    public ci<y1> p;
    public ci<k0> q;
    public ci<k1> r;
    public ci<r0> s;
    public ci<m0> t;
    public ci<Executor> u;
    public ci<r1> v;
    public ci<z> w;
    public ci<k2> x;
    public ci<AssetPackManager> y;

    public /* synthetic */ bu(n2 n2Var) {
        this.a = n2Var;
        r rVar = new r(n2Var);
        this.b = rVar;
        ci<x1> a3 = cg.a(new dm(rVar));
        this.c = a3;
        this.d = cg.a(new bd(this.b, a3));
        ci<t0> a4 = cg.a(u0.a);
        this.e = a4;
        this.f = cg.a(new as(this.b, a4));
        ci<Executor> a5 = cg.a(o2.a);
        this.i = a5;
        this.j = cg.a(new cs(this.d, this.h, this.e, a5));
        cf cfVar = new cf();
        this.k = cfVar;
        this.l = cg.a(new bx(this.d, this.h, cfVar, this.e));
        this.m = cg.a(new dw(this.d));
        this.n = cg.a(new dg(this.d));
        this.o = cg.a(new dk(this.d, this.h, this.j, this.i, this.e));
        this.p = cg.a(new dp(this.d, this.h));
        ci<k0> a6 = cg.a(new bo(this.h));
        this.q = a6;
        ci<k1> a8 = cg.a(new cv(this.j, this.d, a6));
        this.r = a8;
        this.s = cg.a(new ca(this.j, this.h, this.l, this.m, this.n, this.o, this.p, a8));
        this.t = cg.a(n0.a);
        ci<Executor> a9 = cg.a(p2.a);
        this.u = a9;
        cf.a(this.k, cg.a(new ax(this.b, this.j, this.s, this.h, this.e, this.t, this.i, a9)));
        ci<r1> a10 = cg.a(new dc(this.g, this.k, this.e, this.b, this.c, this.i));
        this.v = a10;
        cf.a(this.h, cg.a(new q(this.b, this.f, a10)));
        ci<z> a11 = cg.a(new t(this.b));
        this.w = a11;
        ci<k2> a12 = cg.a(new j(this.d, this.h, this.k, a11, this.j, this.e, this.t, this.i));
        this.x = a12;
        this.y = cg.a(new p(a12, this.b));
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final AssetPackManager a() {
        return this.y.a();
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final void a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.b = r.a(this.a);
        assetPackExtractionService.c = this.x.a();
        assetPackExtractionService.d = this.d.a();
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final a0 b() {
        return this.d.a();
    }
}
