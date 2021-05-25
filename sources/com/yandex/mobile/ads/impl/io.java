package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
@SuppressLint({"ViewConstructor"})
public final class io extends kb {
    public io(@NonNull Context context, @NonNull x xVar) {
        super(context, xVar);
        layout(0, 0, eg.a(context), eg.b(context));
    }

    @Override // com.yandex.mobile.ads.impl.kb, com.yandex.mobile.ads.impl.ev
    public final void a() {
        er erVar = this.e;
        if (erVar != null) {
            erVar.onAdLoaded();
        }
    }
}
