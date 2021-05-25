package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.va;
public class jh implements nh<jg, va.a> {
    @NonNull
    /* renamed from: a */
    public va.a b(@NonNull jg jgVar) {
        va.a aVar = new va.a();
        aVar.e = new int[jgVar.c().size()];
        int i = 0;
        for (Integer num : jgVar.c()) {
            aVar.e[i] = num.intValue();
            i++;
        }
        aVar.d = jgVar.d();
        aVar.c = jgVar.e();
        aVar.b = jgVar.b();
        return aVar;
    }

    @NonNull
    public jg a(@NonNull va.a aVar) {
        return new jg(aVar.b, aVar.c, aVar.d, aVar.e);
    }
}
