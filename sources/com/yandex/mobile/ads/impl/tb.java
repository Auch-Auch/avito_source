package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.impl.sa;
import java.util.concurrent.TimeUnit;
public abstract class tb<T> extends ry<T> {
    private static final int a = ((int) TimeUnit.SECONDS.toMillis(10));
    private final a<T> b;

    public interface a<T> extends sa.a, sa.b<T> {
    }

    public tb(int i, String str, a<T> aVar) {
        super(i, str, aVar);
        l();
        a((sc) new rt(a, 0, 1.0f));
        this.b = aVar;
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final void b(T t) {
        a<T> aVar = this.b;
        if (aVar != null) {
            aVar.a((a<T>) t);
        }
    }
}
