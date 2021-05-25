package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class jf {
    private final int a;
    @NonNull
    private final jj b;
    @Nullable
    private jg c;

    public jf(@NonNull Context context, @NonNull fb fbVar, int i) {
        this(new jj(context, fbVar), i);
    }

    private void b() {
        jg a3 = this.b.a();
        this.c = a3;
        int e = a3.e();
        int i = this.a;
        if (e != i) {
            this.c.a(i);
            c();
        }
    }

    private void c() {
        this.b.a(this.c);
    }

    @NonNull
    public ap a(@NonNull String str) {
        if (this.c == null) {
            b();
        }
        int b2 = b(str);
        if (this.c.c().contains(Integer.valueOf(b2))) {
            return ap.NON_FIRST_OCCURENCE;
        }
        ap apVar = this.c.b() ? ap.FIRST_OCCURRENCE : ap.UNKNOWN;
        if (this.c.d() < 1000) {
            this.c.b(b2);
        } else {
            this.c.a(false);
        }
        c();
        return apVar;
    }

    @VisibleForTesting
    public jf(@NonNull jj jjVar, int i) {
        this.a = i;
        this.b = jjVar;
    }

    private int b(@NonNull String str) {
        return str.hashCode();
    }

    public void a() {
        if (this.c == null) {
            b();
        }
        this.c.a();
        this.c.a(true);
        c();
    }
}
