package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
public class qi {
    @NonNull
    private final ly a;
    @NonNull
    private final pr b;

    public qi(@NonNull Context context) {
        this(lv.a(context).h(), new pr(context));
    }

    public void a(@NonNull qk qkVar) {
        String a3 = this.b.a(qkVar);
        if (!TextUtils.isEmpty(a3)) {
            this.a.b(qkVar.b(), a3);
        }
    }

    @VisibleForTesting
    public qi(@NonNull ly lyVar, @NonNull pr prVar) {
        this.a = lyVar;
        this.b = prVar;
    }
}
