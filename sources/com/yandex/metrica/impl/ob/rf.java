package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.List;
public class rf {
    @Nullable
    public final pt a;
    @NonNull
    public final qw b;
    @NonNull
    private final cf c;
    @NonNull
    private final rc d;

    public rf(@NonNull qw qwVar, @Nullable pt ptVar) {
        this(qwVar, ptVar, new cf());
    }

    @NonNull
    private rd b() {
        return new rd();
    }

    @NonNull
    private re c() {
        return new re();
    }

    @NonNull
    private rc d() {
        return new rc(this.a);
    }

    @NonNull
    public qy a(@NonNull rj rjVar) {
        return new qy(b(rjVar), this.d, c(), b());
    }

    @VisibleForTesting
    public rf(@NonNull qw qwVar, @Nullable pt ptVar, @NonNull cf cfVar) {
        this.b = qwVar;
        this.a = ptVar;
        this.c = cfVar;
        this.d = d();
    }

    @NonNull
    private qx b(@NonNull rj rjVar) {
        po poVar = this.b.a;
        Context context = poVar.a;
        Looper b2 = poVar.b.b();
        qw qwVar = this.b;
        return new rn(context, b2, qwVar.c, rjVar, this.c.c(qwVar.a.c), "passive");
    }

    @NonNull
    public List<qn> a() {
        return Arrays.asList(this.d);
    }
}
