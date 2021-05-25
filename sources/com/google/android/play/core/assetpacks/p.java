package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.k2;
import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;
public final class p implements ci<AssetPackManager> {
    public final ci<k2> a;
    public final ci<Context> b;

    public p(ci<k2> ciVar, ci<Context> ciVar2) {
        this.a = ciVar;
        this.b = ciVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.ci
    public final /* bridge */ /* synthetic */ AssetPackManager a() {
        k2 a3 = this.a.a();
        Context b2 = ((r) this.b).a();
        k2 k2Var = a3;
        bl.a(b2.getPackageManager(), new ComponentName(b2.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"));
        PlayCoreDialogWrapperActivity.a(b2);
        bl.a(k2Var, "Cannot return null from a non-@Nullable @Provides method");
        return k2Var;
    }
}
