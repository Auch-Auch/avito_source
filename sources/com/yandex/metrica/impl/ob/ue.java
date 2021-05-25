package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uy;
public final class ue extends ud<Double> {
    public ue(@NonNull String str, double d) {
        super(2, str, Double.valueOf(d), new ug(), new uc(new uh(new ade(100))));
    }

    @Override // com.yandex.metrica.impl.ob.ud
    public void a(@NonNull uy.a.C0346a aVar) {
        uy.a.c cVar = aVar.e;
        cVar.d = ((Double) b()).doubleValue() + cVar.d;
    }
}
