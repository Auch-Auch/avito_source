package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.vy;
import com.yandex.metrica.impl.ob.vy.a;
import com.yandex.metrica.impl.ob.vy.b;
import com.yandex.metrica.impl.ob.wb;
public abstract class vz<T extends wb, A extends vy.a<ew.a, A>, L extends vy.b<T, A>> extends wa<T, ew.a, A, L> {
    public vz(@NonNull L l, @NonNull yb ybVar, @NonNull A a) {
        super(l, ybVar, a);
    }

    public synchronized void a(@NonNull ew.a aVar) {
        super.a((vz<T, A, L>) aVar);
    }
}
