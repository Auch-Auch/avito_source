package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.us;
public class le implements nh<ky, us.a> {
    @NonNull
    private lj a;

    public le(@NonNull lj ljVar) {
        this.a = ljVar;
    }

    @NonNull
    /* renamed from: a */
    public us.a b(@NonNull ky kyVar) {
        us.a aVar = new us.a();
        aVar.b = this.a.b(kyVar.a);
        aVar.c = new us.e[kyVar.b.size()];
        int i = 0;
        for (lc lcVar : kyVar.b) {
            aVar.c[i] = this.a.b(lcVar);
            i++;
        }
        return aVar;
    }

    @NonNull
    public ky a(@NonNull us.a aVar) {
        throw new UnsupportedOperationException();
    }
}
