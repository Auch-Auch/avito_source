package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.c;
public abstract class la {
    private final a a;
    @Nullable
    private final c b;

    public interface a {
        boolean a(Throwable th);
    }

    public la(a aVar, @Nullable c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    public void a(@NonNull ld ldVar) {
        if (this.a.a(ldVar.a())) {
            Throwable a3 = ldVar.a();
            c cVar = this.b;
            if (cVar == null || a3 == null || (a3 = cVar.a(a3)) != null) {
                b(new ld(a3, ldVar.c, ldVar.d, ldVar.e, ldVar.f));
            }
        }
    }

    public abstract void b(@NonNull ld ldVar);
}
