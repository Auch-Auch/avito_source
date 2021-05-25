package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class adm<T> implements adn<T> {
    @NonNull
    private final adn<T> a;
    @Nullable
    private final T b;

    public adm(@NonNull adn<T> adn, @Nullable T t) {
        this.a = adn;
        this.b = t;
    }

    @Override // com.yandex.metrica.impl.ob.adn
    @Nullable
    public T a(@Nullable T t) {
        return t != this.a.a(t) ? this.b : t;
    }
}
