package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class sx {
    @NonNull
    private final sy a;
    @NonNull
    private final te b;
    @Nullable
    private final Context c;

    public sx(@Nullable Context context, @NonNull te teVar) {
        this.b = teVar;
        this.c = context != null ? context.getApplicationContext() : null;
        this.a = fy.a().c();
    }

    public final sq a() {
        return new sz(this.c, this.a.a(id.a(21) ? td.a() : null));
    }
}
