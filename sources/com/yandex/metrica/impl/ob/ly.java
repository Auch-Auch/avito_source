package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class ly extends lo {
    public ly(@NonNull Context context, @NonNull lu luVar) {
        this(luVar, new mq(lv.a(context).c()));
    }

    @Override // com.yandex.metrica.impl.ob.lo
    public long c(long j) {
        return c().f(j);
    }

    @Override // com.yandex.metrica.impl.ob.lo
    @NonNull
    public mq d(long j) {
        return c().g(j);
    }

    @Override // com.yandex.metrica.impl.ob.lo
    @NonNull
    public String e() {
        return "lbs_dat";
    }

    @VisibleForTesting
    public ly(@NonNull lu luVar, @NonNull mq mqVar) {
        super(luVar, mqVar);
    }
}
