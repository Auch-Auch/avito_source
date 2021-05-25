package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
public final class dj {
    @NonNull
    private final Context a;
    @NonNull
    private final fo b;
    @Nullable
    private di c;

    public dj(@NonNull Context context, @NonNull fo foVar) {
        this.a = context.getApplicationContext();
        this.b = foVar;
    }

    public final void a(@Nullable dk dkVar) {
        if (dkVar != null) {
            this.c = new di(this.a, this.b, dkVar);
        }
    }

    public final void b() {
        di diVar = this.c;
        if (diVar != null) {
            diVar.b();
        }
    }

    public final void c() {
        di diVar = this.c;
        if (diVar != null) {
            diVar.c();
        }
    }

    public final void d() {
        di diVar = this.c;
        if (diVar != null) {
            diVar.e();
        }
    }

    public final void e() {
        di diVar = this.c;
        if (diVar != null) {
            diVar.f();
        }
    }

    public final void a() {
        di diVar = this.c;
        if (diVar != null) {
            diVar.a();
        }
    }

    public final void a(@NonNull hv.a aVar) {
        di diVar = this.c;
        if (diVar != null) {
            diVar.a(aVar);
        }
    }
}
