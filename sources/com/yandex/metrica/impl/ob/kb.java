package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class kb {
    @NonNull
    private Context a;
    @NonNull
    private ka b;
    @NonNull
    private kf c;

    public kb(@NonNull Context context) {
        this(context, new ka(context), new kf(context));
    }

    public void a() {
        this.a.getPackageName();
        this.c.a().a(this.b.a());
    }

    @VisibleForTesting
    public kb(@NonNull Context context, @NonNull ka kaVar, @NonNull kf kfVar) {
        this.a = context;
        this.b = kaVar;
        this.c = kfVar;
    }
}
