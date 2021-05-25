package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.gg;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class fc<CU extends gg> {
    private final List<CU> a = new CopyOnWriteArrayList();

    public void a(@NonNull CU cu) {
        this.a.add(cu);
    }

    public void b(@NonNull CU cu) {
        this.a.remove(cu);
    }

    public List<CU> a() {
        return this.a;
    }
}
