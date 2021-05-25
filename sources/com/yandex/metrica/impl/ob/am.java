package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class am {
    @NonNull
    private final dg a;
    @NonNull
    private final q b;

    public am(@NonNull Context context) {
        this(new dg(context, "com.yandex.android.appmetrica.build_id"), new q(context, "com.yandex.android.appmetrica.is_offline"));
    }

    @Nullable
    public String a() {
        return (String) this.a.a();
    }

    @Nullable
    public Boolean b() {
        return (Boolean) this.b.a();
    }

    @VisibleForTesting
    public am(@NonNull dg dgVar, @NonNull q qVar) {
        this.a = dgVar;
        this.b = qVar;
    }
}
