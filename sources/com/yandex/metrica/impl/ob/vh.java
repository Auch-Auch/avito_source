package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.g;
public class vh {
    @NonNull
    private final vl a;
    @NonNull
    private final act b;
    @NonNull
    private final vg c;
    @NonNull
    private final g d;
    @NonNull
    private final vj e;

    @VisibleForTesting
    public vh(@NonNull vl vlVar, @NonNull act act, @NonNull vg vgVar, @NonNull g gVar, @NonNull vj vjVar) {
        this.a = vlVar;
        this.b = act;
        this.c = vgVar;
        this.d = gVar;
        this.e = vjVar;
    }

    @NonNull
    public act a() {
        return this.b;
    }

    @NonNull
    public vl b() {
        return this.a;
    }

    @NonNull
    public vg c() {
        return this.c;
    }

    @NonNull
    public g d() {
        return this.d;
    }

    @NonNull
    public vj e() {
        return this.e;
    }
}
