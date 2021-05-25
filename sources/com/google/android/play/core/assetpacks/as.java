package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.r;
import a2.j.b.e.a.b.t0;
import android.content.Context;
import com.google.android.play.core.internal.ci;
public final class as implements ci<r> {
    public final ci<Context> a;
    public final ci<t0> b;

    public as(ci<Context> ciVar, ci<t0> ciVar2) {
        this.a = ciVar;
        this.b = ciVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ r a() {
        return new r(((r) this.a).a(), this.b.a());
    }
}
