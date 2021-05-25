package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.List;
public class iz extends iq<hu> {
    private final hu a;

    public iz(ix ixVar, hu huVar) {
        super(ixVar);
        this.a = huVar;
    }

    @Override // com.yandex.metrica.impl.ob.iq
    public void a(@NonNull List<hu> list) {
        list.add(this.a);
    }
}
