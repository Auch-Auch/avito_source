package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.cl;
import com.yandex.mobile.ads.impl.hv;
import java.util.List;
public final class cn implements cl.b {
    @NonNull
    private final cm a;
    @NonNull
    private final cl b;
    @NonNull
    private final t c;
    private boolean d;

    public cn(@NonNull Context context, @NonNull ck ckVar, @NonNull x xVar, @NonNull fo foVar, @NonNull t tVar, @Nullable List<String> list) {
        this.c = tVar;
        this.a = new cm(context, xVar, foVar, list);
        this.b = new cl(ckVar, this);
    }

    public final void a(@NonNull hv.a aVar) {
        this.a.a(aVar);
    }

    public final void b() {
        if (!this.d) {
            this.d = true;
            this.b.a();
        }
    }

    public final void c() {
        this.d = false;
        this.b.b();
    }

    @Override // com.yandex.mobile.ads.impl.cl.b
    public final void a() {
        this.a.a();
        this.c.b();
    }
}
