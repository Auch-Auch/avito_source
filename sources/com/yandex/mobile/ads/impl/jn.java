package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
public final class jn implements ci {
    @Nullable
    private x a;

    public final void a(@Nullable x xVar) {
        this.a = xVar;
    }

    @Override // com.yandex.mobile.ads.impl.ci
    @Nullable
    public final String a() {
        x xVar = this.a;
        if (xVar != null) {
            return xVar.m();
        }
        return null;
    }
}
