package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.n2;
import android.content.Context;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;
public final class r implements ci<Context> {
    public final n2 a;

    public r(n2 n2Var) {
        this.a = n2Var;
    }

    public static Context a(n2 n2Var) {
        Context context = n2Var.a;
        bl.a(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }

    /* renamed from: b */
    public final Context a() {
        return a(this.a);
    }
}
