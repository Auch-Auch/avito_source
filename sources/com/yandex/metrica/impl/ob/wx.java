package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.d;
import com.yandex.metrica.impl.ob.vf;
public class wx {
    @NonNull
    private final wy a;
    @NonNull
    private final d b;

    public wx() {
        this(new wy(), xa.a());
    }

    public void a(@NonNull vf.a.b bVar) {
        this.b.a("provided_request_result", this.a.a(bVar));
    }

    public void b(@NonNull vf.a.C0361a aVar) {
        this.b.a("provided_request_send", this.a.a(aVar));
    }

    @VisibleForTesting
    public wx(@NonNull wy wyVar, @NonNull d dVar) {
        this.a = wyVar;
        this.b = dVar;
    }

    public void a(@NonNull vf.a.C0361a aVar) {
        this.b.a("provided_request_schedule", this.a.a(aVar));
    }
}
