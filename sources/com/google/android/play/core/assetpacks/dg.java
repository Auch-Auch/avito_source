package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.t1;
import com.google.android.play.core.internal.ci;
public final class dg implements ci<t1> {
    public final ci<a0> a;

    public dg(ci<a0> ciVar) {
        this.a = ciVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ t1 a() {
        return new t1(this.a.a());
    }
}
