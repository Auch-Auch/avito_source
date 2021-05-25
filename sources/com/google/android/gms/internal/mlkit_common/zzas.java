package com.google.android.gms.internal.mlkit_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
public final class zzas extends WeakReference<Throwable> {
    private final int zza;

    public zzas(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzas.class) {
            if (this == obj) {
                return true;
            }
            zzas zzas = (zzas) obj;
            if (this.zza == zzas.zza && get() == zzas.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zza;
    }
}
