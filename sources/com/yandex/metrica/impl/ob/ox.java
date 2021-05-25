package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
public class ox {
    @NonNull
    private final List<ov> a;
    @NonNull
    private final oy b;
    private final AtomicBoolean c = new AtomicBoolean(true);

    public ox(@NonNull List<ov> list, @NonNull oy oyVar) {
        this.a = list;
        this.b = oyVar;
    }

    private void d() {
        if (this.a.isEmpty()) {
            e();
            return;
        }
        boolean z = false;
        for (ov ovVar : this.a) {
            z |= ovVar.a();
        }
        if (z) {
            e();
        }
    }

    private void e() {
        this.b.g();
    }

    public void a() {
        if (this.c.get()) {
            d();
        }
    }

    public void b() {
        this.c.set(true);
    }

    public void c() {
        this.c.set(false);
    }
}
