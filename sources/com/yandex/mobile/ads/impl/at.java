package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
public final class at implements au, jk {
    @NonNull
    private final a a;
    @NonNull
    private final av b;
    @Nullable
    private List<bo> c;
    @Nullable
    private x d;
    @NonNull
    private final t e;

    public interface a {
        void f();

        void g();
    }

    public at(@NonNull a aVar, @NonNull cs csVar, @NonNull t tVar) {
        this.a = aVar;
        this.e = tVar;
        this.b = new av(csVar);
    }

    private boolean d() {
        List<bo> list = this.c;
        return list != null && !list.isEmpty();
    }

    public final void a(@NonNull x xVar, @NonNull List<bo> list) {
        this.d = xVar;
        this.c = list;
        this.b.a();
    }

    @Override // com.yandex.mobile.ads.impl.jk
    public final void b() {
        if (!d()) {
            this.b.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.jk
    public final void d_() {
        if (!d()) {
            this.e.a();
            this.b.c();
            x xVar = this.d;
            if (xVar != null && xVar.A()) {
                this.a.g();
            }
            this.a.f();
        }
    }

    @Override // com.yandex.mobile.ads.impl.au
    public final void a() {
        if (d()) {
            this.e.a();
            x xVar = this.d;
            if (xVar != null && xVar.A()) {
                this.a.g();
            }
            this.a.f();
        }
    }
}
