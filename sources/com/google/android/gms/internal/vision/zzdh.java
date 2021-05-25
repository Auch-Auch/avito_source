package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdh<T> implements zzdf<T>, Serializable {
    @NullableDecl
    private transient T value;
    private final zzdf<T> zzmb;
    private volatile transient boolean zzmc;

    public zzdh(zzdf<T> zzdf) {
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
                    return t;
                }
            }
        }
        return this.value;
    }

    @Override // java.lang.Object
    public final String toString() {
        Object obj;
        if (this.zzmc) {
            String valueOf = String.valueOf(this.value);
            obj = a.s2(valueOf.length() + 25, "<supplier that returned ", valueOf, ">");
        } else {
            obj = this.zzmb;
        }
        String valueOf2 = String.valueOf(obj);
        return a.s2(valueOf2.length() + 19, "Suppliers.memoize(", valueOf2, ")");
    }
}
