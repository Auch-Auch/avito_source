package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
public class qb {
    @NonNull
    private final mq a;
    @NonNull
    private final qw b;
    @Nullable
    private final py c;
    @NonNull
    private final qe d;
    @NonNull
    private final px e = d();
    @NonNull
    private final pv f;
    @NonNull
    private final qa g;

    public qb(@NonNull qw qwVar, @NonNull mq mqVar, @NonNull rj rjVar, @Nullable py pyVar) {
        this.b = qwVar;
        this.a = mqVar;
        this.c = pyVar;
        qe c2 = c();
        this.d = c2;
        this.f = b(c2);
        qa a3 = a(rjVar);
        this.g = a3;
        a3.a(pyVar);
    }

    @NonNull
    private pv b(@NonNull qe qeVar) {
        return new pv(this.c, qeVar);
    }

    @NonNull
    private qe c() {
        return new qe() { // from class: com.yandex.metrica.impl.ob.qb.1
            @Override // com.yandex.metrica.impl.ob.qe
            public long a() {
                return qb.this.a.p(0);
            }

            @Override // com.yandex.metrica.impl.ob.qe
            public void a(long j) {
                qb.this.a.q(j);
            }
        };
    }

    @NonNull
    private px d() {
        return new px(this.b.a.b, this.c);
    }

    @NonNull
    private pk a(@NonNull qe qeVar) {
        return new pk(qeVar);
    }

    @NonNull
    public List<pz> b() {
        return Arrays.asList(this.f, this.e, this.g);
    }

    @NonNull
    private qa a(@NonNull rj rjVar) {
        po poVar = this.b.a;
        return new qa(poVar.a, rjVar, poVar.b.b(), this.b.a.c);
    }

    @NonNull
    public qy a() {
        return new qy(this.g, this.f, a(this.d), this.e);
    }
}
