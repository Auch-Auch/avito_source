package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public class abb extends abe {
    private static final abb a = new abb();

    public abb(@Nullable String str) {
        super(str);
    }

    public static abb h() {
        return a;
    }

    @Override // com.yandex.metrica.impl.ob.aat
    public boolean d() {
        super.d();
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.aat
    public String f() {
        return "AppMetricaInternal";
    }

    private abb() {
        this("");
    }
}
