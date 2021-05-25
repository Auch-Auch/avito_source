package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uy;
public class uj extends ud<Double> {
    public uj(@NonNull String str, double d, @NonNull adw<String> adw, @NonNull ua uaVar) {
        super(1, str, Double.valueOf(d), adw, uaVar);
    }

    @Override // com.yandex.metrica.impl.ob.ud
    public void a(@NonNull uy.a.C0346a aVar) {
        aVar.e.c = ((Double) b()).doubleValue();
    }
}
