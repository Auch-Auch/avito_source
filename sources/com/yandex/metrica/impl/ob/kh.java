package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
public class kh {
    @NonNull
    private final abf a;
    @NonNull
    private final kj b;

    public kh(@NonNull Context context) {
        this(new abf(), new kj(context));
    }

    @Nullable
    public Long a(@Nullable List<qd> list) {
        if (dl.a((Collection) list)) {
            return null;
        }
        qd qdVar = list.get(Math.min(this.b.a(), list.size()) - 1);
        long j = qdVar.a;
        long j2 = qdVar.b;
        if (j != j2) {
            j = this.a.a(j, j2);
        }
        return Long.valueOf(j);
    }

    @VisibleForTesting
    public kh(@NonNull abf abf, @NonNull kj kjVar) {
        this.a = abf;
        this.b = kjVar;
    }
}
