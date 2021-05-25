package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class jj {
    @NonNull
    private final jh a;
    @NonNull
    private final ji b;
    @NonNull
    private final lp c;
    @NonNull
    private final String d;

    public jj(@NonNull Context context, @NonNull fb fbVar) {
        this(new ji(), new jh(), lv.a(context).c(fbVar), "event_hashes");
    }

    @NonNull
    public jg a() {
        try {
            byte[] a3 = this.c.a(this.d);
            if (dl.a(a3)) {
                return this.a.a(this.b.c());
            }
            return this.a.a(this.b.b(a3));
        } catch (Throwable unused) {
            return this.a.a(this.b.c());
        }
    }

    @VisibleForTesting
    public jj(@NonNull ji jiVar, @NonNull jh jhVar, @NonNull lp lpVar, @NonNull String str) {
        this.b = jiVar;
        this.a = jhVar;
        this.c = lpVar;
        this.d = str;
    }

    public void a(@NonNull jg jgVar) {
        this.c.a(this.d, this.b.a((ji) this.a.b(jgVar)));
    }
}
