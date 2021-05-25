package com.avito.security;

import java.util.Iterator;
public class a2 extends z1 {

    public static final class a implements Iterable<T> {
        public final /* synthetic */ u1 a;

        public a(u1 u1Var) {
            this.a = u1Var;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    public static <T> Iterable<T> a(u1<? extends T> u1Var) {
        j1.b(u1Var, "$this$asIterable");
        return new a(u1Var);
    }
}
