package com.jakewharton.rxrelay2;

import io.reactivex.functions.Predicate;
public class AppendOnlyLinkedArrayList<T> {
    public final Object[] a;
    public Object[] b;
    public int c;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        Object[] objArr = new Object[(i + 1)];
        this.a = objArr;
        this.b = objArr;
    }

    public void a(T t) {
        int i = this.c;
        if (i == 4) {
            Object[] objArr = new Object[5];
            this.b[4] = objArr;
            this.b = objArr;
            i = 0;
        }
        this.b[i] = t;
        this.c = i + 1;
    }
}
