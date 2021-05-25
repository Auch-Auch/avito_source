package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class rf implements db<oy> {
    private final ce<oy> a;

    public rf(@NonNull Context context) {
        this.a = new po(context);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.db
    @Nullable
    public final /* synthetic */ oy a(@NonNull rx rxVar) {
        return this.a.b(rxVar);
    }

    @Override // com.yandex.mobile.ads.impl.db
    public final boolean a() {
        return true;
    }
}
