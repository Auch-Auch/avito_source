package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.uy;
public abstract class ud<T> extends ui {
    @NonNull
    private final T a;

    public ud(int i, @NonNull String str, @NonNull T t, @NonNull adw<String> adw, @NonNull ua uaVar) {
        super(i, str, adw, uaVar);
        this.a = t;
    }

    @Override // com.yandex.metrica.impl.ob.ur
    public void a(@NonNull uq uqVar) {
        uy.a.C0346a b;
        if (f() && (b = b(uqVar)) != null) {
            a(b);
        }
    }

    public abstract void a(@NonNull uy.a.C0346a aVar);

    @NonNull
    public T b() {
        return this.a;
    }

    @Nullable
    private uy.a.C0346a b(@NonNull uq uqVar) {
        return e().a(uqVar, uqVar.a(d(), c()), this);
    }
}
