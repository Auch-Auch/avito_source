package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.impl.rr;
public final class sa<T> {
    public final T a;
    public final rr.a b;
    public final sl c;
    public boolean d;

    public interface a {
        void a(sl slVar);
    }

    public interface b<T> {
        void a(T t);
    }

    private sa(T t, rr.a aVar) {
        this.d = false;
        this.a = t;
        this.b = aVar;
        this.c = null;
    }

    public static <T> sa<T> a(T t, rr.a aVar) {
        return new sa<>(t, aVar);
    }

    public static <T> sa<T> a(sl slVar) {
        return new sa<>(slVar);
    }

    private sa(sl slVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = slVar;
    }
}
