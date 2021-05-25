package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
public abstract class pl {
    @NonNull
    public final mq a;
    @NonNull
    public final qw b;
    @Nullable
    public final pt c;
    @NonNull
    public final cf d;
    @NonNull
    private final qe e;
    @NonNull
    private final pi f;
    @NonNull
    private final pj g;

    public pl(@NonNull qw qwVar, @NonNull mq mqVar, @Nullable pt ptVar, @NonNull cf cfVar) {
        this.b = qwVar;
        this.a = mqVar;
        this.c = ptVar;
        this.d = cfVar;
        qe a3 = a();
        this.e = a3;
        this.f = new pi(ptVar, a3, b());
        this.g = new pj(qwVar.a.b, ptVar);
    }

    @NonNull
    private qx b(@NonNull rj rjVar) {
        po poVar = this.b.a;
        Context context = poVar.a;
        Looper b2 = poVar.b.b();
        qw qwVar = this.b;
        return new rn(context, b2, qwVar.c, rjVar, a(qwVar.a.c), c());
    }

    @NonNull
    public abstract qe a();

    @NonNull
    public qy a(@NonNull rj rjVar) {
        return new qy(b(rjVar), this.f, new pk(this.e), this.g);
    }

    @NonNull
    public abstract sp a(@NonNull so soVar);

    @NonNull
    public abstract String b();

    @NonNull
    public abstract String c();

    @NonNull
    public List<qn> d() {
        return Arrays.asList(this.f, this.g);
    }
}
