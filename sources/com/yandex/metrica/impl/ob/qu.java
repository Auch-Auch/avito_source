package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.p;
import java.util.List;
public class qu {
    @NonNull
    public final List<p.a.EnumC0340a> a;
    @NonNull
    public final List<k.a> b;

    public qu(@NonNull List<p.a.EnumC0340a> list, @NonNull List<k.a> list2) {
        this.a = list;
        this.b = list2;
    }

    public String toString() {
        StringBuilder L = a.L("Preconditions{possibleChargeTypes=");
        L.append(this.a);
        L.append(", appStatuses=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }
}
