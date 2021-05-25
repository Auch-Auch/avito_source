package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.wj;
public abstract class ce<T extends wj> extends ca<T> {
    @NonNull
    private final bz j;

    public ce(@NonNull bz bzVar, @NonNull T t) {
        super(t);
        this.j = bzVar;
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean b() {
        return this.j.a(k(), l(), m());
    }
}
