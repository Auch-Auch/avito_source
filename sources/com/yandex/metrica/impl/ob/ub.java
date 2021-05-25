package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uy;
public class ub extends ud<Boolean> {
    public ub(@NonNull String str, boolean z, @NonNull adw<String> adw, @NonNull ua uaVar) {
        super(3, str, Boolean.valueOf(z), adw, uaVar);
    }

    @Override // com.yandex.metrica.impl.ob.ud
    public void a(@NonNull uy.a.C0346a aVar) {
        aVar.e.e = ((Boolean) b()).booleanValue();
    }
}
