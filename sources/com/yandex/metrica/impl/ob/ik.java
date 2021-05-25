package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
public class ik extends hu {
    public ik(fe feVar) {
        super(feVar);
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        String B = a().B();
        String p = aaVar.p();
        a().b(p);
        if (TextUtils.equals(B, p)) {
            return false;
        }
        a().a(t.c());
        return false;
    }
}
