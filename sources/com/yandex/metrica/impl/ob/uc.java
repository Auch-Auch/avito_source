package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.uy;
public class uc extends ua {
    public uc(@NonNull tz tzVar) {
        super(tzVar);
    }

    @Override // com.yandex.metrica.impl.ob.ua
    public uy.a.C0346a a(@NonNull uq uqVar, @Nullable uy.a.C0346a aVar, @NonNull ty tyVar) {
        if (a(aVar)) {
            return a().a(uqVar, tyVar.a());
        }
        aVar.d = new uy.a.b();
        return aVar;
    }
}
