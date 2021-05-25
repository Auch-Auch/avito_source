package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class ads<T> implements adw<T> {
    @NonNull
    private final adw<T> a;

    public ads(@NonNull adw<T> adw) {
        this.a = adw;
    }

    @Override // com.yandex.metrica.impl.ob.adw
    public adu a(@Nullable T t) {
        adu a3 = this.a.a(t);
        if (a3.a()) {
            return a3;
        }
        throw new adt(a3.b());
    }
}
