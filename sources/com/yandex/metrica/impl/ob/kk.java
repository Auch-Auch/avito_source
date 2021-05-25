package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class kk {
    @NonNull
    private final act a;
    @NonNull
    private final kg b;

    public interface a {
        void a();
    }

    public kk(@NonNull act act, @NonNull kg kgVar) {
        this.a = act;
        this.b = kgVar;
    }

    public void a(long j, @NonNull final a aVar) {
        this.a.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.kk.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aVar.a();
                } catch (Throwable unused) {
                }
            }
        }, j);
    }

    public void a(long j, boolean z) {
        this.b.a(j, z);
    }

    public void a() {
        this.b.a();
    }
}
