package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class lz extends lo {
    public lz(@NonNull Context context, @NonNull lu luVar) {
        this(luVar, new mq(lv.a(context).c()));
    }

    @Override // com.yandex.metrica.impl.ob.lo
    public long c(long j) {
        return c().d(j);
    }

    @Override // com.yandex.metrica.impl.ob.lo
    @NonNull
    public mq d(long j) {
        return c().e(j);
    }

    @Override // com.yandex.metrica.impl.ob.lo
    @NonNull
    public String e() {
        return "l_dat";
    }

    @VisibleForTesting
    public lz(@NonNull lu luVar, @NonNull mq mqVar) {
        super(luVar, mqVar);
    }
}
