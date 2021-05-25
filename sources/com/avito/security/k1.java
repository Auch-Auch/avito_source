package com.avito.security;

import java.io.Serializable;
public abstract class k1<R> implements i1<R>, Serializable {
    public k1(int i) {
    }

    @Override // java.lang.Object
    public String toString() {
        String a = l1.a(this);
        j1.a((Object) a, "Reflection.renderLambdaToString(this)");
        return a;
    }
}
