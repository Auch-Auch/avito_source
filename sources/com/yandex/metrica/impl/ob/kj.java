package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class kj {
    @NonNull
    private final Context a;
    @NonNull
    private final ado b;

    public kj(@NonNull Context context) {
        this(context, new ado());
    }

    public int a() {
        try {
            return Math.max(1, this.b.b(this.a, new Intent().setAction("com.yandex.metrica.configuration.ACTION_INIT"), 128).size());
        } catch (Throwable unused) {
            return 1;
        }
    }

    @VisibleForTesting
    public kj(@NonNull Context context, @NonNull ado ado) {
        this.a = context;
        this.b = ado;
    }
}
