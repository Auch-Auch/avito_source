package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.TextUtils;
public class ij extends hu {
    public ij(fe feVar) {
        super(feVar);
    }

    private boolean b(aa aaVar) {
        return !TextUtils.isEmpty(aaVar.l()) && TextUtils.isEmpty(a().h());
    }

    @Override // com.yandex.metrica.impl.ob.hq
    public boolean a(@NonNull aa aaVar) {
        if (!b(aaVar)) {
            return false;
        }
        a().a(aaVar.l());
        return false;
    }
}
