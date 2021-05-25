package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class aak {
    @NonNull
    private final abt a;
    @NonNull
    private final ay b;
    @NonNull
    private final aaa c;
    private final boolean d;
    private boolean e;
    private long f;

    public aak(boolean z) {
        this(z, new abs(), xa.a(), new aaa());
    }

    public void a() {
        this.f = this.a.a();
    }

    public void b() {
        this.b.reportEvent("ui_parsing_bridge_time", this.c.a(this.a.a() - this.f, this.d, this.e).toString());
    }

    public void a(boolean z) {
        this.e = z;
    }

    @VisibleForTesting
    public aak(boolean z, @NonNull abt abt, @NonNull ay ayVar, @NonNull aaa aaa) {
        this.e = false;
        this.d = z;
        this.a = abt;
        this.b = ayVar;
        this.c = aaa;
    }
}
