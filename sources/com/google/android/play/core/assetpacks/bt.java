package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.n2;
import com.google.android.play.core.internal.bl;
public final class bt {
    public n2 a;

    public bt() {
    }

    public /* synthetic */ bt(byte[] bArr) {
    }

    public final a a() {
        n2 n2Var = this.a;
        if (n2Var != null) {
            return new bu(n2Var);
        }
        throw new IllegalStateException(String.valueOf(n2.class.getCanonicalName()).concat(" must be set"));
    }

    public final void a(n2 n2Var) {
        bl.a(n2Var);
        this.a = n2Var;
    }
}
