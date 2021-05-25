package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.e;
public abstract class mt<T extends e> implements mw<T> {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.metrica.impl.ob.mt<T extends com.yandex.metrica.impl.ob.e> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.nd
    @NonNull
    public /* bridge */ /* synthetic */ byte[] a(@NonNull Object obj) {
        return a((mt<T>) ((e) obj));
    }

    @NonNull
    /* renamed from: b */
    public abstract T c();

    @NonNull
    public byte[] a(@NonNull T t) {
        return e.a(t);
    }
}
