package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
public class OOMSoftReference<T> {
    public SoftReference<T> a = null;
    public SoftReference<T> b = null;
    public SoftReference<T> c = null;

    public void clear() {
        SoftReference<T> softReference = this.a;
        if (softReference != null) {
            softReference.clear();
            this.a = null;
        }
        SoftReference<T> softReference2 = this.b;
        if (softReference2 != null) {
            softReference2.clear();
            this.b = null;
        }
        SoftReference<T> softReference3 = this.c;
        if (softReference3 != null) {
            softReference3.clear();
            this.c = null;
        }
    }

    @Nullable
    public T get() {
        SoftReference<T> softReference = this.a;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void set(@Nonnull T t) {
        this.a = new SoftReference<>(t);
        this.b = new SoftReference<>(t);
        this.c = new SoftReference<>(t);
    }
}
