package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.q2;
import a2.j.b.e.a.b.y1;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
public final class dp implements ci<y1> {
    public final ci<a0> a;
    public final ci<q2> b;

    public dp(ci<a0> ciVar, ci<q2> ciVar2) {
        this.a = ciVar;
        this.b = ciVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ y1 a() {
        return new y1(this.a.a(), cg.b(this.b));
    }
}
