package com.avito.security;

import java.io.Serializable;
public final class q<T> implements l<T>, Serializable {
    private d1<? extends T> a;
    private volatile Object b;
    private final Object c;

    public q(d1<? extends T> d1Var, Object obj) {
        j1.b(d1Var, "initializer");
        this.a = d1Var;
        this.b = s.a;
        this.c = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(d1 d1Var, Object obj, int i, h1 h1Var) {
        this(d1Var, (i & 2) != 0 ? null : obj);
    }

    @Override // com.avito.security.l
    public T a() {
        T t;
        T t2 = (T) this.b;
        s sVar = s.a;
        if (t2 != sVar) {
            return t2;
        }
        synchronized (this.c) {
            t = (T) this.b;
            if (t == sVar) {
                d1<? extends T> d1Var = this.a;
                j1.a(d1Var);
                t = (T) d1Var.a();
                this.b = t;
                this.a = null;
            }
        }
        return t;
    }

    public boolean b() {
        return this.b != s.a;
    }

    @Override // java.lang.Object
    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
