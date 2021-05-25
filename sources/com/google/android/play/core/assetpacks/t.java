package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;
import com.google.android.play.core.splitinstall.z;
public final class t implements ci<z> {
    public final ci<Context> a;

    public t(ci<Context> ciVar) {
        this.a = ciVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ z a() {
        Context b = ((r) this.a).a();
        z zVar = new z(b, b.getPackageName());
        bl.a(zVar, "Cannot return null from a non-@Nullable @Provides method");
        return zVar;
    }
}
