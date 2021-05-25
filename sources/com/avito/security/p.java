package com.avito.security;

import a2.b.a.a.a;
import java.io.Serializable;
public final class p<A, B> implements Serializable {
    private final A a;
    private final B b;

    public p(A a3, B b2) {
        this.a = a3;
        this.b = b2;
    }

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.b;
    }

    public final A c() {
        return this.a;
    }

    public final B d() {
        return this.b;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return j1.a(this.a, pVar.a) && j1.a(this.b, pVar.b);
    }

    @Override // java.lang.Object
    public int hashCode() {
        A a3 = this.a;
        int i = 0;
        int hashCode = (a3 != null ? a3.hashCode() : 0) * 31;
        B b2 = this.b;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder I = a.I('(');
        I.append((Object) this.a);
        I.append(", ");
        return a.q(I, this.b, ')');
    }
}
