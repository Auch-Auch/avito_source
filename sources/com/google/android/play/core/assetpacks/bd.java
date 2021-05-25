package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.a0;
import a2.j.b.e.a.b.x1;
import android.content.Context;
import com.google.android.play.core.internal.ci;
public final class bd implements ci<a0> {
    public final ci<Context> a;
    public final ci<x1> b;

    public bd(ci<Context> ciVar, ci<x1> ciVar2) {
        this.a = ciVar;
        this.b = ciVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ a0 a() {
        return new a0(((r) this.a).a(), this.b.a());
    }
}
