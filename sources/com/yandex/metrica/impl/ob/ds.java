package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ao;
public class ds {
    @NonNull
    private final Context a;
    @NonNull
    private final su b;
    @NonNull
    private final so c;
    @NonNull
    private final mq d;
    @NonNull
    private final ao.b e;

    public ds(@NonNull Context context) {
        this(context, new su());
    }

    public boolean a(@NonNull yb ybVar, @NonNull xi xiVar) {
        if (!this.e.a(ybVar.G, ybVar.F, xiVar.d)) {
            return false;
        }
        a(ybVar);
        if (this.c.c(this.a) && this.c.i(this.a)) {
            return true;
        }
        return false;
    }

    public boolean b(@NonNull yb ybVar, @NonNull xi xiVar) {
        a(ybVar);
        return ybVar.o.g && !dl.a(xiVar.b);
    }

    private ds(@NonNull Context context, @NonNull su suVar) {
        this(context, suVar, new so(suVar.a()), new mq(lv.a(context).c()), new ao.b());
    }

    private void a(@NonNull yb ybVar) {
        this.b.a(this.d.g());
        this.b.a(ybVar);
        this.c.a(this.b.a());
    }

    @VisibleForTesting
    public ds(@NonNull Context context, @NonNull su suVar, @NonNull so soVar, @NonNull mq mqVar, @NonNull ao.b bVar) {
        this.a = context;
        this.b = suVar;
        this.c = soVar;
        this.d = mqVar;
        this.e = bVar;
    }
}
