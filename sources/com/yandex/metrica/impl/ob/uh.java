package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.uy;
public class uh implements tz {
    @NonNull
    private final ade a;

    public uh(@NonNull ade ade) {
        this.a = ade;
    }

    @Override // com.yandex.metrica.impl.ob.tz
    @Nullable
    public uy.a.C0346a a(@NonNull uq uqVar, @NonNull uy.a.C0346a aVar) {
        if (uqVar.a() == this.a.a()) {
            if (uqVar.a(aVar.c, new String(aVar.b)) != null) {
                uqVar.a(aVar);
            }
        } else if (uqVar.a() < this.a.a()) {
            uqVar.a(aVar);
            uqVar.b();
        }
        return aVar;
    }
}
