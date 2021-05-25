package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.k0;
import a2.j.b.e.a.b.q2;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
public final class bo implements ci<k0> {
    public final ci<q2> a;

    public bo(ci<q2> ciVar) {
        this.a = ciVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ k0 a() {
        return new k0(cg.b(this.a));
    }
}
