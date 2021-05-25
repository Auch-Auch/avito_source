package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class pn {
    @Nullable
    private ql a;
    @NonNull
    private final lz b;
    @NonNull
    private final ly c;

    public pn(@Nullable ql qlVar, @NonNull lz lzVar, @NonNull ly lyVar) {
        this.a = qlVar;
        this.b = lzVar;
        this.c = lyVar;
    }

    private void b(@NonNull ql qlVar) {
        long a3 = this.b.a();
        int i = qlVar.f;
        if (a3 > ((long) i)) {
            this.b.c((int) (((float) i) * 0.1f));
        }
    }

    private void c(@NonNull ql qlVar) {
        long a3 = this.c.a();
        int i = qlVar.f;
        if (a3 > ((long) i)) {
            this.c.c((int) (((float) i) * 0.1f));
        }
    }

    public void a() {
        ql qlVar = this.a;
        if (qlVar != null) {
            b(qlVar);
            c(this.a);
        }
    }

    public void a(@Nullable ql qlVar) {
        this.a = qlVar;
    }
}
