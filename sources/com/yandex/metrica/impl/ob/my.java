package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.e;
public class my<T, P extends e> implements mx<T> {
    @NonNull
    private final String a;
    @NonNull
    private final lp b;
    @NonNull
    private final mw<P> c;
    @NonNull
    private final nh<T, P> d;

    public my(@NonNull String str, @NonNull lp lpVar, @NonNull mw<P> mwVar, @NonNull nh<T, P> nhVar) {
        this.a = str;
        this.b = lpVar;
        this.c = mwVar;
        this.d = nhVar;
    }

    @Override // com.yandex.metrica.impl.ob.mx
    public void a(@NonNull T t) {
        this.b.a(this.a, this.c.a(this.d.b(t)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.metrica.impl.ob.nh<T, P extends com.yandex.metrica.impl.ob.e> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.yandex.metrica.impl.ob.nh<T, P extends com.yandex.metrica.impl.ob.e> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.yandex.metrica.impl.ob.nh<T, P extends com.yandex.metrica.impl.ob.e> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.mx
    @NonNull
    public T a() {
        try {
            byte[] a3 = this.b.a(this.a);
            return dl.a(a3) ? (T) this.d.a(this.c.c()) : (T) this.d.a(this.c.b(a3));
        } catch (Throwable unused) {
            return (T) this.d.a(this.c.c());
        }
    }
}
