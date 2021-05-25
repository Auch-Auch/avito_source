package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.List;
public abstract class iq<BaseHandler> {
    private final ix a;

    public iq(ix ixVar) {
        this.a = ixVar;
    }

    public ix a() {
        return this.a;
    }

    public abstract void a(@NonNull List<BaseHandler> list);
}
