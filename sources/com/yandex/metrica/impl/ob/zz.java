package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
public class zz implements zt {
    @NonNull
    private final List<aam> a = new ArrayList();

    @Override // com.yandex.metrica.impl.ob.zw
    public void a(@NonNull aam aam) {
        this.a.add(aam);
    }

    @Override // com.yandex.metrica.impl.ob.zt
    @NonNull
    public List<aam> a() {
        return this.a;
    }
}
