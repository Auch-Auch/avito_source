package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class qj extends pl {
    public qj(@NonNull qw qwVar, @NonNull mq mqVar, @Nullable pt ptVar) {
        this(qwVar, mqVar, ptVar, new cf());
    }

    @Override // com.yandex.metrica.impl.ob.pl
    @NonNull
    public qe a() {
        return new qe() { // from class: com.yandex.metrica.impl.ob.qj.1
            @Override // com.yandex.metrica.impl.ob.qe
            public long a() {
                return qj.this.a.l(0);
            }

            @Override // com.yandex.metrica.impl.ob.qe
            public void a(long j) {
                qj.this.a.m(j);
            }
        };
    }

    @Override // com.yandex.metrica.impl.ob.pl
    @NonNull
    public String b() {
        return "lbs";
    }

    @Override // com.yandex.metrica.impl.ob.pl
    @NonNull
    public String c() {
        return "network";
    }

    @VisibleForTesting
    public qj(@NonNull qw qwVar, @NonNull mq mqVar, @Nullable pt ptVar, @NonNull cf cfVar) {
        super(qwVar, mqVar, ptVar, cfVar);
    }

    @Override // com.yandex.metrica.impl.ob.pl
    @NonNull
    public sp a(@NonNull so soVar) {
        return this.d.d(soVar);
    }
}
