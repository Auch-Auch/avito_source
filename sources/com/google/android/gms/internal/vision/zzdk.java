package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdk<T> implements zzdf<T> {
    @NullableDecl
    private T value;
    private volatile zzdf<T> zzmb;
    private volatile boolean zzmc;

    public zzdk(zzdf<T> zzdf) {
        this.zzmb = (zzdf) zzde.checkNotNull(zzdf);
    }

    @Override // com.google.android.gms.internal.vision.zzdf
    public final T get() {
        if (!this.zzmc) {
            synchronized (this) {
                if (!this.zzmc) {
                    T t = this.zzmb.get();
                    this.value = t;
                    this.zzmc = true;
                    this.zzmb = null;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj = this.zzmb;
        if (obj == null) {
            String valueOf = String.valueOf(this.value);
            obj = a.s2(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        }
        String valueOf2 = String.valueOf(obj);
        return a.s2(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }
}
