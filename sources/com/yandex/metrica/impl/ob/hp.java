package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ew;
public class hp extends hk {
    private final df a;
    @NonNull
    private final rp b;

    public hp(@NonNull ey eyVar, @NonNull df dfVar, @NonNull rp rpVar) {
        super(eyVar);
        this.a = dfVar;
        this.b = rpVar;
    }

    @Override // com.yandex.metrica.impl.ob.hk
    public boolean a(@NonNull aa aaVar, @NonNull gj gjVar) {
        ew.a a3 = gjVar.b().a();
        this.a.a(a3.m);
        a(a3.e, a3.r);
        return false;
    }

    private void a(@Nullable Boolean bool, @Nullable Boolean bool2) {
        if (aau.a(bool) || (bool == null && aau.a(bool2))) {
            this.b.a(true);
        } else if (aau.c(bool)) {
            this.b.a(false);
        }
    }
}
