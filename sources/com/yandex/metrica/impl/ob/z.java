package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public abstract class z<T> implements y<T> {
    @Nullable
    private y<T> a;

    public z(@Nullable y<T> yVar) {
        this.a = yVar;
    }

    @Override // com.yandex.metrica.impl.ob.y
    public void a(@Nullable T t) {
        b(t);
        y<T> yVar = this.a;
        if (yVar != null) {
            yVar.a(t);
        }
    }

    public abstract void b(@Nullable T t);
}
