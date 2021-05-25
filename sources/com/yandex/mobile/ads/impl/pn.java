package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tb;
public final class pn extends bx<oy> {
    private final db<oy> a;

    public pn(@NonNull Context context, @NonNull db<oy> dbVar, @NonNull fo foVar, @NonNull String str, @NonNull String str2, @NonNull tb.a<x<oy>> aVar) {
        super(context, foVar, str, str2, aVar, new rd());
        this.a = dbVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.bx
    @Nullable
    public final /* synthetic */ oy a_(@NonNull rx rxVar) {
        return this.a.a(rxVar);
    }

    @Override // com.yandex.mobile.ads.impl.bx
    public final boolean b(@NonNull rx rxVar, int i) {
        return (200 == i || bx.a(i)) && bx.b(rxVar);
    }
}
