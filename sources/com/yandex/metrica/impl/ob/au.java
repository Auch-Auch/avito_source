package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;
public class au {
    @NonNull
    private final act a;
    @NonNull
    private final aw b;
    @Nullable
    private Runnable c;

    public au(@NonNull act act, @NonNull aw awVar) {
        this.a = act;
        this.b = awVar;
    }

    public void b() {
        Runnable runnable = this.c;
        if (runnable != null) {
            this.a.b(runnable);
        }
    }

    public void c() {
        Runnable runnable = this.c;
        if (runnable != null) {
            this.a.b(runnable);
        }
        AnonymousClass1 r0 = new Runnable() { // from class: com.yandex.metrica.impl.ob.au.1
            @Override // java.lang.Runnable
            public void run() {
                au.this.b.a();
            }
        };
        this.c = r0;
        this.a.a(r0, 90, TimeUnit.SECONDS);
    }

    public void a() {
        c();
    }
}
