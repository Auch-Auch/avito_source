package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public class rc implements ph, qn {
    @Nullable
    private pt a;

    public rc(@Nullable pt ptVar) {
        this.a = ptVar;
    }

    @Override // com.yandex.metrica.impl.ob.ph
    public boolean a() {
        return this.a != null;
    }

    @Override // com.yandex.metrica.impl.ob.ph
    public boolean b() {
        pt ptVar = this.a;
        return ptVar != null && ptVar.a.a;
    }

    @Override // com.yandex.metrica.impl.ob.qn
    public void a(@Nullable pt ptVar) {
        this.a = ptVar;
    }
}
