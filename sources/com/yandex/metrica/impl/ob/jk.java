package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.TimeUnit;
public abstract class jk implements jn<jp> {
    private final fe a;
    @NonNull
    private final jt b;
    private final jx c;
    private final js d;

    public jk(@NonNull fe feVar, @NonNull jt jtVar, @NonNull jx jxVar, @NonNull js jsVar) {
        this.a = feVar;
        this.b = jtVar;
        this.c = jxVar;
        this.d = jsVar;
    }

    @NonNull
    private jq b(@NonNull jp jpVar) {
        long a3 = this.b.a();
        jx d2 = this.c.d(a3);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        d2.b(timeUnit.toSeconds(jpVar.a)).e(jpVar.a).a(0).a(true).h();
        this.a.j().a(a3, this.d.a(), timeUnit.toSeconds(jpVar.b));
        return b();
    }

    @Override // com.yandex.metrica.impl.ob.jn
    @Nullable
    public final jo a() {
        if (this.c.i()) {
            return new jo(this.a, this.c, b());
        }
        return null;
    }

    @NonNull
    public final jo a(@NonNull jp jpVar) {
        if (this.c.i()) {
            xa.a().reportEvent("create session with non-empty storage");
        }
        return new jo(this.a, this.c, b(jpVar));
    }

    @VisibleForTesting
    @NonNull
    public jq b() {
        return jq.a(this.d).a(this.c.g()).c(this.c.d()).b(this.c.c()).a(this.c.b()).d(this.c.e()).e(this.c.f()).a();
    }
}
