package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tb;
public abstract class tc<R, T> extends tb<T> {
    @NonNull
    private final R a;
    @NonNull
    private final hw<R, T> b;
    @NonNull
    private final ht c;

    public tc(@NonNull Context context, int i, @NonNull String str, @NonNull tb.a<T> aVar, @NonNull R r, @NonNull hw<R, T> hwVar) {
        super(i, str, aVar);
        this.a = r;
        this.b = hwVar;
        ht a3 = ht.a(context);
        this.c = a3;
        a3.a(hwVar.a(r));
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final sa<T> a(@NonNull rx rxVar) {
        int i = rxVar.a;
        sa<T> a3 = a(rxVar, i);
        a(a3, i);
        return a3;
    }

    public abstract sa<T> a(@NonNull rx rxVar, int i);

    @Override // com.yandex.mobile.ads.impl.ry
    public sl a(sl slVar) {
        rx rxVar = slVar.a;
        a((sa) null, rxVar != null ? rxVar.a : -1);
        return super.a(slVar);
    }

    private void a(@Nullable sa<T> saVar, int i) {
        this.c.a(this.b.a(saVar, i, this.a));
    }
}
