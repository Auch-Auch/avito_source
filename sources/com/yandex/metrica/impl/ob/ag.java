package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.gv;
public class ag<C extends gv> extends di<C> {
    @NonNull
    private final hb c;
    @NonNull
    private final mo d;
    private boolean e = false;

    public ag(@NonNull C c2, @NonNull yh yhVar, @NonNull hb hbVar, @NonNull mo moVar) {
        super(c2, yhVar);
        this.c = hbVar;
        this.d = moVar;
    }

    public void a(@NonNull aa aaVar) {
        if (!this.e) {
            super.f();
            a(new gx((ha) g(), aaVar, this.c, this.d));
        }
    }

    @Override // com.yandex.metrica.impl.ob.di, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = true;
    }
}
