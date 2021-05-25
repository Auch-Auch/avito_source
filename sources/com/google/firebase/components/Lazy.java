package com.google.firebase.components;

import com.google.firebase.inject.Provider;
public class Lazy<T> implements Provider<T> {
    public static final Object c = new Object();
    public volatile Object a = c;
    public volatile Provider<T> b;

    public Lazy(Provider<T> provider) {
        this.b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t = (T) this.a;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.a;
                if (t == obj) {
                    t = this.b.get();
                    this.a = t;
                    this.b = null;
                }
            }
        }
        return t;
    }
}
