package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.fk;
import java.io.Closeable;
public class di<C extends fk> implements Closeable {
    public final Object a = new Object();
    public boolean b = false;
    @NonNull
    private C c;
    @NonNull
    private final yh d;

    public di(@NonNull C c2, @NonNull yh yhVar) {
        this.c = c2;
        this.d = yhVar;
    }

    public void a() {
    }

    public void a(@NonNull ca caVar) {
        by r = as.a().r();
        if (r != null) {
            r.a(caVar);
        }
    }

    public void c() {
        this.d.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (!this.b) {
                a();
                this.b = true;
            }
        }
    }

    public void e() {
        synchronized (this.a) {
            if (!this.b) {
                f();
                a();
            }
        }
    }

    public void f() {
        synchronized (this.a) {
            if (!this.b) {
                c();
            }
        }
    }

    @NonNull
    public C g() {
        return this.c;
    }
}
