package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.uy;
public class um extends ua {
    public um(@NonNull tz tzVar) {
        super(tzVar);
    }

    @Override // com.yandex.metrica.impl.ob.ua
    public uy.a.C0346a a(@NonNull uq uqVar, @Nullable uy.a.C0346a aVar, @NonNull ty tyVar) {
        if (!a(aVar)) {
            return null;
        }
        uy.a.C0346a a = tyVar.a();
        a.d.b = true;
        return a().a(uqVar, a);
    }
}
