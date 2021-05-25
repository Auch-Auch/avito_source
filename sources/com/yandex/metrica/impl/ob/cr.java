package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.fe;
import java.util.concurrent.TimeUnit;
public class cr<C extends fe> extends di<C> {
    private Runnable c = new Runnable() { // from class: com.yandex.metrica.impl.ob.cr.1
        @Override // java.lang.Runnable
        public void run() {
            cr.this.e();
        }
    };
    private final act d;

    public cr(@NonNull C c2, @NonNull yh yhVar, @NonNull act act) {
        super(c2, yhVar);
        this.d = act;
    }

    @Override // com.yandex.metrica.impl.ob.di
    public void a() {
        this.d.b(this.c);
    }

    public void b() {
        synchronized (this.a) {
            if (!this.b) {
                a();
                d();
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.di
    public void c() {
        super.c();
        we i = ((fe) g()).i();
        if (i.aa() && dl.a(i.c())) {
            try {
                a(cn.J().a((fe) g()));
            } catch (Throwable unused) {
            }
        }
    }

    @VisibleForTesting
    public void d() {
        if (((fe) g()).i().W() > 0) {
            this.d.a(this.c, TimeUnit.SECONDS.toMillis((long) ((fe) g()).i().W()));
        }
    }
}
