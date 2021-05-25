package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class gb {
    @NonNull
    private final mo a;
    @NonNull
    private final abt b;
    @NonNull
    private final dj c;
    @Nullable
    private yd d;
    private long e;

    public gb(@NonNull Context context, @NonNull fb fbVar) {
        this(new mo(lv.a(context).b(fbVar)), new abs(), new dj());
    }

    public boolean a(@Nullable Boolean bool) {
        yd ydVar;
        return aau.c(bool) && (ydVar = this.d) != null && this.c.b(this.e, ydVar.a, "should report diagnostic");
    }

    public void a() {
        long a3 = this.b.a();
        this.e = a3;
        this.a.f(a3).q();
    }

    public gb(@NonNull mo moVar, @NonNull abt abt, @NonNull dj djVar) {
        this.a = moVar;
        this.b = abt;
        this.c = djVar;
        this.e = moVar.k();
    }

    public void a(@Nullable yd ydVar) {
        this.d = ydVar;
    }
}
