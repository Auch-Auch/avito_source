package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.x1;
import android.content.Context;
import com.google.android.play.core.internal.ci;
public final class dm implements ci<x1> {
    public final ci<Context> a;

    public dm(ci<Context> ciVar) {
        this.a = ciVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ x1 a() {
        return new x1(((r) this.a).a());
    }
}
