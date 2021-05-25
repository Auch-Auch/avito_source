package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
public class oz implements ov, ow {
    @NonNull
    private final fv a;
    private AtomicLong b;

    public oz(@NonNull lr lrVar, @NonNull fv fvVar) {
        this.a = fvVar;
        this.b = new AtomicLong(lrVar.b());
        lrVar.a(this);
    }

    @Override // com.yandex.metrica.impl.ob.ov
    public boolean a() {
        return this.b.get() >= ((long) ((we) this.a.d()).X());
    }

    @Override // com.yandex.metrica.impl.ob.ow
    public void b(@NonNull List<Integer> list) {
        this.b.addAndGet((long) (-list.size()));
    }

    @Override // com.yandex.metrica.impl.ob.ow
    public void a(@NonNull List<Integer> list) {
        this.b.addAndGet((long) list.size());
    }
}
