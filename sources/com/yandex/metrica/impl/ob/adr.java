package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class adr<T> implements adw<T> {
    @NonNull
    private final String a;

    public adr(@NonNull String str) {
        this.a = str;
    }

    @Override // com.yandex.metrica.impl.ob.adw
    public adu a(@Nullable T t) {
        if (t != null) {
            return adu.a(this);
        }
        return adu.a(this, this.a + " is null.");
    }
}
