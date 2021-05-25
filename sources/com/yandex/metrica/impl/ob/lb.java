package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.ob.la;
public class lb extends la {
    @NonNull
    private cq a;

    public lb(@NonNull cq cqVar, la.a aVar, @Nullable c cVar) {
        super(aVar, cVar);
        this.a = cqVar;
    }

    @Override // com.yandex.metrica.impl.ob.la
    public void b(@NonNull ld ldVar) {
        this.a.a().a(ldVar);
    }
}
